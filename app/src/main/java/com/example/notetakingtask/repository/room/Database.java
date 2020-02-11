package com.example.notetakingtask.repository.room;

import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {} , version = 1 , exportSchema = false)
public abstract class Database extends RoomDatabase {

    public abstract NoteDao noteDao();

}
