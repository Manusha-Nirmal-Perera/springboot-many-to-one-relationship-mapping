package com.company.classroom_student_many_to_many.service.impl;

import com.company.classroom_student_many_to_many.dto.StudentDto;
import com.company.classroom_student_many_to_many.exceptions.ClassroomNotFoundException;
import com.company.classroom_student_many_to_many.exceptions.StudentNotFoundException;
import com.company.classroom_student_many_to_many.model.Classroom;
import com.company.classroom_student_many_to_many.model.Student;
import com.company.classroom_student_many_to_many.repository.ClassroomRepository;
import com.company.classroom_student_many_to_many.repository.StudentRepository;
import com.company.classroom_student_many_to_many.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public Student addStudent(StudentDto studentDto) {
        Long id = studentDto.getClassroomId();
        Classroom classroom = classroomRepository.findById(id).orElseThrow(() -> new ClassroomNotFoundException("Classroom not found for the id: " + id));

        Student student = new Student();
        student.setName(studentDto.getName());
        student.setClassroom(classroom);
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id) throws StudentNotFoundException {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found for the id: " + id));
    }


    @Override
    public void removeStudent(Long id) throws StudentNotFoundException {
        if (studentRepository.existsById(id)){
            studentRepository.deleteById(id);
        }else{
            throw new StudentNotFoundException("Student mot found for id: " + id);
        }
    }

    @Override
    public Student editStudent(Long id, StudentDto studentDto) throws StudentNotFoundException {
        if(studentRepository.existsById(id)){
            Classroom classroom = classroomRepository.findById(studentDto.getClassroomId())
                    .orElseThrow(() -> new ClassroomNotFoundException("Classroom not found for id: " + id));

            Student student = getStudent(id);
            student.setName(studentDto.getName());
            student.setClassroom(classroom);

            return studentRepository.save(student);
        }else {
            throw new StudentNotFoundException("Student not found for id : " + id);
        }
    }
}
