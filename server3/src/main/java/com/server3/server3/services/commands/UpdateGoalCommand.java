package com.server3.server3.services.commands;

import com.server3.server3.services.queries.IRequest;

public class UpdateGoalCommand implements IRequest {

    String user_id;
    String new_goal;

    public String getUser_id() {
        return user_id;
    }

    public String getNew_goal() {
        return new_goal;
    }

    public UpdateGoalCommand(String id, String goal){
        this.user_id = id;
        System.out.println("new goal " + goal);
        this.new_goal = goal;
    }

}
