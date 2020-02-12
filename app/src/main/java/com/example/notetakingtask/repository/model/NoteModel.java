package com.example.notetakingtask.repository.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.notetakingtask.utils.PojoUtils;

@Entity
public class NoteModel
{
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String content;

    private String timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return PojoUtils.checkResult(title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return PojoUtils.checkResult(content);
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return PojoUtils.checkResult(timestamp);
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
