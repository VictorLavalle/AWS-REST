package com.aws.rest.repository;

import com.aws.rest.DAO.DAOProfessor;
import com.aws.rest.entity.Professor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorRepository implements DAOProfessor {

    private final ArrayList<Professor> professors = new ArrayList<>();

    /**
     * Function getIndex
     *
     * @param id
     * @return the index of the arraylist or -1
     */
    private int getIndex(long id) {
        int index = -1;
        if (professors.isEmpty()) return index;
        for (Professor professor : professors) {
            index++;
            if (professor.getId().equals(id)) {
                return index;
            }
        }
        return -1;
    }


    /**
     * Function get student id
     *
     * @param id
     * @return the ID of each professor in the professor arraylist
     */
    @Override
    public Professor get(long id) {
        for (Professor professor : professors) {
            if (professor.getId().equals(id)) {
                return professor;
            }
        }
        return null;
    }


    /**
     * This function allow us to read the whole data of the arraylist
     *
     * @return Data from the arraylist 'students'
     */
    @Override
    public List<Professor> getAll() {
        return professors;
    }


    /**
     * Function update
     *
     * @param professor
     * @return true or false and the new position of each element in the arraylist
     */
    @Override
    public boolean update(long id , Professor professor) {
        int index = getIndex(id);
        if (index > -1) {
            professors.set(index, professor);
            return true;
        }
        return false;
    }

    /**
     * Function save professor
     *
     * @param professor
     * @return new professor's values and save it into the arraylist
     */
    @Override
    public boolean save(Professor professor) {
        return professors.add(professor);
    }

    /**
     * Function delete
     *
     * @param id
     * @return true or false according to the answer of the function getIndex()
     */
    @Override
    public boolean delete(long id) {
        int index = getIndex(id);
        if (index > -1) {
            professors.remove(index);
            return true;
        }
        return false;
    }
}
