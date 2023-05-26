package com.studyCenter.entity;

/**
 * teacher entity
 */
public class Teacher extends AbstractUser {

    public Teacher(String account, String password, String name) {
        super(account, password, name);
    }
}