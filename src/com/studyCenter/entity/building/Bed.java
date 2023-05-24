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
/*
 * @Author DengYimo
 * @Date  4:53
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getName() {
        return name;
    }
/*
 * @Author DengYimo
 * @Date  4:53
 * @Description This is description of method
 * @Param [name]
 * @Return void
 * @Since version-1.0
 */
    public void setName(String name) {
        this.name = name;
    }
/*
 * @Author DengYimo
 * @Date  4:53
 * @Description This is description of method
 * @Param []
 * @Return com.neusoft.entity.Course
 * @Since version-1.0
 */
    public Course getOwner() {
        return owner;
    }
/*
 * @Author DengYimo
 * @Date  4:53
 * @Description This is description of method
 * @Param [owner]
 * @Return void
 * @Since version-1.0
 */
    public void setOwner(Course owner) {
        this.owner = owner;
    }
/*
 * @Author DengYimo
 * @Date  4:53
 * @Description This is description of method
 * @Param [father]
 * @Return
 * @Since version-1.0
 */
    public Bed(Room father) {
        this.father = father;
    }
/*
 * @Author DengYimo
 * @Date  4:53
 * @Description This is description of method
 * @Param [name, father]
 * @Return
 * @Since version-1.0
 */
    public Bed(String name, Room father) {
        this.name = name;
        this.father = father;
    }
/*
 * @Author DengYimo
 * @Date  4:53
 * @Description This is description of method
 * @Param [name, owner, father]
 * @Return
 * @Since version-1.0
 */
    public Bed(String name, Course owner, Room father) {
        this.name = name;
        this.owner = owner;
        this.father = father;
    }
/*
 * @Author DengYimo
 * @Date  4:53
 * @Description This is description of method
 * @Param []
 * @Return com.neusoft.entity.building.Room
 * @Since version-1.0
 */
    public Room getFather() {
        return father;
    }
/*
 * @Author DengYimo
 * @Date  4:53
 * @Description This is description of method
 * @Param [father]
 * @Return void
 * @Since version-1.0
 */
    public void setFather(Room father) {
        this.father = father;
    }
/*
 * @Author DengYimo
 * @Date  4:53
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    @Override
    public String toString() {
        return this.name;
    }
/*
 * @Author DengYimo
 * @Date  4:53
 * @Description This is description of method
 * @Param []
 * @Return
 * @Since version-1.0
 */
    public Bed() {
    }
}
