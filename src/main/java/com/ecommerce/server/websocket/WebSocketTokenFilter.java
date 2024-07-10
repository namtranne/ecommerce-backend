//package com.ecommerce.server.websocket;
//
//import com.ecommerce.server.security.JwtTokenProvider;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.simp.stomp.StompCommand;
//import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
//import org.springframework.messaging.support.ChannelInterceptor;
//import org.springframework.messaging.support.MessageHeaderAccessor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//
//@Component
//public class WebSocketTokenFilter implements ChannelInterceptor {
//    private final JwtTokenProvider jwtUtils;
//    private final UserDetailsService userDetailsService;
//
//    public WebSocketTokenFilter(JwtTokenProvider jwtUtils, UserDetailsService userDetailsService) {
//        this.jwtUtils = jwtUtils;
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Override
//    public Message<?> preSend(Message<?> message, MessageChannel channel) {
//        final StompHeaderAccessor accessor =
//                MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
//        if (StompCommand.CONNECT == accessor.getCommand()) {
//
//            String jwt = jwtUtils.parseJwt(accessor);
//            if (jwt != null && jwtUtils.validateToken(jwt)) {
//                String username = jwtUtils.getUsernameFromJwtToken(jwt);
//
//                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//                UsernamePasswordAuthenticationToken authentication =
//                        new UsernamePasswordAuthenticationToken(
//                                userDetails, null, userDetails.getAuthorities());
//                accessor.setUser(authentication);
//            }
//        }
//        return message;
//    }
//}