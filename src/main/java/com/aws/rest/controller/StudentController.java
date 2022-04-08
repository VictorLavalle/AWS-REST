package com.aws.rest.controller;

import com.aws.rest.entity.Student;
import com.aws.rest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/", produces = "application/json")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    /**
     * Get all the  'Students' objects
     * @return the JSON of 'professor' objects
     */
    @GetMapping(path = "/alumnos")
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    /**
     * Get Student from its repository
     *
     * @param id
     * @return the student's id and the http status of the request
     */
    @GetMapping(path = "/alumnos/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id) {
        Student student = studentRepository.get(id);
        if (student == null
        ) {
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
    @PostMapping(path = "/alumnos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addStudent(@RequestBody @Valid Student student) {
        studentRepository.save(student);
        return new ResponseEntity<>("Student Added" , HttpStatus.CREATED);
    }

    /**
     * update Student
     *
     * @param student
     * @return http status of the post request from the update
     */
    @PutMapping(path = "/alumnos/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateStudent(@PathVariable Long id , @Valid @RequestBody Student student) {
        if (!studentRepository.update(id, student)) {
            return new ResponseEntity<>("Student: " , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Student Updated" , HttpStatus.OK);
    }

    /**
     * delete Student
     *
     * @param id
     * @return http status of the post request from the delete
     */
    @DeleteMapping(path = "/alumnos/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id) {
        if (!studentRepository.delete(id)) {
            return new ResponseEntity<>("Student: " , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Student deleted" ,HttpStatus.OK);
    }

}
