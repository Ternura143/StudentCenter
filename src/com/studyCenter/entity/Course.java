package com.studyCenter.entity;

/**
 * course entity
 */
public class Course {
    private String courseName;
    private String courseID;
    private String category;
    private String id;
    private String score;

    public Course(String courseName, String courseID, String category, String id, String score) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.category = category;
        this.score = score;
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCategory() {
        return category;
    }

    public String getId() {
        return id;
    }

    public String getScore() {
        return score;
    }



    public void setCourseName(String name) {
        this.courseName = name;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setScore(String score) {
        this.score = score;
    }

}
