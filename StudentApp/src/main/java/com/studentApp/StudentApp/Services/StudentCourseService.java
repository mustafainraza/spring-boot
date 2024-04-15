package com.studentApp.StudentApp.Services;

import com.studentApp.StudentApp.Entity.StudentCourse;
import com.studentApp.StudentApp.Repository.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseService {
    private static StudentCourseRepository studentCourseRepository;

    @Autowired
    public StudentCourseService(StudentCourseRepository studentCourseRepository) {
        this.studentCourseRepository = studentCourseRepository;
    }

    public static List<StudentCourse> getAllStudentsCourseReview(){
        return studentCourseRepository.findAll();
    }

    public static List<StudentCourse> getCoursesInfoByStudentId(Long studentId) {
        return studentCourseRepository.findByStudentId(studentId);
    }
}
