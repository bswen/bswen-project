package com.bswen.sbmp.controller;

import com.bswen.sbmp.domain.DataTableResultInfo;
import com.bswen.sbmp.domain.Student;
import com.bswen.sbmp.service.StudentService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2018/6/5.
 */
@RestController
@RequestMapping("/studentsApi")
public class StudentRestController {
    @Autowired
    private StudentService studentService;


    @RequestMapping(value = "/queryByPage", method = RequestMethod.GET)
    public DataTableResultInfo queryByPage(
            @RequestParam(value = "start", required = false, defaultValue="0") Integer start,
            @RequestParam(value = "length", required = false, defaultValue="10") Integer length,
            @RequestParam(value = "draw",required = false,defaultValue = "0") Integer draw) {
        int pageNo = (start)/length+1;
        Page<Student> pageInfo = studentService.findByPage(pageNo,length);
        DataTableResultInfo dataTableResultInfo = new DataTableResultInfo();
        dataTableResultInfo.setData(pageInfo);
        dataTableResultInfo.setDraw(draw);
        dataTableResultInfo.setLength(length);
        dataTableResultInfo.setRecordsTotal(pageInfo.getTotal());
        dataTableResultInfo.setRecordsFiltered(pageInfo.getTotal());
        return dataTableResultInfo;
    }
}
