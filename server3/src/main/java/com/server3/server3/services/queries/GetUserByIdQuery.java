package com.server3.server3.services.queries;

public class GetUserByIdQuery implements IRequest{

    int idUser;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public GetUserByIdQuery(int id){
        this.idUser = id;

    }


}
