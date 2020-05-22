package com.server3.server3.services.responses;

import com.server3.server3.entities.GroceryList;

public class GetListByIdResponse implements IResponse{
    GroceryList list;

    public GetListByIdResponse(GroceryList list){
        this.list =list;
    }
}
