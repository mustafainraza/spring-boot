package com.studentApp.StudentApp.Services;

import com.studentApp.StudentApp.Entity.Student;
import com.studentApp.StudentApp.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student addNewStudent(Student student) {
       Optional<Student> studentByEmail =  studentRepository.findStudentByEmail(student.getEmail());
       if(studentByEmail.isPresent())
       {
           throw new IllegalStateException("Email is exist already");
       }
        return studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with Id : "+studentId+ " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    public Optional<Student> findById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public Student editStudent(Student student){
        return studentRepository.save(student);
    }
}
