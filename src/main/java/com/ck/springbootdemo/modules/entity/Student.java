package com.ck.springbootdemo.modules.entity;

import java.io.Serializable;

import javax.persistence.Id;

public class Student implements Serializable{
	
	@Id
    private Long id;

    private String name;

    private Integer age;

    private Integer socre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSocre() {
        return socre;
    }

    public void setSocre(Integer socre) {
        this.socre = socre;
    }
}