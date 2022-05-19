package com.aws.rest.controller;

import com.aws.rest.entity.Professor;
import com.aws.rest.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @GetMapping(path = "/profesores")
    public List<Professor> getAll() {
        return professorRepository.getAll();
    }

    /**
     * Get professors from its repository
     *
     * @param id
     * @return the professor's id and the http status of the request
     */
    @GetMapping(path = "/profesores/{id}")
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
    @PostMapping(path = "/profesores", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addProfessor(@RequestBody @Valid Professor professor) {
        professorRepository.save(professor);
        List<Professor> professors = professorRepository.getAll();
        int size = professors.size();
        Professor lastProfessor;
        lastProfessor = professors.get(size-1);
        return new ResponseEntity<>("Professor Added " + "{\"id\":" +lastProfessor.getId()+'}', HttpStatus.CREATED);
    }


    /**
     * update Professor
     *
     * @param professor
     * @return http status of the post request from the update
     */
    @PutMapping(path = "/profesores/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateProfessor(@PathVariable long id, @RequestBody @Valid Professor professor) {
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
    @DeleteMapping(path = "/profesores/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable long id) {
        if (!professorRepository.delete(id)) {
            return new ResponseEntity<>("Professor: ", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Professor deleted", HttpStatus.OK);
    }

}
