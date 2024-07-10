package com.ecommerce.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    private int id;
    private String avatar;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "username")
    private String username;

    private String password;

    private String email;

    public User() {

    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Column(name = "last_name")
    private String lastName;

}
