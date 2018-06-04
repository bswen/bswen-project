package com.bswen.sbmp.service;

import com.bswen.sbmp.domain.Student;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import lombok.extern.apachecommons.CommonsLog;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created on 2018/6/3.
 */
@RunWith(SpringRunner.class)
@CommonsLog
@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void testFindByPage() {
        Page<Student> students = studentService.findByPage(1, 2);//Query pageNo=1, pageSize=2
        assertEquals(students.getTotal(),5);
        assertEquals(students.getPages(),3);
        log.debug(students.toString());
    }
}
