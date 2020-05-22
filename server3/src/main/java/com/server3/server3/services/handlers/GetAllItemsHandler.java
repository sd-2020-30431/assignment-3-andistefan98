package com.server3.server3.services.handlers;

import com.server3.server3.entities.GroceryList;
import com.server3.server3.entities.Item;
import com.server3.server3.repositories.ItemRepository;
import com.server3.server3.repositories.ListRepository;
import com.server3.server3.services.queries.GetAllItems;
import com.server3.server3.services.responses.GetAllItemsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllItemsHandler implements IHandler<GetAllItems, GetAllItemsResponse> {

    private ItemRepository itemRepository;
    private  ListRepository listRepository;

    @Override
    public GetAllItemsResponse handle(GetAllItems q) {
        Iterable<GroceryList> lists = listRepository.findAll();
        List<GroceryList> reqLists = new ArrayList<>();
        Iterable<Item> allItems = itemRepository.findAll();
        List<Item> reqItems = new ArrayList<>();

        for(GroceryList lst : lists){
            int idd = lst.getUser_id();
            if( Integer.parseInt(q.getUserId()) - idd == 0 ){
                reqLists.add(lst);
            }
        }

        for(Item itm : allItems){

            int itmList = itm.getList();
            for(GroceryList lst : reqLists){
                if(itmList - lst.getList_id() == 0){
                    reqItems.add(itm);
                }
            }
        }

        return new GetAllItemsResponse(reqItems);
    }
}
