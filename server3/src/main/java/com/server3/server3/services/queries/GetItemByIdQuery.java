package com.server3.server3.services.queries;

public class GetItemByIdQuery implements IRequest{

    int itemId;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public GetItemByIdQuery(int id){
        this.itemId = id;
    }

}
