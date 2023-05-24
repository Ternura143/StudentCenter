package com.studyCenter.entity;
/*
 * @Author DengYimo
 * @Date  4:43
 * @Description This is description of class
 * @Since version-1.0
 */
public class CourseTester {
    private String evaluater;
    private String time;
    private String gender;
    private String awardName;
    private String awardMode;
    private String name;
    private String advice;
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getAwardMode() {
        return awardMode;
    }
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of method
 * @Param [awardMode]
 * @Return void
 * @Since version-1.0
 */
    public void setAwardMode(String awardMode) {
        this.awardMode = awardMode;
    }
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getAdvice() {
        return advice;
    }
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of method
 * @Param [advice]
 * @Return void
 * @Since version-1.0
 */
    public void setAdvice(String advice) {
        this.advice = advice;
    }
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of method
 * @Param [name, awardName, awardMode, gender, time, evaluater, advice]
 * @Return 
 * @Since version-1.0
 */
    public CourseTester(String name, String awardName, String awardMode, String gender, String time, String evaluater, String advice) {
        this.name = name;
        this.awardName = awardName;
        this.gender = gender;
        this.time = time;
        this.evaluater = evaluater;
        this.awardMode = awardMode;
        this.advice = advice;
    }
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getTime() {
        return time;
    }
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of method
 * @Param [time]
 * @Return void
 * @Since version-1.0
 */
    public void setTime(String time) {
        this.time = time;
    }
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getAwardName() {
        return awardName;
    }
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of method
 * @Param [awardName]
 * @Return void
 * @Since version-1.0
 */
    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getName() {
        return name;
    }
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of method
 * @Param [name]
 * @Return void
 * @Since version-1.0
 */
    public void setName(String name) {
        this.name = name;
    }
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getGender() {
        return gender;
    }
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of method
 * @Param [gender]
 * @Return void
 * @Since version-1.0
 */
    public void setGender(String gender) {
        this.gender = gender;
    }
/*
 * @Author DengYimo
 * @Date  4:44
 * @Description This is description of method
 * @Param []
 * @Return java.lang.String
 * @Since version-1.0
 */
    public String getEvaluater() {
        return evaluater;
    }
/*
 * @Author DengYimo
 * @Date  4:46
 * @Description This is description of method
 * @Param [evaluater]
 * @Return void
 * @Since version-1.0
 */
    public void setEvaluater(String evaluater) {
        this.evaluater = evaluater;
    }
}
