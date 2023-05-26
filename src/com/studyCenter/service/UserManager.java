package com.studyCenter.service;

import com.studyCenter.entity.AbstractUser;
import com.studyCenter.entity.Student;
import com.studyCenter.util.FileOperator;

import java.util.List;

public class UserManager {
    private List<Student> students;
//    private  List<Teacher> teachers;
    private AbstractUser currentUser;
    private static UserManager singletonInstance;

    //Singleton Pattern
    public static UserManager getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new UserManager();
        }
        return singletonInstance;
    }

    private UserManager() {
        students =  FileOperator.loadData("Students.json", Student.class);
//        teachers = FileOperator.loadData("Teachers.json", Teacher.class);
    }

    /**
     * 用于验证密码输入的重要方法，并将所对应的身份信息写入本地currentUser变量，等待下一个界面读取
     * @param account 输入的账户
     * @param password 输入的密码
     * @param role  角色 1=Teacher，2=Student
     * @return  boolean 表示密码验证成功与否
     */
    public boolean CheckLogin(String account, String password, int role){
//        if (role == 1) {    // Teacher
//            for (Teacher localTeacher : teachers) {
//                if(localTeacher.getAccount().equals(account) && localTeacher.getPassword().equals(password)) {
//                    currentUser = localTeacher;
//                    return true;
//                }
//            }
//        }
        if (role == 2) {    // Student
            for (Student localStudent : students) {
                if (localStudent.getAccount().equals(account) && localStudent.getPassword().equals(password)) {
                    currentUser = localStudent;
                    return true;
                }
            }
        }
        return false;
    }

//    public boolean addTeacher(Teacher teacher) {
//        for (Teacher localTeacher : teachers) {
//            if (teacher.getAccount().equals(localTeacher.getAccount()))
//                return false;
//        }
//        teachers.add(teacher);
//        FileOperator.writeData(teacher, "Teachers.json");
//        return true;
//    }

    public boolean addStudent(Student student) {
        for (Student localStudent : students) {
            if (student.getAccount().equals(localStudent.getAccount()))
                return false;
        }
        students.add(student);
        FileOperator.writeData(students, "Students.json");
        return true;
    }

//    public boolean removeTeacher(AbstractUser user) {
//        if (user.getClass() == Teacher.class) {
//            teachers.remove(user);
//            FileOperator.writeData(teachers, "Teachers.json");
//            return true;
//        } else if (user.getClass() == Student.class) {
//            students.remove(user);
//            FileOperator.writeData(students, "Teachers.json");
//            return true;
//        }
//        return false;
//    }

    public boolean removeStudent(AbstractUser user) {
        if (user.getClass() == Student.class) {
            students.remove(user);
            FileOperator.writeData(students, "Students.json");
            return true;
        }
        return false;
    }

    public List<Student> getStudents() {
        return students;
    }

//    public AbstractUser getCurrentUser() {
//        return currentUser;
//    }
//
//    public List<Teacher> getTeachers() {
//        return teachers;
//    }
}
