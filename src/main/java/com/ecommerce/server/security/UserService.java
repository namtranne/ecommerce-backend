package com.ecommerce.server.security;

import com.ecommerce.server.dto.SignUpRequest;
import com.ecommerce.server.dto.UserDetailRequest;
import com.ecommerce.server.entity.User;
import com.ecommerce.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsManager {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }

    public User getUserDetailByUsername (String username) {
        User user = userRepository.getUserDetailByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        user.setPassword("");
        return user;
    }


    public UserDetails loadUserById(Integer userId) {
        User user = userRepository.findByUserId(userId);
        if (user == null) {
            throw new UsernameNotFoundException(Integer.toString(userId));
        }
        return new CustomUserDetails(user);
    }

    @Override
    public void createUser(UserDetails userDetails) {
        User user = (User) userDetails;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Set other properties of user from userDetails if needed
        userRepository.save(user);
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    public void updateUser(String username, UserDetailRequest user) {
        User newUser = userRepository.findFullUserByUsername(username);
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setBirthDay(user.getBirthDay());
        userRepository.save(newUser);
    }
}
