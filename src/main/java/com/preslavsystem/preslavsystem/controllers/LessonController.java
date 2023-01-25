package com.preslavsystem.preslavsystem.controllers;

import com.preslavsystem.preslavsystem.models.Lesson;
import com.preslavsystem.preslavsystem.repositories.ILessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/lessons")
public class LessonController {
    //REST
    @Autowired
    ILessonRepository lessonRepository;

    //Insomnia test
    //SHOW
    //http://localhost:8080/lessons
    @GetMapping
    public ResponseEntity getLessonsWithFilter(
            //place params
            @RequestParam(required = false,name = "title") String title,
            @RequestParam(required = false, name="titleStartsWith") String titleStartsWith,
            @RequestParam(required = false, name = "titleContaining") String titleContaining,
            @RequestParam(required = false, name = "contentContaining") String contentContaining,
            @RequestParam(required = false, name = "learningObjective") String learningObjective,
            @RequestParam(required = false, name = "learningGoal") String learningGoal,
            @RequestParam(required = false, name = "duration") Integer duration
    ){
        //if statements
        //Test in browser

        //http://localhost:8080/lessons?title=array
        if(title != null){
            return new ResponseEntity<>(lessonRepository.findByTitleIgnoreCase(title), HttpStatus.OK);
        }
        //http://localhost:8080/lessons?titleStartsWith=l
        if(titleStartsWith != null){
            return new ResponseEntity<>(lessonRepository.findByTitleIgnoreCaseStartingWith(titleStartsWith), HttpStatus.OK);
        }
        //http://localhost:8080/lessons?titleContaining=sort
        if(titleContaining != null){
            return new ResponseEntity<>(lessonRepository.findByTitleContainingIgnoreCase(titleContaining), HttpStatus.OK);
        }
        //http://localhost:8080/lessons?contentContaining=array
        if(contentContaining != null){
            return new ResponseEntity<>(lessonRepository.findByContentContainingIgnoreCase(contentContaining),HttpStatus.OK);
        }
        //http://localhost:8080/lessons?learningObjective=list
        if(learningObjective != null){
            return new ResponseEntity<>(lessonRepository.findByLearningObjectiveContainingIgnoreCase(learningObjective),HttpStatus.OK);
        }
        http://localhost:8080/lessons?learningGoal=list
        if(learningGoal != null){
            return new ResponseEntity<>(lessonRepository.findByLearningGoalContainingIgnoreCase(learningGoal),HttpStatus.OK);
        }
        //http://localhost:8080/lessons?duration=120
        if(duration != null){
            return new ResponseEntity<>(lessonRepository.findByDuration(duration),HttpStatus.OK);
        }



        return new ResponseEntity(lessonRepository.findAll(), HttpStatus.OK);
    }
    //SHOW_BY_ID
    //http://localhost:8080/lessons/1
    @GetMapping(value = "/{id}")
    public ResponseEntity getLessonById(@PathVariable Long id){

        return new ResponseEntity(lessonRepository.findById(id), HttpStatus.OK);
    }
    //CREATE
    //http://localhost:8080/lessons (post custom method)
    @PostMapping
    public ResponseEntity<Lesson> createLesson(@RequestBody Lesson lesson){
        //save it to H2
        lessonRepository.save(lesson);
        return new ResponseEntity<>(lesson, HttpStatus.CREATED);
    }
    //UPDATE
    //http://localhost:8080/lessons/3 (put custom method)
    @PutMapping(value = "/{id}")
    public ResponseEntity<Lesson> updateLesson(@RequestBody Lesson lesson, @PathVariable Long id){

        Lesson foundLesson = lessonRepository.findById(id).get();
        foundLesson.setTitle(lesson.getTitle());
        foundLesson.setLearningObjective(lesson.getLearningObjective());
        foundLesson.setLearningGoal(lesson.getLearningGoal());
        foundLesson.setDuration(lesson.getDuration());
        foundLesson.setContent(lesson.getContent());

        //save it to H2
        lessonRepository.save(foundLesson);
        return new ResponseEntity<>(foundLesson, HttpStatus.CREATED);
    }
    //REMOVE
    //http://localhost:8080/lessons/4 (delete custom method)
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> removeLessonById(@PathVariable Long id){
        lessonRepository.deleteById(id);

        return new ResponseEntity<>(id, HttpStatus.OK);

    }

}