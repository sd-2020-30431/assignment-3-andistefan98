package com.server3.server3.services.responses;

import com.server3.server3.entities.GroceryList;

public class AddListResponse implements IResponse{
    GroceryList list;

    public AddListResponse(GroceryList list){
        this.list =list;
    }
}
