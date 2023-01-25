package com.preslavsystem.preslavsystem.repositories;

import com.preslavsystem.preslavsystem.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILessonRepository extends JpaRepository<Lesson, Long> {
    //derived queries - retrieve data from database
    public List<Lesson> findByTitleIgnoreCase(String title);
    public List<Lesson> findByTitleIgnoreCaseStartingWith(String titleStartsWith);
    public List<Lesson> findByTitleContainingIgnoreCase(String titleContaining);
    public List<Lesson> findByContentContainingIgnoreCase(String contentContaining);
    public List<Lesson> findByLearningObjectiveContainingIgnoreCase(String learningObjective);
    public List<Lesson> findByLearningGoalContainingIgnoreCase(String learningGoal);
    public List<Lesson> findByDuration(int duration);

}
