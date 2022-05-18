package com.aws.rest.DAO;

import com.aws.rest.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface DAOStudent extends CrudRepository<Student,Long> {

}
