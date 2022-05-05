package com.manu.learning.user.entity;

import lombok.Data;


@Data
public class UserEntity {
    private String email;
    private String firstname;
    private String lastname;
    private String landmark;
    private String district;
    private String state;
    private String country;
    private String primarycontactnum;
    private String secondarycontactnum;
    private String password;
}
