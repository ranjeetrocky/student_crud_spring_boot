package com.codelamda.student_crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentConroller {

    @GetMapping("/Students")
    public String getStudents() {
        return "All students";
    }
}
