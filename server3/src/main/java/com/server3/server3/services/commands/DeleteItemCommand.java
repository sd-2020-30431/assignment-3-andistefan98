package com.server3.server3.services.commands;

import com.server3.server3.services.queries.IRequest;

public class DeleteItemCommand implements IRequest {

    private String itemId;

    public String getItemId() {
        return itemId;
    }

    public DeleteItemCommand(String id){
        this.itemId =id;
    }

}
