package com.server3.server3.repositories;


import com.server3.server3.entities.GroceryList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends CrudRepository<GroceryList, Integer> {


}
