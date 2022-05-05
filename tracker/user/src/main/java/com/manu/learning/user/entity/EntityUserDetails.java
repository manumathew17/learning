package com.manu.learning.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userdetails")
public class EntityUserDetails {
    @Id
    @GeneratedValue
    private Integer id;
    private String email;
    private String firstname;
    private String lastname;
    private String landmark;
    private String district;
    private String state;
    private String country;
    private String primarycontactnum;
    private String secondarycontactnum;
}
