package com.codelamda.student_crud.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codelamda.student_crud.daos.StudentDao;
import com.codelamda.student_crud.entities.Student;

@Service
public class StudentService {
    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    // save or create a student
    public Student saveStudent(Student student) {
        return studentDao.save(student);
    }

    public List<Student> findAllStudents() {
        return studentDao.findAll();
    }

    public void deleteStudent(Long id) {
        studentDao.deleteById(id);
    }
}
