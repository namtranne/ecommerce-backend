package com.ecommerce.server.entity;

import com.ecommerce.server.dto.SignUpRequest;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    private int id;


    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    private String avatar;

    @Column(name="birth_of_date")
    private Date birthDay;

    private String password;


    public User() {

    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(SignUpRequest signUpRequest) {
        this.firstName = signUpRequest.getFirstName();
        this.lastName = signUpRequest.getLastName();
        this.username = signUpRequest.getUsername();
        this.password = signUpRequest.getPassword();
        this.email = signUpRequest.getEmail();
        this.birthDay = signUpRequest.getBirthDay();
        this.phoneNumber = signUpRequest.getPhoneNumber();
    }

    public User(int id, String username, String firstName, String lastName, String email, String phoneNumber, String avatar, Date birthDay) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.birthDay = birthDay;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
