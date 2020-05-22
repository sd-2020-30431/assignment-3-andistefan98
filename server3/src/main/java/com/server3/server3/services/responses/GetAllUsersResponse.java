package com.server3.server3.services.responses;

import com.server3.server3.entities.User;

public class GetAllUsersResponse implements IResponse{

    Iterable<User> users;

    public Iterable<User> getUsers() {
        return users;
    }

    public GetAllUsersResponse(Iterable<User> usrs){
        this.users = usrs;
    }
}
