package com.studyCenter.dao;

import com.studyCenter.entity.Course;

import java.util.List;

public interface AbstractCourse {
    boolean addCourse(Course course);
    void removeCourse(Course course);
    List<Course> getCourses();
}
