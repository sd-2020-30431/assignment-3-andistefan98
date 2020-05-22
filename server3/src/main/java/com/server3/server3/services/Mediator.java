package com.server3.server3.services;


import com.server3.server3.services.commands.*;
import com.server3.server3.services.handlers.*;
import com.server3.server3.services.queries.*;
import com.server3.server3.services.responses.GetAllListsResponse;
import com.server3.server3.services.responses.IResponse;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Mediator implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private final Map<Class<? extends IRequest>, Class<? extends IHandler<? extends IRequest, ? extends IResponse>>> handler;

    public Mediator() {
        this.handler = new HashMap<>();
        handler.put(GetAllItems.class, GetAllItemsHandler.class);
        handler.put(GetAllUsers.class, GetAllUsersHandler.class);
        handler.put(GetItemById.class, GetItemByIdHandler.class);
        handler.put(GetListById.class, GetListByIdHandler.class);
        handler.put(GetUserById.class,GetUserByIdHandler.class);
        handler.put(GetAllLists.class, GetAllListsHandler.class);

        handler.put(AddItemCommand.class,AddItemHandler.class);
        handler.put(AddListCommand.class,AddListHandler.class);
        handler.put(AddUserCommand.class,AddUserHandler.class);
        handler.put(DeleteItemCommand.class,DeleteItemHandler.class);
        handler.put(UpdateGoalCommand.class,UpdateGoalHandler.class);

    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    }

    public <T extends IRequest, R extends IResponse> IHandler<T,R> handle(T command){
        Class<? extends IHandler<? extends IRequest, ? extends IResponse>> whichHandler = handler.get(command.getClass());
        return (IHandler<T, R>)applicationContext.getBean(whichHandler);
    }


}
