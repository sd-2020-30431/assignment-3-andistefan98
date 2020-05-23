package com.server3.server3.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import com.server3.server3.entities.GroceryList;
import com.server3.server3.entities.User;
import com.server3.server3.repositories.ItemRepository;
import com.server3.server3.repositories.ListRepository;
import com.server3.server3.repositories.UserRepository;
import com.server3.server3.services.Mediator;
import com.server3.server3.services.commands.*;
import com.server3.server3.services.handlers.IHandler;
import com.server3.server3.services.responses.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver{

    private final ItemRepository itemReposiory ;
    private final ListRepository listRepository ;
    private final Mediator mediator;
    private final UserRepository userRepository;

    public int addItem(String listId ,String name, String calorie_value , String quantity , String expiration_date , String purchase_date ,String consump_date){

        AddItemCommand mutation = new AddItemCommand(listId,name,calorie_value,quantity,expiration_date,purchase_date,consump_date);
        IHandler<AddItemCommand, AddItemResponse> handler = mediator.<AddItemCommand, AddItemResponse>getHandler(mutation);
        int val = handler.handle(mutation).getValue();
        return val;

    }

    public int deleteItem(String itemId){

        DeleteItemCommand mutation = new DeleteItemCommand(itemId);
        IHandler<DeleteItemCommand, DeleteItemResponse> handler = mediator.<DeleteItemCommand, DeleteItemResponse>getHandler(mutation);
        int val = handler.handle(mutation).getValue();
        return val;

    }

    public GroceryList addList(String user_id ,String list_name) {

        AddListCommand mutation = new AddListCommand(user_id,list_name);
        IHandler<AddListCommand, AddListResponse> handler = mediator.<AddListCommand, AddListResponse>getHandler(mutation);
        GroceryList list = handler.handle(mutation).getList();
        return list;

    }


    public User addUser(String username, String password){

        AddUserCommand mutation = new AddUserCommand(username,password);
        IHandler<AddUserCommand, AddUserResponse> handler = mediator.<AddUserCommand, AddUserResponse>getHandler(mutation);
        User user = handler.handle(mutation).getUser();
        return user;


    }


    int updateGoal(String user_id,String new_goal){

        UpdateGoalCommand query = new  UpdateGoalCommand(user_id,new_goal);
        IHandler<UpdateGoalCommand, UpdateGoalResponse> handler = mediator.<UpdateGoalCommand, UpdateGoalResponse>getHandler(query);
        int goal = handler.handle(query).getGoal();
        return goal;


    }


}
