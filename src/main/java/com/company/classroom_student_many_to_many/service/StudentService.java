package com.company.classroom_student_many_to_many.service;

import com.company.classroom_student_many_to_many.dto.StudentDto;
import com.company.classroom_student_many_to_many.exceptions.StudentNotFoundException;
import com.company.classroom_student_many_to_many.model.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(StudentDto studentDto);

    List<Student> getAllStudents();

    Student getStudent(Long id) throws StudentNotFoundException;

    void removeStudent(Long id) throws StudentNotFoundException;

    Student editStudent(Long id, StudentDto studentDto) throws StudentNotFoundException;

}
