package com.ducat.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ducat.entities.Country;

@Repository
public interface CountryDao extends CrudRepository<Country, Integer>
{

}
