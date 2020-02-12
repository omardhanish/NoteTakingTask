package com.example.notetakingtask.repository;

import android.app.Application;

import com.example.notetakingtask.AsyncProcess;
import com.example.notetakingtask.repository.model.NoteModel;

// Singleton repository
public class NoteRepository implements NoteRepoApi
{

    private static NoteRepository INSTANCE;

    public static NoteRepository getINSTANCE()
    {
        if(INSTANCE == null)
            INSTANCE = new NoteRepository();

        return INSTANCE;
    }

    private NoteRepository()
    {

    }

    @Override
    public void addNote(NoteModel noteModel)
    {
        AsyncProcess.commonAsyncTaskPerformer(AsyncProcess.AsyncTaskName.ADD_NOTE, null , noteModel);
    }

}
