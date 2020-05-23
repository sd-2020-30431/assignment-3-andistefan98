package com.server3.server3.services.handlers;

import com.server3.server3.entities.Item;
import com.server3.server3.repositories.ItemRepository;
import com.server3.server3.services.queries.GetItemByIdQuery;
import com.server3.server3.services.responses.GetItemByIdResponse;
import org.springframework.stereotype.Component;

@Component
public class GetItemByIdHandler implements IHandler<GetItemByIdQuery, GetItemByIdResponse> {

    private ItemRepository itemRepository;

    @Override
    public GetItemByIdResponse handle(GetItemByIdQuery q) {
        Item itm  = (Item)itemRepository.findById(q.getItemId()).get();
        return new GetItemByIdResponse(itm);
    }
}
