package com.server3.server3.services.commands;

import com.server3.server3.services.queries.IRequest;

public class AddUserCommand implements IRequest {

   String username;
   String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public AddUserCommand(String user, String pass){
       this.username = user;
       this.password = pass;
   }

}

