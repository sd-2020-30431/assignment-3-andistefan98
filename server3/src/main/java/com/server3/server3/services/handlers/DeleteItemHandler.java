package com.server3.server3.services.handlers;

import com.server3.server3.repositories.ItemRepository;
import com.server3.server3.services.commands.DeleteItemCommand;
import com.server3.server3.services.responses.DeleteItemResponse;
import org.springframework.stereotype.Component;

@Component
public class DeleteItemHandler implements IHandler<DeleteItemCommand, DeleteItemResponse> {

    private ItemRepository itemRepository;


    @Override
    public DeleteItemResponse handle(DeleteItemCommand q) {

        itemRepository.deleteById(Integer.parseInt(q.getItemId()));

        return new DeleteItemResponse(1);
    }
}
