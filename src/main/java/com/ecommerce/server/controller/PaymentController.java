package com.ecommerce.server.controller;

import com.ecommerce.server.constant.PaymentMethod;
import com.ecommerce.server.dto.CartDTO;
import com.ecommerce.server.dto.PaymentRequestDTO;
import com.ecommerce.server.dto.PaymentResponse;
import com.ecommerce.server.entity.CartItem;
import com.ecommerce.server.entity.OrderDetails;
import com.ecommerce.server.entity.Products;
import com.ecommerce.server.repository.CartItemRepository;
import com.ecommerce.server.security.CustomUserDetails;
import com.ecommerce.server.service.OrderService;
import com.ecommerce.server.service.ProductsService;
import com.ecommerce.server.vnpay.VNPayConfiguration;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private OrderService orderService;

    @PostMapping("/create_payment")
    public ResponseEntity<?> createPayment(HttpServletRequest request, @RequestBody PaymentRequestDTO paymentRequestDTO) throws UnsupportedEncodingException {
//        long amount = Integer.parseInt(req.getParameter("amount"))*100;
//        request.g

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = "";
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails userDetails){
            Integer userId = userDetails.getUser().getId();
            String username = userDetails.getUser().getUsername();
            try {
                List<CartItem> cartItems = cartItemRepository.findAllByUserId(userId);
                OrderDetails order = orderService.createOrder(cartItems, userId, username, paymentRequestDTO);
                cartItemRepository.deleteAllByUserId(userId);
                if(paymentRequestDTO.getPaymentMethod().equals(PaymentMethod.CASH.toString())) {
                    PaymentResponse response = new PaymentResponse();
                    response.setStatus("OK");
                    response.setMessage("Successfully");
                    response.setUrl("https://g5tech.store/order/success");
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }
                long amount=(long)order.getTotal()*100;
                String vnp_TxnRef = VNPayConfiguration.getRandomNumber(8);
                String vnp_IpAddr = VNPayConfiguration.getIpAddress(request);

                String vnp_TmnCode = VNPayConfiguration.vnp_TmnCode;
                Map<String, String> vnp_Params = new HashMap<>();
                vnp_Params.put("vnp_Version", VNPayConfiguration.vnp_Version);
                vnp_Params.put("vnp_Command", VNPayConfiguration.vnp_Command);
                vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
                vnp_Params.put("vnp_Amount", String.valueOf(amount));
                vnp_Params.put("vnp_CurrCode", "VND");
                vnp_Params.put("vnp_BankCode", "NCB");
                vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
                vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
                vnp_Params.put("vnp_OrderType", VNPayConfiguration.orderType);
                vnp_Params.put("vnp_Locale", "vn");
                vnp_Params.put("vnp_IpAddr", vnp_IpAddr);
                vnp_Params.put("vnp_ReturnUrl", "https://g5tech.store/payment/success/" + order.getId());
                Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
                String vnp_CreateDate = formatter.format(cld.getTime());
                vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
                vnp_Params.put("vnp_TmnCode", "F9HS8VCW");

                cld.add(Calendar.MINUTE, 1500);
                String vnp_ExpireDate = formatter.format(cld.getTime());
                vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

                List fieldNames = new ArrayList(vnp_Params.keySet());
                Collections.sort(fieldNames);
                StringBuilder hashData = new StringBuilder();
                StringBuilder query = new StringBuilder();
                Iterator itr = fieldNames.iterator();
                while (itr.hasNext()) {
                    String fieldName = (String) itr.next();
                    String fieldValue = (String) vnp_Params.get(fieldName);
                    if ((fieldValue != null) && (fieldValue.length() > 0)) {
                        //Build hash data
                        hashData.append(fieldName);
                        hashData.append('=');
                        hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                        //Build query
                        query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                        query.append('=');
                        query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                        if (itr.hasNext()) {
                            query.append('&');
                            hashData.append('&');
                        }
                    }
                }
                String queryUrl = query.toString();
                String vnp_SecureHash = VNPayConfiguration.hmacSHA512(VNPayConfiguration.secretKey, hashData.toString());
                queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
                String paymentUrl = VNPayConfiguration.vnp_PayUrl + "?" + queryUrl;

                PaymentResponse response = new PaymentResponse();
                response.setStatus("OK");
                response.setMessage("Successfully");
                response.setUrl(paymentUrl);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            catch (Exception e) {
                PaymentResponse response = new PaymentResponse();
                response.setStatus("Fail");
                response.setMessage("Fail");
                response.setUrl("");
                return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
            }
        }
        PaymentResponse response = new PaymentResponse();
        response.setStatus("Fail");
        response.setMessage("Fail");
        response.setUrl("");
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping("/vnpay_return")
    public void vnpayReturn() {
        System.out.println("OK");
    }

}
