package com.studyCenter.entity;
/*
 * @Author DengYimo
 * @Date  4:33
 * @Description This is description of class
 * @Since version-1.0
 */
public class AwardShow {
    private String id;
    private String content;
    private String mode;

    public AwardShow(String id, String content, String mode) {
        this.id = id;
        this.content = content;
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
