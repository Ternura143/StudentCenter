package com.studyCenter.entity.building;

import com.studyCenter.entity.Course;

import java.io.Serializable;

/**
 * seat entity
 */
public class Seat implements Serializable {
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

    public Seat(Room father) {
        this.father = father;
    }

    public Seat(String name, Room father) {
        this.name = name;
        this.father = father;
    }

    public Seat(String name, Course owner, Room father) {
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

    public Seat() {
    }
}
