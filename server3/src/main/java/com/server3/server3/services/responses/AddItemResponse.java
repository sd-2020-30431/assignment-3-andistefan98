package com.server3.server3.services.responses;

public class AddItemResponse implements IResponse{

    int value;

    public int getValue() {
        return value;
    }

    public AddItemResponse(int value){
        this.value = value;
    }

}
