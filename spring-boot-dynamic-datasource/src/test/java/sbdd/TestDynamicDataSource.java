package sbdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sbdd.dao.StudentDao;
import sbdd.domain.Student;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by xxx on 2018/4/25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDynamicDataSource {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void testSimpleSelect() {
        Student student = studentDao.getStudent(1);
        assertNotNull(student);
        assertEquals(student.getName(),"jack");
    }

}
