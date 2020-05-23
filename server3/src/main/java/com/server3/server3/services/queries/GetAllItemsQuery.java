package com.server3.server3.services.queries;

public class GetAllItemsQuery implements IRequest{

    public String getUserId() {
        return userId;
    }

    private String userId;

    public GetAllItemsQuery(String id){
        this.userId = id;
    }
}
