package com.server3.server3.services.handlers;

import com.server3.server3.repositories.ListRepository;
import com.server3.server3.services.queries.GetAllLists;
import com.server3.server3.services.responses.GetAllListsResponse;

public class GetAllListsHandler implements IHandler<GetAllLists,GetAllListsResponse> {

    private ListRepository listRepository;

    @Override
    public GetAllListsResponse handle(GetAllLists q) {
        return new GetAllListsResponse(listRepository.findAll());
    }
}
