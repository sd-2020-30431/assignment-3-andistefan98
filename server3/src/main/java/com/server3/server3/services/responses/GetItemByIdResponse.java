package com.server3.server3.services.responses;

import com.server3.server3.entities.Item;

public class GetItemByIdResponse implements IResponse{

    Item item;

    public Item getItem() {
        return item;
    }

    public GetItemByIdResponse(Item item){

    this.item =item;
    }


}
