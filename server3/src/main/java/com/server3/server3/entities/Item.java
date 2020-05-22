package com.server3.server3.entities;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int quantity;

    float calorieValue;

    String purchaseDate;

    String expirationDate;

    String consumptionDate;

    int list;


}