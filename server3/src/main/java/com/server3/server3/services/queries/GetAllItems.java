package com.server3.server3.services.queries;

public class GetAllItems implements IRequest{

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private String userId;

    public GetAllItems(String id){
        this.userId = userId;
    }
}
