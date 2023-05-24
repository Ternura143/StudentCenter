package com.studyCenter.dao;

import com.studyCenter.entity.Course;

import java.util.List;
/*
 * @Author DengYimo
 * @Date  8:48
 * @Description 抽象病人接口
 * @Since version-1.0
 */
public interface AbstractCourse {
    boolean addCourse(Course course);
    void removeCourse(Course course);
    List<Course> getCourses();
}
