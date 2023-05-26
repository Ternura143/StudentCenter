package com.studyCenter.entity.building;

import com.studyCenter.entity.Course;

import java.io.Serializable;
import java.util.Date;

/**
 * study room application entity
 */
public class StudyRoomApplication implements Serializable {
    public static long TIMESCALE = 1000 * 60 * 60;
    private Date startTime;
    private long durationTime;
    private Course applier;
    private Room room;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public long getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(long durationTime) {
        this.durationTime = durationTime;
    }

    public void setDurationTime(int durationTime) {
        this.durationTime = durationTime;
    }

    public Course getApplier() {
        return applier;
    }

    public void setApplier(Course applier) {
        this.applier = applier;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public StudyRoomApplication(Date startTime, long durationTime, Course applier, Room room) {
        this.startTime = startTime;
        this.durationTime = durationTime;
        this.applier = applier;
        this.room = room;
    }

    public StudyRoomApplication() {
    }

    public StudyRoomApplication(Date startTime, int durationTime, Course applier, Room room) {
        this.startTime = startTime;
        this.durationTime = durationTime;
        this.applier = applier;
        this.room = room;
    }

}
