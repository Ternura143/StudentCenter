package com.studyCenter.entity;

import com.studyCenter.service.AwardManager;

import java.io.Serializable;

/*
 * @Author DengYimo
 * @Date  4:34
 * @Description This is description of class
 * @Since version-1.0
 */
public class Award implements Serializable {
    public final static String[] TYPES = {"A", "B", "C"};
//    private ArrayList<Problem> problems = new ArrayList<Problem>();
    private String name = "";
    private String type = "A";
    private long id = 0;

//    public ArrayList<Problem> getProblems() {
//        return problems;
//    }

//    public void setProblems(ArrayList<Problem> problems) {
//        this.problems = problems;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static Award newAward() {
        Award award = new Award();
        award.id = AwardManager.getInstance().getAwardId();
        AwardManager.getInstance().setAwardId(award.id + 1);
        return award;
    }

    public Award() {
    }

    public Award(String name) {
        this.id = AwardManager.getInstance().getAwardId();
        this.name = name;
        AwardManager.getInstance().setAwardId(this.id + 1);
    }
}