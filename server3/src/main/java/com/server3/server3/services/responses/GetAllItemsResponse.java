package com.server3.server3.services.responses;

import com.server3.server3.entities.Item;

public class GetAllItemsResponse implements IResponse{

    Iterable<Item> items;

    public Iterable<Item> getItems() {
        return items;
    }

    public GetAllItemsResponse(Iterable<Item> itm){
        this.items =itm;
    }

}
