package com.bswen.sbut.mockdao.service;

import com.bswen.sbut.mockdao.dao.MyDao;
import com.bswen.sbut.mockdao.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xxx on 2017-1-18.
 *
 * @author xxx
 */
@Service("demo")
public class MyService {
    @Autowired
    private MyDao myDao;

    public List<User> listUsers() {
        return myDao.queryUsers();
    }
}
