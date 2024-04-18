package com.studentApp.StudentApp.DTOs;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentCourseDTO {
    private Long id;
    private Long studentId;
    private Long courseId;
    private String remarks;
    private double courseGPA;
    private LocalDate dateOfJoining;
}
