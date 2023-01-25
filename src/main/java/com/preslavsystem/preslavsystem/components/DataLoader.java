package com.preslavsystem.preslavsystem.components;

import com.preslavsystem.preslavsystem.models.Booking;
import com.preslavsystem.preslavsystem.models.Course;
import com.preslavsystem.preslavsystem.models.Lesson;
import com.preslavsystem.preslavsystem.models.Student;
import com.preslavsystem.preslavsystem.repositories.IBookingRepository;
import com.preslavsystem.preslavsystem.repositories.ICourseRepository;
import com.preslavsystem.preslavsystem.repositories.ILessonRepository;
import com.preslavsystem.preslavsystem.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataLoader implements ApplicationRunner {
    //inject instances as dependencies
    @Autowired
    IStudentRepository studentRepository;
    @Autowired
    ICourseRepository courseRepository;
    @Autowired
    IBookingRepository bookingRepository;
    @Autowired
    ILessonRepository lessonRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //create and save Student instances into database--------------------------------------------------------------
        Student student1 = new Student("Antony", "Joshua",
                "AJ", "aj@gmail.com", 33,new BigDecimal(3000.00));

        studentRepository.save(student1);
        Student student2 = new Student("Tyson", "Fury",
                "The Gypsy King", "tf@gmail.com", 34,new BigDecimal(3800.00));
        studentRepository.save(student1);
        Student student3 = new Student("Lennox", "Lewis",
                "The Lion", "ll@gmail.com", 55,new BigDecimal(3900.00));
        Student student4 = new Student("Mike", "Tyson",
                "Iron Mike", "mt@gmail.com", 54,new BigDecimal(3900.00));

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);

        //create and save Course instances-----------------------------------------------------------------------------
        Course courseDataStructures = new Course("Data Structures","An overview of data structure concepts, arrays, stack, queues, trees",
                "Short Course","Software Development");
        Course courseAlgorithms = new Course("Algorithms","Fundamental Algorithms for solving a variety of problems",
                "Short Course","Software Development");
        Course courseSpring = new Course("Spring","Configure the Spring Framework for various Java-based enterprise applications",
                "Short Course","Software Development");
        Course courseReact = new Course("React","JSX overview,forms and UI, Component Lifecycle, Event Handling and Styles",
                "Short Course","Software Development");


        courseRepository.save(courseDataStructures);
        courseRepository.save(courseAlgorithms);
        courseRepository.save(courseSpring);
        courseRepository.save(courseReact);

        //create and save Lesson instances-----------------------------------------------------------------------------
        Lesson memory = new Lesson("Memory",
                "Learners will be able to describe memory",
                "Learners to understand memory","<h2>&nbsp;</h2><h2>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Memory</h2><p>&nbsp;</p><ul><li>computer memory is any phisical device capable to storing information temporarily like RAM or permanently like ROM</li><li>in computer science memory is:&nbsp;<ul><li>addressed sequence of bytes</li><li>storage for variable and functions in computer program</li><li>random-access - means fast accessing 1st or 5000 byte</li><li>addresses like hexadecimal</li></ul></li></ul><p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<strong> example</strong></p><p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;address &nbsp; &nbsp; 0x0 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 0x1 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;0x2 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;0x3 ………..0x1000……0x5000</p><p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;byte &nbsp; &nbsp; &nbsp;00000010 - we stored number 2 on 0 address</p><ul><li>memory usage by variables<ul><li>primitive data type takes up sequence of bytes - 1 byte(8 bits) is 1 address (one cell in memory)</li><li>other types use consecutive bytes - 1 integer is 4 bytes (32 bits)</li></ul></li></ul><p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; byte num = 42; (1 address)</p><p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; int numInt = 2020; (4 addresses)</p><ul><li>&nbsp;memory hierarchy</li></ul><p>&nbsp;</p><p>&nbsp; access time</p><p>&nbsp; &nbsp; &nbsp; ^</p><p>&nbsp; &nbsp; &nbsp; &nbsp;| &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; storage</p><p>&nbsp; &nbsp; &nbsp; &nbsp;| &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;memory(RAM)</p><p>&nbsp; &nbsp; &nbsp; &nbsp;| &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;cache</p><p>&nbsp; &nbsp; &nbsp; &nbsp;| &nbsp; cpu register</p><p>&nbsp; &nbsp; &nbsp; &nbsp;|-&nbsp;<strong> – – &nbsp;– – &nbsp;– – &nbsp;– – &nbsp;– – &nbsp;– – — – – – – – &nbsp;--</strong>&gt; &nbsp; storage size</p><p>&nbsp;</p><p>&nbsp;</p>",
                7,courseDataStructures);

        lessonRepository.save(memory);

        Lesson complexity = new Lesson("Algorithm Complexity",
                "Learners will be able to describe algorithm complexity","Learners to understand algorithm complexity",
                "<h2>&nbsp;</h2><h2>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Algorithm Complexity</h2><p>&nbsp;</p><ul><li>We analyse algorithms to predict resources the algorithm need<ul><li>CPU consumption</li><li>RAM consumption</li><li>communication bandwidth consumption</li><li>hard disc operation</li></ul></li><li>So expect running time of algo is&nbsp;<ul><li>total number of promitive operation executed - also known as <i>algorithm complexity</i></li></ul></li><li>Input<i> (<strong>n</strong>) </i>of the func is main source of step growing</li><li>Calculate max step to find result <i>T(n) = 3n*n + 3n + 3 (</i>higher therm dominate,const ommited<i>)</i></li></ul><p>&nbsp;</p><p><i><strong>&nbsp; &nbsp;</strong></i><strong> Asymptotic notation</strong><i> - </i>description allow us to examine algo (how algo &nbsp;perform based on the input increases)</p><p>&nbsp;</p><p><strong>&nbsp; &nbsp; Algorithm Complexity - </strong><i>estimation of num of steps performed by given computation</i></p><ul><li><i>&nbsp;depending on the size of input,</i></li><li><i>&nbsp;messured with asymptotic notation - BigO &nbsp; &nbsp; O(f(n)) - worst case&nbsp;</i> &nbsp; &nbsp; &nbsp;f(n) - func of size of input data</li></ul><p>&nbsp;</p><p><strong>&nbsp; &nbsp; Complexity</strong></p><ul><li>constant O(n) if n = 1000 we need 1-2 opeartion(example - look up in array)</li><li>logarithmic O(log(n)) if n = 1000 we need 10 opeartion&nbsp;</li><li>linear O(n) if n = 1000 we need 1000 opeartion</li><li>linearithmic O(n* log(n)) if n = 1000 we need 10 000 opeartion</li><li>quadratic O(n * n) if n = 1000 we need 100 000 operation&nbsp;</li></ul><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>",
                7,
                courseDataStructures);
        lessonRepository.save(complexity);



        //create and save Booking instances-----------------------------------------------------------------------------
        Booking booking1 = new Booking(  "22-12-18", courseDataStructures, student1);
        Booking booking2 = new Booking(  "22-12-28", courseDataStructures, student2);
        Booking booking3 = new Booking(  "22-12-29", courseAlgorithms, student3);
        Booking booking4 = new Booking(  "22-12-29", courseSpring, student4);
        Booking booking5 = new Booking(  "23-01-03", courseReact, student1);
        Booking booking6 = new Booking(  "23-01-04", courseDataStructures, student4);

        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);
        bookingRepository.save(booking4);
        bookingRepository.save(booking5);
        bookingRepository.save(booking6);

    }
}
