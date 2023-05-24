package com.studyCenter.entity;
/*
 * @Author DengYimo
 * @Date  4:36
 * @Description This is description of class
 * @Since version-1.0
 */
public class Staff extends AbstractUser {
    private String birthday;
    private String specialty;
    private String title;
    private String contact;
    private String id;

    public Staff(String account, String password, String name, String birthday, String specialty, String title, String contact, String id) {
        super(account, password, name);
        this.birthday = birthday;
        this.specialty = specialty;
        this.title = title;
        this.contact = contact;
        this.id = id;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getTitle() {
        return title;
    }

    public String getContact() {
        return contact;
    }

    public String getId() {
        return id;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setId(String id) {
        this.id = id;
    }
}
