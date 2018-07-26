package org.api.Dao;

import org.api.Entity.Employee;
import org.api.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDao {
    private static Map<Integer, Student> students;
    static {
        students = new HashMap<Integer, Student>(){
            {
                put(1, new Student(1, "Sahil","Computer Science"));
                put(2, new Student(2, "Rishi","Commerce"));
                put(3, new Student(3, "Nitin","Arts"));
            }
        };
    }
    public Collection<Student> getallStudent() {
        return this.students.values();
    }
    public Student deleteStudentById(int id){
        return this.students.remove(id);
    }

    public Student getStudentById(int id) {
        return this.students.get(id);
    }
}
