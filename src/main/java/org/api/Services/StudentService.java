package org.api.Services;

import org.api.Dao.StudentDao;
import org.api.Entity.Employee;
import org.api.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public Collection<Student> getAllStudent(){
        return this.studentDao.getallStudent();
    }
    public Student deleteStudentById(int id){
        return this.studentDao.deleteStudentById(id);
    }

    public Student getStudentById(int id) {
        return this.studentDao.getStudentById(id);
    }
}
