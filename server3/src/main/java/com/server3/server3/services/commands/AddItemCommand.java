package com.server3.server3.services.commands;

import com.server3.server3.services.queries.IRequest;

public class AddItemCommand implements IRequest {

    String listId;
    String name;

    public String getListId() {
        return listId;
    }

    public String getName() {
        return name;
    }

    public String getCalorie_value() {
        return calorie_value;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public String getPurchase_date() {
        return purchase_date;
    }

    public String getConsump_date() {
        return consump_date;
    }

    String calorie_value;
    String quantity;
    String expiration_date;
    String purchase_date;
    String consump_date;

    public AddItemCommand(String listId, String name, String calorie_value, String quantity, String expiration_date, String purchase_date, String consump_date) {

    this.listId = listId;
    this.name = name;
    this.calorie_value = calorie_value;
    this.quantity = quantity;
    this.expiration_date =expiration_date;
    this.purchase_date = purchase_date;
    this.consump_date = consump_date;

    }


}
