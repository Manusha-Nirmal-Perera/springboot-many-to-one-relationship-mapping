package com.company.classroom_student_many_to_many.service.impl;

import com.company.classroom_student_many_to_many.dto.ClassroomDto;
import com.company.classroom_student_many_to_many.exceptions.ClassroomNotFoundException;
import com.company.classroom_student_many_to_many.model.Classroom;
import com.company.classroom_student_many_to_many.repository.ClassroomRepository;
import com.company.classroom_student_many_to_many.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public Classroom addClassroom(ClassroomDto classroomDto) {
        Classroom classroom = new Classroom();
        classroom.setName(classroomDto.getName());
        return classroomRepository.save(classroom);
    }

    @Override
    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

    @Override
    public Classroom getClassroom(Long id) {
        return classroomRepository.findById(id)
                .orElseThrow(() -> new ClassroomNotFoundException("Classroom not found for the id: " + id));
    }

    @Override
    public boolean removeClassroom(Long id) {
        boolean isDeleted = false;
        if(classroomRepository.existsById(id)){
            classroomRepository.deleteById(id);
            isDeleted = true;
        }else {
            throw new ClassroomNotFoundException("Classroom not found for the id: " + id);
        }
        return isDeleted;
    }

    @Override
    public Classroom editClassroom(Long id, ClassroomDto classroomDto) {
        Classroom classroom = getClassroom(id);
        classroom.setName(classroomDto.getName());

        return classroomRepository.save(classroom);
    }
}
