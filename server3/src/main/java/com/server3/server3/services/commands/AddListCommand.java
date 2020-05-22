package com.server3.server3.services.commands;

import com.server3.server3.services.queries.IRequest;

public class AddListCommand implements IRequest {

    String user_id;
    String list_name;

    public String getUser_id() {
        return user_id;
    }

    public String getList_name() {
        return list_name;
    }

    public AddListCommand(String id, String name){
        this.user_id = id;
        this.list_name = name;
    }
}
