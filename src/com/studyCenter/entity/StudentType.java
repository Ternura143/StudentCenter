package com.studyCenter.entity;

import com.studyCenter.util.FileOperator;

import java.util.List;
/*
 * @Author DengYimo
 * @Date  4:35
 * @Description This is description of class
 * @Since version-1.0
 */
public class StudentType {
    private final List<Type> types;
    private static StudentType singletonInstance;

    // 实现单例模式：只有一个DeviceType被创建
    /*
     * @Author DengYimo
     * @Date  4:35
     * @Description This is description of method
     * @Param []
     * @Return com.neusoft.entity.StudentType
     * @Since version-1.0
     */
    public static StudentType getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new StudentType();
        }
        return singletonInstance;
    }
/*
 * @Author DengYimo
 * @Date  4:35
 * @Description This is description of method
 * @Param []
 * @Return
 * @Since version-1.0
 */
    private StudentType() {
        types = FileOperator.loadData("Types.json", Type.class);
    }
/*
 * @Author DengYimo
 * @Date  4:35
 * @Description This is description of method
 * @Param []
 * @Return java.util.List<com.neusoft.entity.Type>
 * @Since version-1.0
 */
    public List<Type> getTypes() {
        return types;
    }
}
