package com.server3.server3.services.queries;

public class GetListByIdQuery implements IRequest{

    int listId;

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public GetListByIdQuery(int id){
        this.listId = id;
    }

}
