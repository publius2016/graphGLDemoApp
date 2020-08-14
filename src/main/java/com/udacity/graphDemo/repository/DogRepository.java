package com.udacity.graphDemo.repository;

import com.udacity.graphDemo.entity.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {

}
