package com.preslavsystem.preslavsystem.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.Length;
import org.hibernate.annotations.Type;

import java.sql.Blob;

@Entity
@Table(name = "lessons")
public class Lesson {
    //POJO
    //state
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "learning_objective")
    private String learningObjective;
    @Column(name = "learning_goal")
    private String learningGoal;

    @Column(name = "content",length = Length.LOB_DEFAULT)
    private String content;
    @Column(name = "duration")
    private int duration;

    @ManyToOne
    @JsonIgnoreProperties({"lessons"})
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    //initialize course!


    //controllers
    public Lesson(){}

    public Lesson(String title, String learningObjective, String learningGoal, String content, int duration, Course course) {
        this.title = title;
        this.learningObjective = learningObjective;
        this.learningGoal = learningGoal;
        this.content = content;
        this.duration = duration;
        this.course = course;


    }
    //getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLearningObjective() {
        return learningObjective;
    }

    public void setLearningObjective(String learningObjective) {
        this.learningObjective = learningObjective;
    }

    public String getLearningGoal() {
        return learningGoal;
    }

    public void setLearningGoal(String learningGoal) {
        this.learningGoal = learningGoal;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}

