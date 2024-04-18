package com.studentApp.StudentApp.Repository;

import com.studentApp.StudentApp.Entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse,Long> {

    List<StudentCourse> findByStudentId(Long studentId);

    StudentCourse findByStudentIdAndCourseId(Long studentId, Long courseId);
}
