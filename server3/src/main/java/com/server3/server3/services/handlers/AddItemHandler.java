package com.server3.server3.services.handlers;

import com.server3.server3.entities.Item;
import com.server3.server3.repositories.ItemRepository;
import com.server3.server3.services.commands.AddItemCommand;
import com.server3.server3.services.responses.AddItemResponse;
import org.springframework.stereotype.Component;

@Component
public class AddItemHandler implements IHandler<AddItemCommand, AddItemResponse> {

    private ItemRepository itemRepository;


    @Override
    public AddItemResponse handle(AddItemCommand q) {

        Item itm = new Item();
        itm.setCalorieValue(Float.parseFloat(q.getCalorie_value()));
        itm.setExpirationDate(q.getExpiration_date());
        itm.setList(Integer.parseInt(q.getListId()));
        itm.setName(q.getName());
        itm.setPurchaseDate(q.getPurchase_date());
        itm.setQuantity(Integer.parseInt(q.getQuantity()));
        itm.setConsumptionDate(q.getConsump_date());

        itemRepository.save(itm);

        return new AddItemResponse(1);
    }
}
