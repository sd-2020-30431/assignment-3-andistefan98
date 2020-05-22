package com.server3.server3.services.queries;

public class GetItemById implements IRequest{

    int itemId;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public GetItemById(int id){
        this.itemId = id;
    }

}
