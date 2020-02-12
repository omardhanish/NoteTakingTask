package com.example.notetakingtask.repository.room;

import androidx.room.RoomDatabase;

import com.example.notetakingtask.repository.model.NoteModel;

@androidx.room.Database(entities = {NoteModel.class} , version = 1 , exportSchema = false)
public abstract class Database extends RoomDatabase {

    public abstract NoteDao noteDao();

}
