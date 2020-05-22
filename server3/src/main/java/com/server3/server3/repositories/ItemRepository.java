package com.server3.server3.repositories;
import java.util.List;


import com.server3.server3.entities.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ItemRepository extends CrudRepository<Item, Integer>{


}
