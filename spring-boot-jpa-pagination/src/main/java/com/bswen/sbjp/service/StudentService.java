package com.bswen.sbjp.service;


import com.bswen.sbjp.dao.StudentPageRepository;
import com.bswen.sbjp.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created on 2018/6/15.
 */
@Service
public class StudentService {
    @Autowired
    private StudentPageRepository studentPageRepository;

    public Page<Student> listByPage(Pageable pageable) {
        return studentPageRepository.findAll(pageable);
    }
}
