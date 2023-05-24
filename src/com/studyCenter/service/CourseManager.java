package com.studyCenter.service;

import com.studyCenter.dao.AbstractCourse;
import com.studyCenter.entity.Course;
import com.studyCenter.util.FileOperator;
import java.util.List;

public class CourseManager implements AbstractCourse {
    private final List<Course> courses;
    private static CourseManager singletonInstance;

    private CourseManager() {
        courses = FileOperator.loadData("Courses.json", Course.class);
    }

    //单例模式
    public static CourseManager getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new CourseManager();
        }
        return singletonInstance;
    }
    //增
    public boolean addCourse(Course course) {
        courses.add(course);
        FileOperator.writeData(course, "Courses.json");
        return true;
    }
    //删
    public void removeCourse(Course course) {
        courses.remove(course);
        FileOperator.writeData(courses, "Courses.json");
    }

    public List<Course> getCourses() {
        return courses;
    }
}
