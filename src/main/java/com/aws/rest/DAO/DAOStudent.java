package com.aws.rest.DAO;

import com.aws.rest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DAOStudent extends JpaRepository<Student,Long> {

}
