package com.studyCenter.service;

import com.studyCenter.dao.AbstractTSM;
import com.studyCenter.entity.AwardShow;
import com.studyCenter.util.FileOperator;

import java.util.List;

/**
 * AwardShowManager is a singleton class that manages the AwardShow objects.
 * It implements the AbstractTSM interface.
 * It has a list of AwardShow objects.
 * It has a private constructor and a public static method getInstance() to get the singleton instance.
 * It has a method addAwardShow() to add an AwardShow object to the list.
 * It has a method removeAwardShow() to remove an AwardShow object from the list.
 * It has a method getAwardShows() to get the list of AwardShow objects.
 */
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


