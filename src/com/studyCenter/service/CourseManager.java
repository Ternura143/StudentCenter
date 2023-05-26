package com.studyCenter.service;

import com.studyCenter.dao.AbstractCourse;
import com.studyCenter.entity.Course;
import com.studyCenter.util.FileOperator;
import java.util.List;

/**
 * CourseManager is a singleton class that manages the Course objects.
 * It implements the AbstractCourse interface.
 * It has a list of Course objects.
 * It has a private constructor and a public static method getInstance() to get the singleton instance.
 * It has a method addCourse() to add an Course object to the list.
 * It has a method removeCourse() to remove an Course object from the list.
 * It has a method getCourses() to get the list of Course objects.
 */
public class CourseManager implements AbstractCourse {
    private final List<Course> courses;
    private static CourseManager singletonInstance;

    private CourseManager() {
        courses = FileOperator.loadData("Courses.json", Course.class);
    }

    //Singleton Pattern
    public static CourseManager getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new CourseManager();
        }
        return singletonInstance;
    }
    //Add
    public boolean addCourse(Course course) {
        courses.add(course);
        FileOperator.writeData(course, "Courses.json");
        return true;
    }
    //Delete
    public void removeCourse(Course course) {
        courses.remove(course);
        FileOperator.writeData(courses, "Courses.json");
    }

    public List<Course> getCourses() {
        return courses;
    }
}
