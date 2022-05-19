package com.aws.rest.DAO;

import com.aws.rest.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DAOProfessor extends JpaRepository<Professor,Long> {
}
