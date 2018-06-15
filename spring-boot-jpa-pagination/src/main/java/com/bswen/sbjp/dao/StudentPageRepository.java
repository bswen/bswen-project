package com.bswen.sbjp.dao;


import com.bswen.sbjp.domain.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created on 2018/6/15.
 */
public interface StudentPageRepository extends PagingAndSortingRepository<Student,Long> {
}
