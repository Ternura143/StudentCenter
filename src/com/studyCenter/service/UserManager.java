package com.studyCenter.service;

import com.studyCenter.entity.AbstractUser;
import com.studyCenter.entity.Student;
import com.studyCenter.util.FileOperator;

import java.util.List;

/**
 * UserManager is a singleton class that manages the User objects.
 * It has a list of User objects.
 * It has a private constructor and a public static method getInstance() to get the singleton instance.
 * It has a method addTeacher() to add an Teacher object to the list.
 * It has a method removeTeacher() to remove an Teacher object from the list.
 * It has a method getTeachers() to get the list of Teacher objects.
 */
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
    }


    /**
     * CheckLogin is a method that checks if the account and password are correct.
     * @param account account of the user
     * @param password password of the user
     * @param role role of the user
     * @return true if the account and password are correct, false otherwise
     */
    public boolean CheckLogin(String account, String password, int role){
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


    public boolean addStudent(Student student) {
        for (Student localStudent : students) {
            if (student.getAccount().equals(localStudent.getAccount()))
                return false;
        }
        students.add(student);
        FileOperator.writeData(students, "Students.json");
        return true;
    }


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

}
