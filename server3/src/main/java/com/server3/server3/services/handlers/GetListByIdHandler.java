package com.server3.server3.services.handlers;

import com.server3.server3.repositories.ListRepository;
import com.server3.server3.services.queries.GetListById;
import com.server3.server3.services.responses.GetListByIdResponse;
import org.springframework.stereotype.Component;

@Component
public class GetListByIdHandler implements IHandler<GetListById, GetListByIdResponse> {

    private ListRepository listRepository;

    @Override
    public GetListByIdResponse handle(GetListById q) {
        return new GetListByIdResponse(listRepository.findById(q.getListId()).get());
    }
}
