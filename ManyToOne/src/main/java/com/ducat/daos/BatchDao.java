package com.ducat.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ducat.entities.Batch;

@Repository
public interface BatchDao extends CrudRepository<Batch, Integer>
{

}
