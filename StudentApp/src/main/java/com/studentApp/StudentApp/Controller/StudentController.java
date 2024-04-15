package com.studentApp.StudentApp.Controller;

import com.studentApp.StudentApp.Entity.Student;
import com.studentApp.StudentApp.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public Student registerNewStudent(@RequestBody  Student student){
       return studentService.addNewStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @GetMapping("/{studentId}")
    public Student findById(@PathVariable("studentId") Long studentId){
        return studentService.findById(studentId).orElseThrow();
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable("studentId") Long studentId, @RequestBody Student updatedStudent) {
        Optional<Student> existingStudentOptional = Optional.of(studentService.findById(studentId).orElseThrow());

        if (existingStudentOptional.isPresent()) {
            Student existingStudent = existingStudentOptional.get();
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setDob(updatedStudent.getDob());

            studentService.editStudent(existingStudent);

            return ResponseEntity.ok(existingStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
