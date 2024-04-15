package com.studentApp.StudentApp.Controller;

import com.studentApp.StudentApp.Entity.Course;
import com.studentApp.StudentApp.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {


    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> findAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/CourseId")
    public Course findCourseById(@PathVariable("CourseId") Long CourseId){
        return courseService.findCourseById(CourseId);
    }

    @PostMapping
    public Course registerCourse(@RequestBody Course course){
        return courseService.registerCourse(course);
    }
}
