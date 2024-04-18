package com.studentApp.StudentApp.Controller;

import com.studentApp.StudentApp.DTOs.StudentCourseDTO;
import com.studentApp.StudentApp.Entity.StudentCourse;
import com.studentApp.StudentApp.Services.StudentCourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-course")
public class StudentCourseController {

    private StudentCourseService studentCourseService;

    private final ModelMapper modelMapper;


    @Autowired
    public StudentCourseController(StudentCourseService studentCourseService, ModelMapper modelMapper) {
        this.studentCourseService = studentCourseService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("student/{studentId}")
    public List<StudentCourse> getStudentCourse(@PathVariable Long studentId) {
        return StudentCourseService.getCoursesInfoByStudentId(studentId);
    }

    @GetMapping
    public List<StudentCourse> getStudentCourse() {
        return StudentCourseService.getAllStudentsCourseReview();
    }

    @PostMapping
    public ResponseEntity<String> createStudentCourse(@RequestBody StudentCourseDTO studentCourseDTO){
        return StudentCourseService.createStudentCourse(studentCourseDTO);
    }
}
