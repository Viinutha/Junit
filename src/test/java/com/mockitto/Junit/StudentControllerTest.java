package com.mockitto.Junit;

import com.mockitto.Junit.Controller.StudentController;
import com.mockitto.Junit.Pojos.Student;
import com.mockitto.Junit.Repos.StudentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@SpringBootTest
public class StudentControllerTest {
    @Autowired
    private StudentController studentController;
    @MockBean
    private StudentRepo studentRepo;


//    @BeforeEach
//    public void setup(){
//        studentController = new StudentController();
//    }
    @Test
    public void listAllTest(){
        when(studentRepo.findAll()).thenReturn(Stream.of(new Student(1,"vinutha","vinutha418@gmail.com"),new Student(2,"Vasavi","vasavi@gmail.com")).collect(Collectors.toList()));
        assertEquals(3,studentController.listAll().size());
    }
    @Test
    public void getStudentByIdTest(){
        Student student = new Student(1,"vinutha","vinutha418@gmail.com");
        when(studentRepo.findById(1)).thenReturn(Optional.of(student));
        assertEquals("vinutha",studentController.getStudent(1).getName());
    }

}
