package com.ducat.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ducat.entities.Person;

@Repository
public interface PersonDao extends CrudRepository<Person, Integer>
{

}
