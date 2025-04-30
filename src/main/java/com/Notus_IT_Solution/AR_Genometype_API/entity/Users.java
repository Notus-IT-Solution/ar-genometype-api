package com.Notus_IT_Solution.AR_Genometype_API.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    // default constructor for springboot
    public Users() {
    }

    // parameter constructor for input
    public Users(UserType userType) {
        this.userType = userType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
