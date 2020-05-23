package com.server3.server3.services.handlers;

import com.server3.server3.entities.User;
import com.server3.server3.repositories.UserRepository;
import com.server3.server3.services.commands.AddUserCommand;
import com.server3.server3.services.responses.AddUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddUserHandler implements IHandler<AddUserCommand, AddUserResponse> {

    @Autowired
    private UserRepository userRepository;

    public AddUserHandler(UserRepository userRepository){
        this.userRepository =userRepository;
    }

    @Override
    public AddUserResponse handle(AddUserCommand q) {
        User newUser = new User();
        newUser.setUsername(q.getUsername());
        newUser.setPassword(q.getPassword());
        newUser.setCaloric_goal(0);

        userRepository.save(newUser);

        return new AddUserResponse(newUser);
    }
}
