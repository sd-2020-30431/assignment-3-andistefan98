package com.server3.server3.services.handlers;

import com.server3.server3.repositories.UserRepository;
import com.server3.server3.services.queries.GetAllUsers;
import com.server3.server3.services.responses.GetAllUsersResponse;
import org.springframework.stereotype.Component;

@Component
public class GetAllUsersHandler implements IHandler<GetAllUsers, GetAllUsersResponse> {

    private UserRepository userRepository;

    @Override
    public GetAllUsersResponse handle(GetAllUsers q) {
        return new GetAllUsersResponse(userRepository.findAll());
    }
}
