package com.codelamda.student_crud.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codelamda.student_crud.entities.Student;

public interface StudentDao extends JpaRepository<Student, Long> {

}
