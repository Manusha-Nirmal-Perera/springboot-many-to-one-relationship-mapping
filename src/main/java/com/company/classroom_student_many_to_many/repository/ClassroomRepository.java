package com.company.classroom_student_many_to_many.repository;

import com.company.classroom_student_many_to_many.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}
