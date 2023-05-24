package com.studyCenter.dao;

import com.studyCenter.entity.AwardShow;

import java.util.List;
/*
 * @Author DengYimo
 * @Date  8:49
 * @Description 抽象测试管理接口
 * @Since version-1.0
 */
public interface AbstractTSM {
    boolean addAwardShow(AwardShow award);
    void removeAwardShow(AwardShow award);
    List<AwardShow> getAwardShows();
}
