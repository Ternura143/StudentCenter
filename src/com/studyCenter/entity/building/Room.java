package com.studyCenter.entity.building;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
/*
 * @Author DengYimo
 * @Date  4:50
 * @Description This is description of class
 * @Since version-1.0
 */
public class Room implements Serializable {
    public final static String[] RARETYPES = {"Study Room 1", "Study Room 2", "Study Room 3", "Study Room 4"};
    public final static int STUDYROOMONE = "Study Room 1".hashCode();
    public final static int STUDYROOMTWO = "Study Room 2".hashCode();
    public final static int STUDYROOMTHREE = "Study Room 3".hashCode();
    public final static int STUDYROOMFOUR = "Study Room 4".hashCode();
    private String name;
    private boolean isStudyRoom;
    private int maxCapacity;
    private int resCapacity;
    private ArrayList<StudyRoomApplication> applicationList;

    public ArrayList<StudyRoomApplication> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(ArrayList<StudyRoomApplication> applicationList) {
        this.applicationList = applicationList;
    }

    public Level getFather() {
        return father;
    }

    public void setFather(Level father) {
        this.father = father;
    }

    private int StudyType;
    private ArrayList<Seat> seats;
    private Level father;

    public Room(Level father) {
        applicationList = new ArrayList<StudyRoomApplication>();
        seats = new ArrayList<Seat>();
        this.father = father;
    }

    public Room(String name, boolean isStudyRoom, Level father) {
        applicationList = new ArrayList<StudyRoomApplication>();
        seats = new ArrayList<Seat>();
        this.name = name;
        this.isStudyRoom = isStudyRoom;
        this.father = father;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room() {
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getResCapacity() {
        return resCapacity;
    }

    public void setResCapacity(int resCapacity) {
        this.resCapacity = resCapacity;
    }

    public Room(String name, boolean isStudyRoom, int studyType, Level father, int maxCapacity, int resCapacity) {
        applicationList = new ArrayList<StudyRoomApplication>();
        seats = new ArrayList<Seat>();
        this.name = name;
        this.isStudyRoom = isStudyRoom;
        StudyType = studyType;
        this.father = father;
        this.maxCapacity = maxCapacity;
        this.resCapacity = resCapacity;
    }

    public boolean isStudyRoom() {
        return isStudyRoom;
    }

    public void setStudyRoom(boolean isStudyRoom) {
        this.isStudyRoom = isStudyRoom;
    }

    public int getStudyType() {
        return StudyType;
    }

    public void setStudyType(int studyType) {
        StudyType = studyType;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    public String toString() {
        return this.name;
    }

    public static int getTypeByChinese(String s) {
        if (s.equals("Study Room 1")) return Room.STUDYROOMONE;
        if (s.equals("Study Room 2")) return Room.STUDYROOMTWO;
        if (s.equals("Study Room 3")) return Room.STUDYROOMTHREE;
        if (s.equals("Study Room 4")) return Room.STUDYROOMFOUR;
        return -1;
    }

    public static String getType(int hashNum) {
        if (hashNum == Room.STUDYROOMONE) return "Study Room 1";
        if (hashNum == Room.STUDYROOMTWO) return "Study Room 2";
        if (hashNum == Room.STUDYROOMTHREE) return "Study Room 3";
        if (hashNum == Room.STUDYROOMFOUR) return "Study Room 4";
        return "No";
    }

    public void refreshApplicationTime() {
        Date now = new Date();
        for (int i = 0; i < applicationList.size(); i++) {
            long applicationTime = applicationList.get(i).getStartTime().getTime();
            if ((new Date(applicationTime + applicationList.get(i).getDurationTime())).before(now)) {
                applicationList.remove(i);
                i--;
            }
        }
        resCapacity = maxCapacity - applicationList.size();
    }
}
