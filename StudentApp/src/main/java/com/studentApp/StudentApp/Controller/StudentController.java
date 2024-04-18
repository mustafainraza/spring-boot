package com.studentApp.StudentApp.Controller;

import com.studentApp.StudentApp.Entity.Student;
import com.studentApp.StudentApp.Services.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    private final ModelMapper modelMapper;

    @Autowired
    public StudentController(StudentService studentService,ModelMapper modelMapper) {
        this.studentService = studentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public ResponseEntity<Student> registerNewStudent(@RequestBody  Student student){

         studentService.addNewStudent(student);
         return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Optional<Student>> findById(@PathVariable("studentId") Long studentId){
        Optional<Student> s= studentService.findById(studentId);
        if(s!=null && !s.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(s);
        }
        else{
            return ResponseEntity.notFound().build();
        }
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
