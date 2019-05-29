package com.bswen.sbmp.dao;

import com.bswen.sbmp.domain.Student;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * .
 * Created by  on 2018/4/17.
 */
@Mapper
public interface StudentMapper {

    Page<Student> findByPage();
}
