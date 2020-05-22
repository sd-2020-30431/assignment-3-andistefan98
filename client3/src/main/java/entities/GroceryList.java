package entities;

import java.util.ArrayList;
import java.util.List;

public class GroceryList {

	
	int list_id;
	
	
	String listName;
	
	int user_id;
	
	
	
	
	//User userId ;
	
	public GroceryList(int list_id , String name) {
		
		//this.userId= user;
		
		this.listName = name;
	}
	
	
	public GroceryList() {
		
	}
	
	
	public int getId() {
		return list_id;
	}

	public void setId(int id) {
		this.list_id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public int getUserId() {
		return user_id;
	}
	
	public void setUserId(int idd) {
		this.user_id = idd;
	}


  @Override
public String toString() {
	return listName ;
	  
  }

	
	

}
