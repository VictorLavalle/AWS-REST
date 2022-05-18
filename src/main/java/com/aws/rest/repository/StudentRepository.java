package com.aws.rest.repository;

import com.aws.rest.DAO.DAOStudent;
import com.aws.rest.entity.Student;
import com.aws.rest.services.ServiceStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentRepository implements ServiceStudent {

    @Autowired
    private DAOStudent daoStudent;


    /**
     * Function get student id
     *
     * @param id
     * @return the ID of each student in the students list
     */
    @Override
    public Student get(long id) {
        return daoStudent.findById(id).orElse(null);
    }


    /**
     * This function allow us to read the whole data of the arraylist
     *
     * @return Data from the arraylist 'students'
     */
    @Override
    public List<Student> getAll() {
        return (List<Student>) daoStudent.findAll();
    }


    /**
     * Function update
     *
     * @param student
     * @return true or false and the new position of each element in the arraylist
     */
    @Override
    public boolean update(long id, Student student) {
        if (!daoStudent.existsById(id)){
            return false;
        }
        Optional<Student> studentOptional = daoStudent.findById(id);
        Student studentFromDB = studentOptional.get();

        studentFromDB.setNombres(student.getNombres());
        studentFromDB.setApellidos(student.getApellidos());
        studentFromDB.setMatricula(student.getMatricula());
        studentFromDB.setPromedio(student.getPromedio());

        daoStudent.save(studentFromDB);
        return true;
    }


    /**
     * Function save student
     *
     * @param student
     * @return new student's values and save it
     */
    @Override
    public boolean save(Student student) {
        try {
            daoStudent.save(student);
            return true;
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }
    }


    /**
     * Function delete
     *
     * @param id
     * @return true or false
     */
    @Override
    public boolean delete(long id) {
        if (!daoStudent.existsById(id)){
            return false;
        }
        daoStudent.deleteById(id);
        return true;
    }

}
