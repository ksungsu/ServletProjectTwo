package com.sungsu.dto;

import java.io.Serializable;
import java.sql.Date;


public class BoardDTO implements Serializable {
    private int num;
    private String category;
    private String writer;
    private String title;
    private String text;
    private int hit;
    private Date create_date;
    private Date mod_date;
    private String password;

    public BoardDTO() {}
    public BoardDTO(int num, String category, String writer, String title, String text, int hit,
                    Date create_date, Date mod_date, String password) {
        super();
        this.num = num;
        this.category = category;
        this.writer = writer;
        this.title = title;
        this.text = text;
        this.hit = hit;
        this.create_date = create_date;
        this.mod_date = mod_date;
        this.password = password;
    }

    public BoardDTO(String writer, String title, String text, String password) {
        super();
        this.writer = writer;
        this.title = title;
        this.text = text;
        this.password = password;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getMod_date() {
        return mod_date;
    }

    public void setMod_date(Date mod_date) {
        this.mod_date = mod_date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


