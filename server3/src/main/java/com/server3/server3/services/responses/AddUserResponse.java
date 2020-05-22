package com.server3.server3.services.responses;

import com.server3.server3.entities.User;

public class AddUserResponse implements IResponse{

    User user;

    public AddUserResponse(User user){
        this.user = user;
    }
}
