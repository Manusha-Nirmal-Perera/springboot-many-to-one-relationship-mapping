package com.company.classroom_student_many_to_many.dto;

import lombok.Data;

@Data
public class StudentDto {
    private String name;
    private Long classroomId;
}
