package com.studyCenter.dao;

import com.studyCenter.entity.AwardShow;

import java.util.List;

public interface AbstractTSM {
    boolean addAwardShow(AwardShow award);
    void removeAwardShow(AwardShow award);
    List<AwardShow> getAwardShows();
}
