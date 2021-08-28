package sba;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sba.dao.StudentDao;
import sba.domain.Student;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApp1 {
    @Autowired
    private StudentDao studentDao;

    @Test
    public void testSimpleSelect() {
        Student student = studentDao.getStudent(2);
        assertNotNull(student);
        assertEquals(student.getName(),"Jack");
    }
}
