package com.studentApp.StudentApp.Controller;

import com.studentApp.StudentApp.Entity.StudentCourse;
import com.studentApp.StudentApp.Services.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student-course")
public class StudentCourseController {

    private StudentCourseService studentCourseService;

    @Autowired
    public StudentCourseController(StudentCourseService studentCourseService) {
        this.studentCourseService = studentCourseService;
    }

    @GetMapping("student/{studentId}")
    public List<StudentCourse> getStudentCourse(@PathVariable Long studentId) {
        return StudentCourseService.getCoursesInfoByStudentId(studentId);
    }

    @GetMapping
    public List<StudentCourse> getStudentCourse() {
        return StudentCourseService.getAllStudentsCourseReview();
    }


}
