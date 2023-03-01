package com.mockitto.Junit.Controller;

import com.mockitto.Junit.Pojos.Student;
import com.mockitto.Junit.Repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class StudentController {
    @Autowired
    private StudentRepo studentRepo;

    @PostMapping("/student")
    private Student saveStudent(@RequestBody Student student){
        return studentRepo.save(student);
    }
    @GetMapping("/students")
    public List<Student> listAll() {
        return studentRepo.findAll();

    }
    @GetMapping("/student/{id}")
    
    public  Student getStudent(@PathVariable Integer id){
        return studentRepo.findById(id).get();
    }

    @DeleteMapping("/students/{id}")
    public void deleateStudent(@PathVariable Integer id){
        studentRepo.deleteById(id);
    }
}
