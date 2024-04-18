package com.studentApp.StudentApp.Services;

import com.studentApp.StudentApp.DTOs.StudentCourseDTO;
import com.studentApp.StudentApp.Entity.StudentCourse;
import com.studentApp.StudentApp.Repository.StudentCourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseService {
    private static StudentCourseRepository studentCourseRepository;
    private static ModelMapper modelMapper;

    @Autowired
    public StudentCourseService(StudentCourseRepository studentCourseRepository,ModelMapper modelMapper) {
        this.studentCourseRepository = studentCourseRepository;
        this.modelMapper = modelMapper;
    }

    public static List<StudentCourse> getAllStudentsCourseReview(){
        return studentCourseRepository.findAll();
    }

    public static List<StudentCourse> getCoursesInfoByStudentId(Long studentId) {
        return studentCourseRepository.findByStudentId(studentId);
    }

    public static ResponseEntity<String> createStudentCourse(StudentCourseDTO studentCourseDTO) {

        StudentCourse existingRecord = studentCourseRepository.findByStudentIdAndCourseId(studentCourseDTO.getStudentId(), studentCourseDTO.getCourseId());
        if (existingRecord != null && existingRecord.getCourseGPA() >= 2) {
            return new ResponseEntity<>("Record already exists and GPA is not lower than 2", HttpStatus.BAD_REQUEST);
        } else if (existingRecord != null && existingRecord.getCourseGPA() < 2) {
            existingRecord.setCourseGPA(studentCourseDTO.getCourseGPA());
            studentCourseRepository.save(existingRecord);
            return new ResponseEntity<>("Existing record updated", HttpStatus.OK);
        } else {
            StudentCourse studentCourse = modelMapper.map(studentCourseDTO,StudentCourse.class);
            studentCourseRepository.save(studentCourse);
            return new ResponseEntity<>("New record created", HttpStatus.CREATED);
        }
    }
}
