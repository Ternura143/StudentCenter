package com.studyCenter.dao;

import com.studyCenter.entity.Award;

import java.util.List;
/*
 * @Author DengYimo
 * @Date  8:49
 * @Description 抽象模板接口类
 * @Since version-1.0
 */
public interface AbstractAward {
    boolean addAward(Award award);
    void removeAward(Award award);
    List<Award> getAwards();
}
