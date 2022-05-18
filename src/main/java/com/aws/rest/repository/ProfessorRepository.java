package com.aws.rest.repository;

import com.aws.rest.DAO.DAOProfessor;
import com.aws.rest.entity.Professor;
import com.aws.rest.services.ServiceProfessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorRepository implements ServiceProfessor {

    @Autowired
    private DAOProfessor daoProfesor;

    /**
     * Function get Professor
     *
     * @param id
     * @return the index of the professor list
     */
    @Override
    public Professor get(long id) {
        return daoProfesor.findById(id).orElse(null);
    }

    /**
     * This function allow us to read the whole data of the list
     *
     * @return Data from the list 'professors'
     */
    @Override
    public List<Professor> getAll() {
        return (List<Professor>) daoProfesor.findAll();
    }


    /**
     * Function update
     *
     * @param professor
     * @return true or false and the new position of each element in the arraylist
     */
    @Override
    public boolean update(long id, Professor professor) {
        if (!daoProfesor.existsById(id)) {
            return false;
        }
        Optional<Professor> optionalProfesor = daoProfesor.findById(id);
        Professor profesorFromDB = optionalProfesor.get();
        profesorFromDB.setNombres(professor.getNombres());
        profesorFromDB.setApellidos(professor.getApellidos());
        profesorFromDB.setHorasClase(professor.getHorasClase());
        profesorFromDB.setNumeroEmpleado(professor.getNumeroEmpleado());

        daoProfesor.save(profesorFromDB);
        return true;
    }

    /**
     * Function save professor
     *
     * @param professor
     * @return new professor's values and save it into the arraylist
     */
    @Override
    public boolean save(Professor professor) {
        try {
            daoProfesor.save(professor);
            return true;
        }catch (Exception exception){
            System.out.println(exception.getMessage()+" Couldn't save the entity");
            return false;
        }
    }

    /**
     * Function delete
     *
     * @param id
     * @return true or false according to the answer of the function getIndex()
     */
    @Override
    public boolean delete(long id) {
        if (!daoProfesor.existsById(id)){
            return false;
        }
        daoProfesor.deleteById(id);
        return true;
    }
}
