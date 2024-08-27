package com.ecommerce.server.controller;


import com.ecommerce.server.constant.HttpStatusCode;
import com.ecommerce.server.dto.*;
import com.ecommerce.server.entity.Address;
import com.ecommerce.server.entity.User;
import com.ecommerce.server.repository.AddressesRepository;
import com.ecommerce.server.security.CustomUserDetails;
import com.ecommerce.server.security.JwtTokenProvider;
import com.ecommerce.server.security.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
@Slf4j
public class UsersController {
    @Autowired
    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AddressesRepository addressesRepository;

    @PostMapping("/login")
    public LoginResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }

    @PostMapping("/register")
    public LoginResponse registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        User user = new User(signUpRequest);
        userService.createUser(user);
        user = userService.getUserDetailByUsername(user.getUsername());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signUpRequest.getUsername(),
                        signUpRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }

    @GetMapping("/auth/userdetail")
    public User getUserDetail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = "";
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails userDetails) {
            username = userDetails.getUsername();
        }
        try {
            return userService.getUserDetailByUsername(username);
        }
        catch(Exception e) {
            log.info("User not found");
        }
        //need to handle error
        return new User();
    }

    @PostMapping("/auth/userdetail/edit")
    public ResponseEntity<?> editUserDetails(@RequestBody UserDetailRequest user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = "";
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails userDetails){
            username = userDetails.getUsername();
        }
        try {
            userService.updateUser(username, user);
            RequestResponse response = new RequestResponse();
            response.setStatus("OK");
            response.setMessage("Edit user's detail successfully!");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception e) {
            log.info("User not found");
        }

        RequestResponse response = new RequestResponse();
        response.setStatus("fail");
        response.setMessage("Cannot edit user's detail");
        //need to handle error
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }

    @PostMapping("/auth/user/address/add")
    public ResponseEntity<?> addNewAddress(@RequestBody Address address) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = "";
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails userDetails){
            username = userDetails.getUsername();
            Integer userId = userService.getUserDetailByUsername(username).getId();
            address.setUserId(userId);
            addressesRepository.save(address);
            RequestResponse response = new RequestResponse();
            response.setStatus("OK");
            response.setMessage("Add user address successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        RequestResponse response = new RequestResponse();
        response.setStatus("Fail");
        response.setMessage("Add user address fail");
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping("/auth/user/address")
    public ResponseEntity<?> getUserAddresses() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = "";
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails userDetails){
            username = userDetails.getUsername();
            Integer userId = userService.getUserDetailByUsername(username).getId();
            List<Address> addresses = addressesRepository.findByUserId(userId);
            return new ResponseEntity<>(addresses, HttpStatus.OK);
        }
        RequestResponse response = new RequestResponse();
        response.setStatus("Fail");
        response.setMessage("Add user address fail");
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping("/admin/user")
    public ResponseEntity<GetUsersDTO> getAllUsers() {
        try {
            List<User> users = userService.getAllUsers();
            GetUsersDTO response = new GetUsersDTO(HttpStatusCode.OK, users);
            return new ResponseEntity<GetUsersDTO>(response, HttpStatus.OK);
        }
        catch(Exception e) {
            GetUsersDTO response = new GetUsersDTO(HttpStatusCode.INTERNAL_SERVER_ERROR, null);
            return new ResponseEntity<GetUsersDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}