package com.preslavsystem.preslavsystem.controllers;

import com.preslavsystem.preslavsystem.models.Course;
import com.preslavsystem.preslavsystem.repositories.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/courses")
public class CourseController {
    @Autowired
    ICourseRepository courseRepository;
    //REST
    //SHOW
    //http://localhost:8080/courses (get custom method)
    @GetMapping
    public ResponseEntity getCoursesWithFilter(
            //place all params
            @RequestParam(required = false,name = "name") String name,
            @RequestParam(required = false, name = "nameStartsWith") String nameStartsWith,
            @RequestParam(required = false, name = "descriptionContaining") String descriptionContaining

    ){
        //http://localhost:8080/courses?name=data%20structures
        if(name != null){
            return new ResponseEntity<>(courseRepository.findByNameIgnoreCase(name), HttpStatus.OK);
        }
        //http://localhost:8080/courses?nameStartsWith=a
        if(nameStartsWith != null){
            return new ResponseEntity<>(courseRepository.findByNameIgnoreCaseStartingWith(nameStartsWith),HttpStatus.OK);
        }
        //http://localhost:8080/courses?descriptionContaining=data
        if(descriptionContaining != null){
            return new ResponseEntity<>(courseRepository.findByDescriptionContainingIgnoreCase(descriptionContaining),HttpStatus.OK);
        }

        return new ResponseEntity(courseRepository.findAll(), HttpStatus.OK);
    }
    //SHOW BY ID
    //http://localhost:8080/courses/2 (get custom method)
    @GetMapping(value = "/{id}")
    public ResponseEntity getCourseById(@PathVariable Long id){
        return new ResponseEntity(courseRepository.findById(id), HttpStatus.OK);
    }
    //CREATE
    //http://localhost:8080/courses (post custom method)
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        //save into H2
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }
    //UPDATE
    //http://localhost:8080/courses/3 (put custom method)
    @PutMapping(value = "/{id}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course, @PathVariable Long id){
        //find course want to update..save it into H2
        Course courseToUpdate = courseRepository.findById(id).get();//Optional ??..condition check??
        courseToUpdate.setName(course.getName());
        courseToUpdate.setDescription(course.getDescription());
        courseToUpdate.setType(course.getType());
        courseToUpdate.setCategory(course.getCategory());

        courseRepository.save(courseToUpdate);

        return new ResponseEntity<>(courseToUpdate, HttpStatus.OK);
    }
    //REMOVE
    //http://localhost:8080/courses/1 (delte custom method)
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> removeCourse(@PathVariable Long id){
        courseRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
