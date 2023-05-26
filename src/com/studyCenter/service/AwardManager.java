package com.studyCenter.service;

import com.studyCenter.dao.AbstractAward;
import com.studyCenter.entity.Course;
import com.studyCenter.entity.Award;
import com.studyCenter.util.FileOperator;
import java.util.List;

/**
 * AwardManager is a singleton class that manages the Award objects.
 * It implements the AbstractAward interface.
 * It has a list of Award objects and a long variable awardId.
 * It has a private constructor and a public static method getInstance() to get the singleton instance.
 * It has a method addAward() to add an Award object to the list.
 * It has a method removeAward() to remove an Award object from the list.
 * It has a method getAwards() to get the list of Award objects.
 * It has a method getAwardId() to get the awardId.
 * It has a method setAwardId() to set the awardId.
 * It has a method setAwards() to set the list of Award objects.
 * It has a method setInstance() to set the singleton instance.
 * It has a method setAwardId() to set the awardId.
 * It has a method setAwards() to set the list of Award objects.
 * It has a method setInstance() to set the singleton instance.
 */
public class AwardManager implements AbstractAward {
    private List<Award> awards;
    private long awardId = 1;
    private static AwardManager singletonInstance;

    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }

    public long getAwardId() {
        return awardId;
    }

    public void setAwardId(long awardId) {
        this.awardId = awardId;
    }


    private AwardManager() {
        awards = FileOperator.loadData("Awards.json", Course.class);
    }

    //Singleton Pattern
    public static AwardManager getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new AwardManager();
        }
        return singletonInstance;
    }


    //Add
    public boolean addAward(Award award) {
        awards.add(award);
        FileOperator.writeData(award, "Awards.json");
        return true;
    }
    //Delete
    public void removeAward(Award award) {
        awards.remove(award);
        FileOperator.writeData(awards, "Awards.json");
    }

    public List<Award> getAwards() {
        return awards;
    }
}

