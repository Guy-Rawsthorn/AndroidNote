package com.example.guyrawsthorn.samplebook;

/**
 * Created by guyrawsthorn on 26/07/2017.
 */


public class Note {

    private int id;
    private String title;
    private String body;

    public Note(){}

    public Note(String title, String body) {
        super();
        this.title = title;
        this.body = body;
    }

    //getters & setters

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", body=" + body
                + "]";
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }
}