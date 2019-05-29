package com.bswen.sbjp.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * .
 * Created by  on 2018/4/17.
 */
@Data
@Entity
@Table(name="tbl_student")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //auto increment
    private long id;
    private String name;
    private String branch;
    private int percentage;
    private int phone;
    private String email;

}
