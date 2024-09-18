package com.sanjeev.StudentController;

import com.sanjeev.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<Student>(List.of(
           new Student (1,"Sanjeev","Java") ));

    @GetMapping("students")
    public List<Student> getStudents() {
        return students;
    }



    @PostMapping("add")
    public void addStudents(@RequestBody Student student) {
        students.add(student);


    }


    @RestController
    public static class HelloController {

        @GetMapping("hello")
        public  String greet(HttpServletRequest request) {
           return "Hello world " + request.getSession().getId();
        }

        @GetMapping("about")
        public  String about(HttpServletRequest request) {
            return "Sanjeev " + request.getSession().getId();
        }





    }
}
