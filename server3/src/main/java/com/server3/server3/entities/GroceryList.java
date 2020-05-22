package com.server3.server3.entities;

import java.util.ArrayList;
import java.util.List;


import lombok.*;

import javax.persistence.*;


@Data
@Entity
@Table(name="lists")
public class GroceryList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int list_id;


    String list_name;

    int user_id;



}
