package com.studyCenter.dao;

import com.studyCenter.entity.CourseTester;

import java.util.List;
/*
 * @Author DengYimo
 * @Date  8:48
 * @Description 抽象测试者类
 * @Since version-1.0
 */
public interface AbstractCourseTester {
    boolean addCourseTester(CourseTester course);
    void removeCourseTester(CourseTester course);
    List<CourseTester> getCourseTesters();
}
