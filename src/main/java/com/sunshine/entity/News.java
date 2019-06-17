package com.sunshine.entity;

public class News {
    private String id;

    private String title;

    private String content;

    private String type;

    public News(String id, String title, String content, String type) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.type = type;
    }

    public News() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}