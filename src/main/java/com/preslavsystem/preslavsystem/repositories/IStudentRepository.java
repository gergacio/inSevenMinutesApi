package com.preslavsystem.preslavsystem.repositories;

import com.preslavsystem.preslavsystem.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    //derived queries - retrieve data from database

    public List<Student> findByFirstNameIgnoreCase(String firstName);
    public List<Student> findByLastNameIgnoreCase(String lastName);
    public List<Student> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);
    public List<Student> findByFirstNameContainingIgnoreCase(String firstNameContaining);
    public List<Student> findByLastNameContainingIgnoreCase(String lastNameContaining);
    public List<Student> findByLastNameIgnoreCaseStartingWith(String lastNameStartWith);
    public List<Student> findByEmailIgnoreCaseStartingWith(String emailStaringWith);


}
