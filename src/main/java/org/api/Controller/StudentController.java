package org.api.Controller;

import org.api.Entity.Student;
import org.api.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    public StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudent(){
        return this.studentService.getAllStudent();
    }
    @RequestMapping(value = ("/{id}"),method = RequestMethod.DELETE)
    public Student deleteStudentById(@PathVariable("id") int id){
        return this.studentService.deleteStudentById(id);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") int id){
        return this.studentService.getStudentById(id);
    }
}
