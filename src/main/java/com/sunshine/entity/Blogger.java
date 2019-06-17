package com.sunshine.entity;

import java.util.Date;

public class Blogger {
    private String id;

    private String title;

    private String content;

    private Date createTime;

    private String author;

    public Blogger(String id, String title, String content, Date createTime, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.author = author;
    }

    public Blogger() {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }
}