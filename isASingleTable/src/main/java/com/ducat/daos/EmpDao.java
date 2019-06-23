package com.ducat.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ducat.entities.Emp;

@Repository
public interface EmpDao extends CrudRepository<Emp, Integer>
{

}
