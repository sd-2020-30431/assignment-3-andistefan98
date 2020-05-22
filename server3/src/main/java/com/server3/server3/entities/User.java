package com.server3.server3.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    float caloric_goal;

    String password;

    String username;

}