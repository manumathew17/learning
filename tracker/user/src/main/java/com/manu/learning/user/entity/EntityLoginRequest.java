package com.manu.learning.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "login")
public class EntityLoginRequest {
    @Id
    private Integer id;
    private String username;
    private String password;
}
