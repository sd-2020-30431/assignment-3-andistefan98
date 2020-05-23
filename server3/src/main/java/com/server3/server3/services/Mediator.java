package com.server3.server3.services;


import com.server3.server3.services.commands.*;
import com.server3.server3.services.handlers.*;
import com.server3.server3.services.queries.*;
import com.server3.server3.services.responses.IResponse;
import org.jetbrains.annotations.NotNull;
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
        handler = new HashMap<>();
        handler.put(GetAllItemsQuery.class, GetAllItemsHandler.class);
        handler.put(GetAllUsersQuery.class, GetAllUsersHandler.class);
        handler.put(GetItemByIdQuery.class, GetItemByIdHandler.class);
        handler.put(GetListByIdQuery.class, GetListByIdHandler.class);
        handler.put(GetUserByIdQuery.class,GetUserByIdHandler.class);
        handler.put(GetAllListsQuery.class, GetAllListsHandler.class);
        handler.put(AddItemCommand.class,AddItemHandler.class);
        handler.put(AddListCommand.class,AddListHandler.class);
        handler.put(AddUserCommand.class,AddUserHandler.class);
        handler.put(DeleteItemCommand.class,DeleteItemHandler.class);
        System.out.println("AICIII");
        handler.put(UpdateGoalCommand.class,UpdateGoalHandler.class);

    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public <T extends IRequest, R extends IResponse> IHandler<T,R> getHandler( T command){
        Class<? extends IHandler<? extends IRequest, ? extends IResponse>> whichHandler = handler.get(command.getClass());
        return (IHandler<T, R>)applicationContext.getBean(whichHandler);
    }


}
