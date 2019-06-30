package com.ducat.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ducat.entities.Trainer;

@Repository
public interface TrainerDao extends CrudRepository<Trainer, Integer>
{

}
