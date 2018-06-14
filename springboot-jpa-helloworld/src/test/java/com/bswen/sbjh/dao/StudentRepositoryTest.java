package com.bswen.sbjh.dao;

import com.bswen.sbjh.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

/**
 * Created on 2018/6/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testFindAll() {
        Iterable<Student> studentList = studentRepository.findAll();
        for(Iterator<Student> iter = studentList.iterator(); iter.hasNext();) {
            Student student = iter.next();
            if(student!=null) {
                System.out.println(student);
            }
        }
        assertTrue(studentList!=null);
    }

    @Test
    public void testFindByProperty() {
        Optional<Student> student = studentRepository.findById(2l);
        assertTrue(student.get()!=null);
    }

    @Test
    public void testCount() {
        long count  = studentRepository.count();
        assertTrue(count>0);
    }

    @Test
    public void testCRUD() {
        Student s = new Student();
        s.setBranch("branchnew");
        s.setEmail("jerry@test.com");
        s.setName("Jerry");
        s.setPercentage(21);
        s.setPhone(982393);

        //insert the record
        Student ss = studentRepository.save(s);
        assertTrue(ss.getId()>0);

        //update the record
        ss.setBranch("branch_new2");
        studentRepository.save(ss);

        //query the updated record
        Optional<Student> ss2 = studentRepository.findById(ss.getId());
        assertTrue(ss2.get()!=null&&ss2.get().getBranch().equals("branch_new2"));

        //delete the record
        studentRepository.delete(ss2.get());
        Optional<Student> ss3 = studentRepository.findById(ss.getId());
        assertTrue(!ss3.isPresent());
    }
}
