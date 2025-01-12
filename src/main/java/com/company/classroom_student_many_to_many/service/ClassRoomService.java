package com.company.classroom_student_many_to_many.service;

import com.company.classroom_student_many_to_many.dto.ClassroomDto;
import com.company.classroom_student_many_to_many.model.Classroom;

import java.util.List;

public interface ClassRoomService {
    Classroom addClassroom(ClassroomDto classroomDto);

    List<Classroom> getAllClassrooms();

    Classroom getClassroom(Long id);

    boolean removeClassroom(Long id);

    Classroom editClassroom(Long id, ClassroomDto classroomDto);

}
