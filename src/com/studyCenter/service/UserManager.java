package com.studyCenter.service;

import com.studyCenter.entity.AbstractUser;
import com.studyCenter.entity.Admin;
import com.studyCenter.entity.Student;
import com.studyCenter.util.FileOperator;

import java.util.List;

public class UserManager {
    private List<Student> students;
//    private  List<Admin> admins;
    private AbstractUser currentUser;
    private static UserManager singletonInstance;

    //实现单例模式
    public static UserManager getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new UserManager();
        }
        return singletonInstance;
    }

    private UserManager() {
        students =  FileOperator.loadData("Students.json", Student.class);
//        admins = FileOperator.loadData("Admins.json", Admin.class);
    }

    /**
     * 用于验证密码输入的重要方法，并将所对应的身份信息写入本地currentUser变量，等待下一个界面读取
     * @param account 输入的账户
     * @param password 输入的密码
     * @param role  角色 1=管理员，2=员工
     * @return  boolean 表示密码验证成功与否
     */
    public boolean CheckLogin(String account, String password, int role){
//        if (role == 1) {    // Admin
//            for (Admin localAdmin : admins) {
//                if(localAdmin.getAccount().equals(account) && localAdmin.getPassword().equals(password)) {
//                    currentUser = localAdmin;
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

//    public boolean addAdmin(Admin admin) {
//        for (Admin localAdmin : admins) {
//            if (admin.getAccount().equals(localAdmin.getAccount()))
//                return false;
//        }
//        admins.add(admin);
//        FileOperator.writeData(admin, "Admins.json");
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

//    public boolean removeAdmin(AbstractUser user) {
//        if (user.getClass() == Admin.class) {
//            admins.remove(user);
//            FileOperator.writeData(admins, "Admins.json");
//            return true;
//        } else if (user.getClass() == Student.class) {
//            students.remove(user);
//            FileOperator.writeData(students, "Admins.json");
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
//    public List<Admin> getAdmins() {
//        return admins;
//    }
}
