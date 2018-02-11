package com.lx.soil.demos.spring_boot_test.dto;

import lombok.Data;
import lombok.Value;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-01-29 21:27
 * @desc : 输入描述
 */
@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String pwd;
    private Integer age;

    public User(){}

}
