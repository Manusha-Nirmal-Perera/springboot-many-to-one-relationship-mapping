package com.company.classroom_student_many_to_many.repository;

import com.company.classroom_student_many_to_many.model.Student;
import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
