package com.company.classroom_student_many_to_many.controller;


import com.company.classroom_student_many_to_many.dto.StudentDto;
import com.company.classroom_student_many_to_many.exceptions.StudentNotFoundException;
import com.company.classroom_student_many_to_many.model.Student;
import com.company.classroom_student_many_to_many.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/add")
    public Student addClassroom(@RequestBody StudentDto studentDto){
        return studentService.addStudent(studentDto);
    }

    @GetMapping(value = "/get")
    public List<Student> getAllClassrooms(){
        return studentService.getAllStudents();
    }
    @GetMapping(value = "/get/{id}")
    public Student getAllClassroom(@PathVariable Long id) throws StudentNotFoundException {
        return  studentService.getStudent(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String removeClassroom(@PathVariable Long id) throws StudentNotFoundException {
        studentService.removeStudent(id);
        return "Student deleted";
    }

    @PutMapping(value = "/edit/{id}")
    public Student editClassroom(@PathVariable Long id, @RequestBody StudentDto studentDto) throws StudentNotFoundException {
        return studentService.editStudent(id, studentDto);
    }

}
