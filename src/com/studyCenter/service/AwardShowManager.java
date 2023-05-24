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

        //单例模式
        public static AwardShowManager getInstance() {
            if (singletonInstance == null) {
                singletonInstance = new AwardShowManager();
            }
            return singletonInstance;
        }
        //增
        public boolean addAwardShow(AwardShow award) {
            awards.add(award);
            FileOperator.writeData(award, "AwardShows.json");
            return true;
        }
        //删
        public void removeAwardShow(AwardShow award) {
            awards.remove(award);
            FileOperator.writeData(awards, "AwardShows.json");
        }

        public List<AwardShow> getAwardShows() {
            return awards;
        }
}


