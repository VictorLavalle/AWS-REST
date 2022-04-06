package com.aws.rest.repository;

import com.aws.rest.DAO.DAOStudent;
import com.aws.rest.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements DAOStudent {

    private final List<Student> students = new ArrayList<>();

    /**
     * Function getIndex
     * @param id
     * @return the index of the arraylist or -1
     */
    private int getIndex(long id) {
        int index = -1;
        if (students.isEmpty()) return index;
        for (Student student : students) {
            index++;
            if (student.getId().equals(id)) {
                return index;
            }
        }
        return -1;
    }


    /**
     * Function get student id
     * @param id
     * @return the ID of each student in the students arraylist
     */
    @Override
    public Student get(long id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }


    /**
     * This function allow us to read the whole data of the arraylist
     * @return Data from the arraylist 'students'
     */
    @Override
    public List<Student> getAll() {
        return students;
    }


    /**
     * Function update
     * @param student
     * @return true or false and the new position of each element in the arraylist
     */
    @Override
    public boolean update(Student student) {
        int index = getIndex(student.getId());
        if (index > -1) {
            students.set(index, student);
            return true;
        }
        return false;
    }


    /**
     * Function save student
     * @param student
     * @return new student's value and save it into the arraylist
     */
    @Override
    public boolean save(Student student) {
        if (!students.isEmpty()) {
            int lastIndex = students.size() - 1;
            long id = students.get(lastIndex).getId() + 1;
            student.setId(id);
            return students.add(student);
        }
        student.setId(1L);
        return students.add(student);
    }


    /**
     * Function delete
     * @param id
     * @return true or false according to the answer of the function getIndex()
     */
    @Override
    public boolean delete(long id) {
        int index = getIndex(id);
        if (index > -1) {
            students.remove(index);
            return true;
        }
        return false;
    }

}
