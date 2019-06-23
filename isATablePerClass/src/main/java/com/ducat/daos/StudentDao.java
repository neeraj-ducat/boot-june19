package com.ducat.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ducat.entities.Student;

@Repository
public interface StudentDao extends CrudRepository<Student, Integer>
{

}
