package com.bswen.sbjp.dao;

import com.bswen.sbjp.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created on 2018/6/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentPageTest {
    @Autowired
    private StudentPageRepository studentPageRepository;

    @Test
    public void testPage1() {
        int pageSize = 10;
        Pageable pageable = PageRequest.of(0,pageSize);
        Page<Student> students = studentPageRepository.findAll(pageable);
        assertEquals(students.getSize(),pageSize);
    }

    @Test
    public void testPageAndSort() {
        int pageSize = 10;
        Pageable pageable = PageRequest.of(0,pageSize,Sort.Direction.ASC,"id"); //order by id asc
        Page<Student> students = studentPageRepository.findAll(pageable);
        assertEquals(students.getSize(),pageSize);
        assertEquals(students.getContent().get(0).getId(),1);//the min id should be 1
    }
}
