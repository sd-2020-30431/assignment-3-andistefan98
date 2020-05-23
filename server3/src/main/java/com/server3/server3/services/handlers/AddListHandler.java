package com.server3.server3.services.handlers;

import com.server3.server3.entities.GroceryList;
import com.server3.server3.repositories.ListRepository;
import com.server3.server3.services.commands.AddListCommand;
import com.server3.server3.services.responses.AddListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddListHandler implements IHandler<AddListCommand, AddListResponse> {

    @Autowired
    private ListRepository listRepository;

    public AddListHandler(ListRepository listRepository){
        this.listRepository = listRepository;
    }


    @Override
    public AddListResponse handle(AddListCommand q) {

        GroceryList newLst = new GroceryList();

        newLst.setList_name(q.getList_name());

        newLst.setUser_id(Integer.parseInt(q.getUser_id()));
        listRepository.save(newLst);

        return new AddListResponse(newLst);
    }
}
