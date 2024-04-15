package com.studentApp.StudentApp.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

//    @ManyToMany(mappedBy = "courses")
//    private List<Student> students;

    @OneToMany(mappedBy = "course")
    private List<StudentCourse> students;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

//    public List<StudentCourse> getStudentCourse() {
//        return students;
//    }
//
//    public void setStudentCourse(List<StudentCourse> studentCourses) {
//        this.students = studentCourses;
//    }
}
