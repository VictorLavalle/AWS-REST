package com.aws.rest.DAO;

import com.aws.rest.entity.Professor;
import org.springframework.data.repository.CrudRepository;

public interface DAOProfessor extends CrudRepository<Professor,Long> {
}
