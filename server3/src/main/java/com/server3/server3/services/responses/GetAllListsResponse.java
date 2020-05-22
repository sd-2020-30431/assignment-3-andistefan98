package com.server3.server3.services.responses;

import com.server3.server3.entities.GroceryList;

public class GetAllListsResponse implements IResponse{

    Iterable<GroceryList> lists;

    public Iterable<GroceryList> getLists() {
        return lists;
    }

    public GetAllListsResponse(Iterable<GroceryList> lists){
        this.lists =lists;
    }
}
