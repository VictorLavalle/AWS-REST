package com.aws.rest.repository;

import com.aws.rest.DAO.DAOProfessor;
import com.aws.rest.entity.Professor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorRepository implements DAOProfessor {

    private final ArrayList <Professor> professors = new ArrayList<>();

    @Override
    public Professor get(long id) {
        return null;
    }

    @Override
    public List<Professor> getAll() {
        return null;
    }

    @Override
    public boolean update(Professor professor) {
        return false;
    }

    @Override
    public boolean save(Professor professor) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
