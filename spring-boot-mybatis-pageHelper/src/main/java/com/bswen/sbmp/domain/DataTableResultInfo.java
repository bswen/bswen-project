package com.bswen.sbmp.domain;

import com.github.pagehelper.Page;
import lombok.Data;

/**
 * for datatable.
 * Created on 2018/6/7.
 */
@Data
public class DataTableResultInfo {
    private Page<Student> data;
    private int draw;//the NO.of requests
    private int length;
    private long recordsTotal;
    private long recordsFiltered;
}
