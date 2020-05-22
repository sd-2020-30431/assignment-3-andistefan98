package com.server3.server3.services.responses;

public class UpdateGoalResponse implements IResponse{

    int goal;

    public int getGoal() {
        return goal;
    }

    public UpdateGoalResponse(int goal){
        this.goal = goal;
    }

}
