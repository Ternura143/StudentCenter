package com.studyCenter.service;

import com.studyCenter.dao.AbstractAward;
import com.studyCenter.entity.Course;
import com.studyCenter.entity.Award;
import com.studyCenter.util.FileOperator;
import java.util.List;

public class AwardManager implements AbstractAward {
    private List<Award> awards;
    private long awardId = 1;
    private static AwardManager singletonInstance;

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
