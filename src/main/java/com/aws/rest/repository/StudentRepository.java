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


    @Override
    public Student get(long id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public boolean update(Student student) {
        int index = getIndex(student.getId());
        if (index > -1) {
            students.set(index, student);
            return true;
        }
        return false;
    }

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
