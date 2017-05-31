package com.d.yangc.framework.java.bean;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by yangc on 2017/5/25.
 * E-Mail:yangchaojiang@outlook.com
 * Deprecated:
 */
@Entity
public class UserBean {
    @PrimaryKey()
    private Integer id;
    private String seuName;

    @ColumnInfo(name = "user_id")
    private Integer userId;

    @Ignore
    private Date data;

    @Ignore//忽略字段
    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeuName() {
        return seuName;
    }

    public void setSeuName(String seuName) {
        this.seuName = seuName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
