package com.server3.server3.services.responses;

public class DeleteItemResponse implements IResponse{

    int value;

    public int getValue() {
        return value;
    }

    public DeleteItemResponse(int value){
        this.value = value;
    }
}
