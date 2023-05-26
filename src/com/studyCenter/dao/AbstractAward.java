package com.studyCenter.dao;

import com.studyCenter.entity.Award;

import java.util.List;

/**
 * interface AbstractAward
 */
public interface AbstractAward {
    boolean addAward(Award award);
    void removeAward(Award award);
    List<Award> getAwards();
}
