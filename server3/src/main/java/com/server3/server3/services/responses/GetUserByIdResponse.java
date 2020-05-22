package com.server3.server3.services.responses;

import com.server3.server3.entities.User;

public class GetUserByIdResponse implements IResponse{

    User user;

    public GetUserByIdResponse(User user){
        this.user = user;
    }

}
