package com.studyCenter.service;

import com.studyCenter.dao.AbstractTSM;
import com.studyCenter.entity.AwardShow;
import com.studyCenter.util.FileOperator;

import java.util.List;

public class AwardShowManager implements AbstractTSM {
        private List<AwardShow> awards;
        private static AwardShowManager singletonInstance;

        private AwardShowManager() {
            awards = FileOperator.loadData("AwardShows.json", AwardShow.class);
        }

        //Singleton Pattern
        public static AwardShowManager getInstance() {
            if (singletonInstance == null) {
                singletonInstance = new AwardShowManager();
            }
            return singletonInstance;
        }
        //Add
        public boolean addAwardShow(AwardShow award) {
            awards.add(award);
            FileOperator.writeData(award, "AwardShows.json");
            return true;
        }
        //Delete
        public void removeAwardShow(AwardShow award) {
            awards.remove(award);
            FileOperator.writeData(awards, "AwardShows.json");
        }

        public List<AwardShow> getAwardShows() {
            return awards;
        }
}


