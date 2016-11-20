package com.autostore.pojo;

public class Solution implements Comparable<Solution>{
    private int a_id;
    private String author;
    private String text;
    private int q_id;

    public int getQuestionId() {
        return q_id;
    }

    public void setQuestionId(int q_id) {
        this.q_id = q_id;
    }

    public int getAnswerId() {
        return a_id;
    }

    public void setAnswerId(int a_id) {
        this.a_id = a_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int compareTo(Solution o) {
        return this.a_id - o.getAnswerId();
    }
}
