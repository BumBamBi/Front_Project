package com.ssafy.model.dto;
public class Board {
    private int no;
    private String title;
    private String author;
    private int hits;
    private String body;
    private String date;
    
    public Board(int no, String title, String author, int hits, String body, String date) {
        this.no = no;
        this.title = title;
        this.author = author;
        this.hits = hits;
        this.body = body;
        this.date = date;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
