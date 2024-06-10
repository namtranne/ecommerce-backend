package com.eazybytes.springdeploy.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String avatar;

    @Column(name = "first_name")
    private String firstName;

    public void setId(int id) {
        this.id = id;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "last_name")
    private String lastName;

    public int getId() {
        return id;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
