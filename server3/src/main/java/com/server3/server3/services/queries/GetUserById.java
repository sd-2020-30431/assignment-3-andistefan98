package com.server3.server3.services.queries;

public class GetUserById implements IRequest{

    int idUser;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public GetUserById(int id){
        this.idUser = id;

    }


}
