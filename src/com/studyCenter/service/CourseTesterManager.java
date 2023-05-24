package com.studyCenter.service;

import com.studyCenter.dao.AbstractCourseTester;
import com.studyCenter.entity.CourseTester;
import com.studyCenter.util.FileOperator;

import java.util.List;

public class CourseTesterManager implements AbstractCourseTester {
    private final List<CourseTester> courses;
    private static CourseTesterManager singletonInstance;

    private CourseTesterManager() {
        courses = FileOperator.loadData("CourseTester.json", CourseTester.class);
    }

    //单例模式
    public static CourseTesterManager getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new CourseTesterManager();
        }
        return singletonInstance;
    }
    //增
    public boolean addCourseTester(CourseTester course) {
        courses.add(course);
        FileOperator.writeData(course, "CourseTester.json");
        return true;
    }
    //删
    public void removeCourseTester(CourseTester course) {
        courses.remove(course);
        FileOperator.writeData(courses, "CourseTester.json");
    }

    public List<CourseTester> getCourseTesters() {
        return courses;
    }
}
