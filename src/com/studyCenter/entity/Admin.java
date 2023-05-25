package com.studyCenter.entity;
/*
 * @Author DengYimo
 * @Date  4:49
 * @Description This is description of class
 * @Since version-1.0
 */
public class Admin extends AbstractUser {

    public Admin(String account, String password, String name) {
        super(account, password, name);
    }
}