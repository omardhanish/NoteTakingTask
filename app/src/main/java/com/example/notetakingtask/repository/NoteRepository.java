package com.example.notetakingtask.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

public class NoteRepository
{

    private static NoteRepository INSTANCE;

    public static NoteRepository getINSTANCE(Application application)
    {
        if(INSTANCE == null)
            INSTANCE = new NoteRepository(application);

        return INSTANCE;
    }

    private NoteRepository(Application application)
    {

    }

}
