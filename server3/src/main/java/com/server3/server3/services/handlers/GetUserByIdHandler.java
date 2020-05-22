package com.server3.server3.services.handlers;

import com.server3.server3.repositories.UserRepository;
import com.server3.server3.services.queries.GetUserById;
import com.server3.server3.services.responses.GetUserByIdResponse;
import org.springframework.stereotype.Component;

@Component
public class GetUserByIdHandler implements  IHandler<GetUserById, GetUserByIdResponse> {

    private UserRepository userRepository;


    @Override
    public GetUserByIdResponse handle(GetUserById q) {
        return new GetUserByIdResponse(userRepository.findById(q.getIdUser()).get());
    }
}
