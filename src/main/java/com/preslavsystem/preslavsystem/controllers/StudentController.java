package com.preslavsystem.preslavsystem.controllers;

import com.preslavsystem.preslavsystem.models.Student;
import com.preslavsystem.preslavsystem.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/students")
public class StudentController {
    @Autowired
    IStudentRepository studentRepository;
    //Insomnia Test
    //SHOW
    //http://localhost:8080/students (get custom method)
    @GetMapping
    public ResponseEntity<List<Student>> getStudentsWithFilter(
            //place params
            @RequestParam(required = false, name = "firstName") String firstName,
            @RequestParam(required = false, name= "lastName") String lastName,
            @RequestParam(required = false, name="firstNameContaining") String firstNameContaining,
            @RequestParam(required = false, name="lastNameContaining") String lastNameContaining,
            @RequestParam(required = false ,name = "lastNameStartsWith") String lastNameStartsWith,
            @RequestParam(required = false, name = "emailStartsWith") String emailStartsWith

    ){
        //if statements
        //http://localhost:8080/students?firstName=Mike&&lastName=tyson
        if(firstName != null && lastName != null){
            return new ResponseEntity<>(studentRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, lastName), HttpStatus.OK);
        }
        //http://localhost:8080/students?firstName=Mike
        if(firstName != null) {
            return new ResponseEntity<>(studentRepository.findByFirstNameIgnoreCase(firstName), HttpStatus.OK);
        }
        //http://localhost:8080/students?lastName=Joshua
        if(lastName != null){
            return new ResponseEntity<>(studentRepository.findByLastNameIgnoreCase(lastName), HttpStatus.OK);
        }
        //http://localhost:8080/students?firstNameContaining=mi
        if (firstNameContaining != null ){
            return new ResponseEntity<>(studentRepository.findByFirstNameContainingIgnoreCase(firstNameContaining), HttpStatus.OK);
        }
        //http://localhost:8080/students?lastNameContaining=ty
        if (lastNameContaining != null ){
            return new ResponseEntity<>(studentRepository.findByLastNameContainingIgnoreCase(lastNameContaining), HttpStatus.OK);
        }
        // http://localhost:8080/students?lastNameStartsWith=t
        if(lastNameStartsWith != null) {
            return new ResponseEntity(studentRepository.findByLastNameIgnoreCaseStartingWith(lastNameStartsWith), HttpStatus.OK);
        }
        //http://localhost:8080/students?emailStartsWith=a
        if(emailStartsWith != null){
            return new ResponseEntity<>(studentRepository.findByEmailIgnoreCaseStartingWith(emailStartsWith), HttpStatus.OK);
        }

        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }
    //SHOW BY ID
    //http://localhost:8080/students/1 (get custom method)
    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        return new ResponseEntity(studentRepository.findById(id), HttpStatus.OK);
    }
    //CREATE
    //http://localhost:8080/students (post method)
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        //save it to H2
        studentRepository.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }
    //UPDATE
    //http://localhost:8080/students/4 (put custom method)
    @PutMapping(value = "/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Long id){
        //find and update student with given one
        Student foundStudent = studentRepository.findById(id).get();
        foundStudent.setFirstName(student.getFirstName());
        foundStudent.setLastName(student.getLastName());
        foundStudent.setUserName(student.getUserName());
        foundStudent.setAge(student.getAge());
        foundStudent.setEmail(student.getEmail());
        foundStudent.setWallet(student.getWallet());
        //save it to H2
        studentRepository.save(foundStudent);
        return new ResponseEntity<>(foundStudent, HttpStatus.CREATED);
    }
    //REMOVEx§
    //http://localhost:8080/students/4 (delete custom method)
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> removeStudentById(@PathVariable Long id){
        studentRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
