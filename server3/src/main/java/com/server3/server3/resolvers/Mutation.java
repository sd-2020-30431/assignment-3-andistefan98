package com.server3.server3.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import com.server3.server3.entities.GroceryList;
import com.server3.server3.entities.Item;
import com.server3.server3.entities.User;
import com.server3.server3.repositories.ItemRepository;
import com.server3.server3.repositories.ListRepository;
import com.server3.server3.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver{

    private final ItemRepository itemReposiory ;
    private final ListRepository listRepository ;
    private final UserRepository userRepository;

    public int addItem(String listId ,String name, String calorie_value , String quantity , String expiration_date , String purchase_date ,String consump_date){
        Item itm = new Item();
        itm.setCalorieValue(Float.parseFloat(calorie_value));
        itm.setExpirationDate(expiration_date);
        itm.setList(Integer.parseInt(listId));
        itm.setName(name);
        itm.setPurchaseDate(purchase_date);
        itm.setQuantity(Integer.parseInt(quantity));
        itm.setConsumptionDate(consump_date);

        itemReposiory.save(itm);

        return 1;
    }

    public int deleteItem(String itemId){

        itemReposiory.deleteById(Integer.parseInt(itemId));

        return 1;

    }

    public GroceryList addList(String user_id ,String list_name) {

        GroceryList newLst = new GroceryList();

        newLst.setList_name(list_name);

        newLst.setUser_id(Integer.parseInt(user_id));
        return listRepository.save(newLst);

    }


    public User addUser(String username, String password){

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setCaloric_goal(0);

        return userRepository.save(newUser);


    }


    int updateGoal(String user_id,String new_goal){

        Iterable<User> users =  userRepository.findAll();

        for(User usr : users){
            if(usr.getId()  - Integer.parseInt(user_id) == 0){
                usr.setCaloric_goal(Integer.parseInt(new_goal));
                userRepository.save(usr);
                break;
            }
        }

        return Integer.parseInt(new_goal);


    }


}
