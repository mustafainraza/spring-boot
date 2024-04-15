package com.studentApp.StudentApp.Services;

import com.studentApp.StudentApp.Entity.Course;
import com.studentApp.StudentApp.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {


    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
       return courseRepository.findAll();
    }

    public Course findCourseById(Long id) {
      return courseRepository.findById(id).orElseThrow();
    }

    public Course registerCourse(Course course) {
        return courseRepository.save(course);
    }

}
