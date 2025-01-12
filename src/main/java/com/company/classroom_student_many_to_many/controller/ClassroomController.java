package com.company.classroom_student_many_to_many.controller;

import com.company.classroom_student_many_to_many.dto.ClassroomDto;
import com.company.classroom_student_many_to_many.model.Classroom;
import com.company.classroom_student_many_to_many.service.ClassRoomService;
import org.hibernate.annotations.WhereJoinTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/classroom")
public class ClassroomController {

    @Autowired
    private ClassRoomService classRoomService;

    @PostMapping(value = "/add")
    public Classroom addClassroom(@RequestBody ClassroomDto classroomDto){
        return classRoomService.addClassroom(classroomDto);
    }

    @GetMapping(value = "/get")
    public List<Classroom> getAllClassrooms(){
        return classRoomService.getAllClassrooms();
    }
    @GetMapping(value = "/get/{id}")
    public Classroom getAllClassroom(@PathVariable Long id){
        return  classRoomService.getClassroom(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public boolean removeClassroom(@PathVariable Long id){
        return classRoomService.removeClassroom(id);
    }

    @PutMapping(value = "/edit/{id}")
    public Classroom editClassroom(@PathVariable Long id, @RequestBody ClassroomDto classroomDto){
        return classRoomService.editClassroom(id, classroomDto);
    }
}
