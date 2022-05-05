package com.manu.learning.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

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
    private String apikey;

    public EntityUserDetails( String email, String firstname, String lastname, String landmark, String district, String state, String country, String primarycontactnum, String secondarycontactnum, String apikey) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.landmark = landmark;
        this.district = district;
        this.state = state;
        this.country = country;
        this.primarycontactnum = primarycontactnum;
        this.secondarycontactnum = secondarycontactnum;
        this.apikey = apikey;
    }
}
