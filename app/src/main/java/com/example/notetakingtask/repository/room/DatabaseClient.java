package com.example.notetakingtask.repository.room;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient
{
    private Context mCtx;
    private static DatabaseClient mInstance;

    //our app database object
    private Database appDatabase;

    private DatabaseClient(Context mCtx) {
        this.mCtx = mCtx;

        //creating the app database with Room database builder
        appDatabase = Room.databaseBuilder(mCtx, Database.class, "Note").fallbackToDestructiveMigration().build();
    }

    public static synchronized DatabaseClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DatabaseClient(mCtx);
        }
        return mInstance;
    }

    public Database getAppDatabase() {
        return appDatabase;
    }

    public NoteDao getNoteDao()
    {
        return getAppDatabase().noteDao();
    }

}
