package com.preslavsystem.preslavsystem.repositories;


import com.preslavsystem.preslavsystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {
    //derived queries
    public List<Course> findByNameIgnoreCase(String name);
    public List<Course> findByNameIgnoreCaseStartingWith(String nameStartsWith);
    public List<Course> findByDescriptionContainingIgnoreCase(String descriptionContaining);

}