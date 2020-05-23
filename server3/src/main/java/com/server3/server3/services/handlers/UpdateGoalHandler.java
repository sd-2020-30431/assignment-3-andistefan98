package com.server3.server3.services.handlers;

import com.server3.server3.entities.User;
import com.server3.server3.repositories.UserRepository;
import com.server3.server3.services.commands.UpdateGoalCommand;
import com.server3.server3.services.responses.UpdateGoalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateGoalHandler implements  IHandler<UpdateGoalCommand, UpdateGoalResponse> {

    @Autowired
    private UserRepository userRepository;

    public UpdateGoalHandler(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public UpdateGoalResponse handle(UpdateGoalCommand q) {

        Iterable<User> users =  userRepository.findAll();

        for(User usr : users){
            if(usr.getId()  - Integer.parseInt(q.getUser_id()) == 0){
                usr.setCaloric_goal(Integer.parseInt(q.getNew_goal()));
                userRepository.save(usr);
                break;
            }
        }

        System.out.println("new goal in handler" + q.getNew_goal());
        return new UpdateGoalResponse(Integer.parseInt(q.getNew_goal()));
    }

}
