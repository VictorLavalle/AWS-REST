package com.aws.rest.controller;

import com.aws.rest.entity.Professor;
import com.aws.rest.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/", produces = "application/json")
public class ProfessorController {

    @Autowired
    ProfessorRepository professorRepository;

    /**
     * Get all the  'Professor' objects
     *
     * @return the JSON of 'professor' objects
     */
    @GetMapping(path = "/professors")
    public List<Professor> getAll() {
        return professorRepository.getAll();
    }

    /**
     * Get professors from its repository
     *
     * @param id
     * @return the professor's id and the http status of the request
     */
    @GetMapping(path = "/professors/{id}")
    public ResponseEntity<Professor> getTeacher(@PathVariable long id) {
        Professor professor = professorRepository.get(id);
        if (professor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(professor, HttpStatus.OK);
    }


    /**
     * Add Professor into the arraylist
     *
     * @param professor
     * @return http status of the post request
     */
    @PostMapping(path = "/professors")
    public ResponseEntity<String> addProfessor(@RequestBody @Validated Professor professor) {
        professorRepository.save(professor);
        return new ResponseEntity<>("Professor Added", HttpStatus.CREATED);
    }


    /**
     * update Professor
     *
     * @param professor
     * @return http status of the post request from the update
     */
    @PutMapping(path = "/professors/{id}")
    public ResponseEntity<String> updateProfessor(@PathVariable Long id, @RequestBody @Validated Professor professor) {
        if (!professorRepository.update(id, professor)) {
            return new ResponseEntity<>("Professor: ", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Professor updated", HttpStatus.OK);
    }

    /**
     * delete Professor
     *
     * @param id
     * @return http status of the post request from the delete
     */
    @DeleteMapping(path = "/professors/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable long id) {
        if (!professorRepository.delete(id)) {
            return new ResponseEntity<>("Professor: ", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Professor deleted", HttpStatus.OK);
    }

}
