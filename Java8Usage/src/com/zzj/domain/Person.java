package com.zzj.domain;

import java.sql.Timestamp;
import java.util.List;

public class Person
{
    private Integer age;
    private Timestamp time;
    private String name;
    private Boolean show;

    private List<Son> sons;
    
    private List<Integer> list;

    public Person(String name, Integer age)
    {
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

    public Boolean getShow()
    {
        return show;
    }

    public void setShow(Boolean show)
    {
        this.show = show;
    }

    public List<Son> getSons()
    {
        return sons;
    }

    public void setSons(List<Son> sons)
    {
        this.sons = sons;
    }

    public List<Integer> getList()
    {
        return list;
    }

    public void setList(List<Integer> list)
    {
        this.list = list;
    }
}
