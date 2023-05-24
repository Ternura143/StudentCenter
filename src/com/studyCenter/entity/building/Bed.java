package com.studyCenter.entity.building;

import com.studyCenter.entity.Course;

import java.io.Serializable;
/*
 * @Author DengYimo
 * @Date  4:53
 * @Description This is description of class
 * @Since version-1.0
 */
public class Bed implements Serializable {
    private String name;
    private Course owner;
    private Room father;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getOwner() {
        return owner;
    }

    public void setOwner(Course owner) {
        this.owner = owner;
    }

    public Bed(Room father) {
        this.father = father;
    }

    public Bed(String name, Room father) {
        this.name = name;
        this.father = father;
    }

    public Bed(String name, Course owner, Room father) {
        this.name = name;
        this.owner = owner;
        this.father = father;
    }

    public Room getFather() {
        return father;
    }

    public void setFather(Room father) {
        this.father = father;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public Bed() {
    }
}
