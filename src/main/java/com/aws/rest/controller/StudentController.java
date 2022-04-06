package com.aws.rest.controller;

import com.aws.rest.entity.Student;
import com.aws.rest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/", produces = "application/json")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;



    @GetMapping(path = "/students")
    public List<Student> getAll (){
        return  studentRepository.getAll();
    }

    /**
     * Get Student from the repository
     *
     * @param id
     * @return the student's id and the http status of the request
     */
    @GetMapping(path = "/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id) {
        Student student = studentRepository.get(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }


    /**
     * Add Student into the arraylist
     *
     * @param student
     * @return http status of the post request
     */
    @PostMapping(path = "/students")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**update Student
     * @param student
     * @return http status of the post request from the update
     */
    @PutMapping(path = "/students/{id}")
    public ResponseEntity<HttpStatus> updateStudent(@RequestBody Student student) {
        if (!studentRepository.update(student)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * delete Student
     * @param id
     * @return http status of the post request from the delete
     */
    @DeleteMapping(path = "/students/{id}")
    public ResponseEntity<HttpResponse> deleteStudent(@PathVariable long id) {
        if (!studentRepository.delete(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
