package com.server3.server3.services.handlers;

import com.server3.server3.repositories.UserRepository;
import com.server3.server3.services.queries.GetUserByIdQuery;
import com.server3.server3.services.responses.GetUserByIdResponse;
import org.springframework.stereotype.Component;

@Component
public class GetUserByIdHandler implements  IHandler<GetUserByIdQuery, GetUserByIdResponse> {

    private UserRepository userRepository;


    @Override
    public GetUserByIdResponse handle(GetUserByIdQuery q) {
        return new GetUserByIdResponse(userRepository.findById(q.getIdUser()).get());
    }
}
