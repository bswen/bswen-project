package com.bswen.sbmp.service;

import com.bswen.sbmp.dao.StudentMapper;
import com.bswen.sbmp.domain.Student;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 2018/6/3.
 */
@Service
@Transactional(readOnly = true)
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;


    public Page<Student> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return studentMapper.findByPage();
    }

}
