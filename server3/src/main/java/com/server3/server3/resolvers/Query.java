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
import com.server3.server3.services.commands.*;
import com.server3.server3.services.handlers.IHandler;
import com.server3.server3.services.queries.*;
import com.server3.server3.services.responses.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final ItemRepository itemRepository;
    private final Mediator mediator;
    private final ListRepository listRepository;
    private final UserRepository userRepository;





    public Iterable<Item> allItems(String userId) {
        GetAllItemsQuery query = new GetAllItemsQuery(userId);
        IHandler<GetAllItemsQuery, GetAllItemsResponse> handler = mediator.<GetAllItemsQuery, GetAllItemsResponse>getHandler(query);
        Iterable<Item> allItemsReq  = handler.handle(query).getItems();
        return allItemsReq;

    }

    public Iterable<GroceryList> allLists() {
        GetAllListsQuery query = new GetAllListsQuery();
        IHandler<GetAllListsQuery, GetAllListsResponse> handler = mediator.<GetAllListsQuery, GetAllListsResponse>getHandler(query);
        Iterable<GroceryList> allLists  = handler.handle(query).getLists();
        return allLists;
    }


    Item findItemById(int itemId ){
        GetItemByIdQuery query = new GetItemByIdQuery(itemId);
        IHandler<GetItemByIdQuery, GetItemByIdResponse> handler = mediator.<GetItemByIdQuery, GetItemByIdResponse>getHandler(query);
        Item item = handler.handle(query).getItem();
        return item;
    }

    GroceryList findListById(int listId ){
        GetListByIdQuery query = new GetListByIdQuery(listId);
        IHandler<GetListByIdQuery, GetListByIdResponse> handler = mediator.<GetListByIdQuery, GetListByIdResponse>getHandler(query);
        GroceryList list = handler.handle(query).getList();
        return list;
    }


    User findUserById(int id){
        GetUserByIdQuery query = new GetUserByIdQuery(id);
        IHandler<GetUserByIdQuery, GetUserByIdResponse> handler = mediator.<GetUserByIdQuery, GetUserByIdResponse>getHandler(query);
        User user = handler.handle(query).getUser();
        return user;
    }


    Iterable<User> allUsers(){
        return userRepository.findAll();
    }

}
