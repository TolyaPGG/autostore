package com.autostore.pojo;


import java.util.Date;

public class Discussion
        implements Comparable<Discussion>
{
    private int q_id;
    private String author;
    private Date date;
    private String text;
    private String theme;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTheme(String theme) {

        this.theme = theme;
    }

    public String getTheme() {
        return theme;
    }


    public int getQ_id() {
        return q_id;
    }

    public void setQ_id(int q_id) {
        this.q_id = q_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int compareTo(Discussion o) {
        return this.date.compareTo(o.getDate());
    }
}
