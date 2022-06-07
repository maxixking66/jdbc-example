package com.maktabsharif74.jdbcexample.domain;

public class Article {

    private int id;

    private String title;

    private String content;

    //    mandatory one
    //    many to one
    private User writer;

    public Article() {
    }

    public Article(String title, String content, User writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public Article(int id, String title, String content, User writer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getWriter() {
        return writer;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer=" + writer.toStringBrief() +
                '}';
    }
}
