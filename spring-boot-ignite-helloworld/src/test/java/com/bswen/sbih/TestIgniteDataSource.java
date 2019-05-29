package com.bswen.sbih;

import com.bswen.sbih.dao.CityDao;
import com.bswen.sbih.domain.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by xxx on 2018/4/25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestIgniteDataSource {

    @Autowired
    private CityDao cityDao;

    @Test
    public void testSimpleSelect() {
        City city = cityDao.getCity(1);
        assertNotNull(city);
        assertEquals(city.getName(),"Paris");
    }

    @Test
    public void testSimpleListSelect() {
        List<City> cities = cityDao.getCities();
        assertNotNull(cities);
        assertEquals(cities.size(),1);
    }


}
