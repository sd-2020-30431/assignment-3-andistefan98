package com.server3.server3.services.responses;

import com.server3.server3.entities.Item;
import com.server3.server3.services.queries.GetItemById;

public class GetItemByIdResponse implements IResponse{

    Item item;

    public GetItemByIdResponse(Item item){

    this.item =item;
    }


}
