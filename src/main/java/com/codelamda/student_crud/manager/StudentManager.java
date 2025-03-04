package com.codelamda.student_crud.manager;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codelamda.student_crud.entities.Student;
import com.codelamda.student_crud.services.StudentService;

@Service
public class StudentManager {
    private StudentService studentService;

    public StudentManager(StudentService studentService) {
        this.studentService = studentService;
    }

    public Student createStudent(String name, String surname, String email) {

        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setEmail(email);
        return studentService.saveStudent(student);
    }

    public List<Student> getStudents() {
        return studentService.findAllStudents();
    }

    // public void deleteStudent(Long id) {
    // studentService.deleteStudent(id);
    // }
}
