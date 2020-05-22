package com.server3.server3.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

//import com.example.waste.services.ItemService;

import com.server3.server3.entities.GroceryList;
import com.server3.server3.entities.Item;
import com.server3.server3.entities.User;
import com.server3.server3.repositories.ItemRepository;
import com.server3.server3.repositories.ListRepository;
import com.server3.server3.repositories.UserRepository;
import com.server3.server3.services.Mediator;
import com.server3.server3.services.handlers.GetAllItemsHandler;
import com.server3.server3.services.handlers.IHandler;
import com.server3.server3.services.queries.*;
import com.server3.server3.services.responses.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final ItemRepository itemRepository;
    private final Mediator mediator;
    private final ListRepository listRepository;
    private final UserRepository userRepository;


    public Iterable<Item> allItems(String userId) {
        GetAllItems query = new GetAllItems(userId);
        IHandler<GetAllItems, GetAllItemsResponse> handler = mediator.<GetAllItems, GetAllItemsResponse>handle(query);
        Iterable<Item> allItemsReq  = handler.handle(query).getItems();
        return allItemsReq;

    }

    public Iterable<GroceryList> allLists() {
        GetAllLists query = new GetAllLists();
        IHandler<GetAllLists, GetAllListsResponse> handler = mediator.<GetAllLists, GetAllListsResponse>handle(query);
        Iterable<GroceryList> allLists  = handler.handle(query).getLists();
        return allLists;
    }


    Item findItemById(int itemId ){
        GetItemById query = new GetItemById(itemId);
        IHandler<GetItemById, GetItemByIdResponse> handler = mediator.<GetItemById, GetItemByIdResponse>handle(query);
        Item item = handler.handle(query).getItem();
        return item;
    }

    GroceryList findListById(int listId ){
        GetListById query = new GetListById(listId);
        IHandler<GetListById, GetListByIdResponse> handler = mediator.<GetListById, GetListByIdResponse>handle(query);
        GroceryList list = handler.handle(query).getList();
        return list;
    }


    User findUserById(int id){
        GetUserById query = new GetUserById(id);
        IHandler<GetUserById, GetUserByIdResponse> handler = mediator.<GetUserById, GetUserByIdResponse>handle(query);
        User user = handler.handle(query).getUser();
        return user;
    }


    Iterable<User> allUsers(){
        return userRepository.findAll();
    }

}
