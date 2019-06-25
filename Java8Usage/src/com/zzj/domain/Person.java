package com.zzj.domain;

import java.sql.Timestamp;

public class Person
{
    private Integer age;
    private Timestamp time;
    private String name;
    public Person(String name,Integer age) {
        this.name = name;
        this.age = age;
    }
    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public Timestamp getTime()
    {
        return time;
    }
    public void setTime(Timestamp time)
    {
        this.time = time;
    }

}
