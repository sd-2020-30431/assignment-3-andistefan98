package business;

import java.io.IOException;
import java.util.List;

import entities.User;
import requests.UserRequests;

public class SignUpValidator {
	
	
	
	public static boolean checkIfUserValid(User user) throws IOException {
		//UserRepository userRepo = new UserRepository() ;
		
         if(user.getUsername().length() < 4)
        	 return false;
         if(user.getPassword().length()<1)
        	 return false;
         
         List<User> users =UserRequests.getAll();
         
         int ok = 0;
         
         for(User usr: users) {
        	 System.out.println(usr.getUsername());
        	 
        	 if(user.getUsername().equals(usr.getUsername()))
        		 ok=1;
   
         }
         
         if(ok==1)
          return false;         
         
       
       return true;
         
	}

}
