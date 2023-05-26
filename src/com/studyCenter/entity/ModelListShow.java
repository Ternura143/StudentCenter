package com.studyCenter.entity;

/**
 * model list show entity
 */
public class ModelListShow {
    private String id;
    private String content;
    private String mode;

    public ModelListShow(String id, String content, String mode) {
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
