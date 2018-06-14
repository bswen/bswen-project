package com.bswen.sbjh.dao;

import com.bswen.sbjh.domain.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created on 2018/6/14.
 */
public interface StudentRepository extends CrudRepository<Student,Long> {
}
