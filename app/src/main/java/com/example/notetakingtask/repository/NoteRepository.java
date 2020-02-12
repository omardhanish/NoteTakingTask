package com.example.notetakingtask.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.notetakingtask.AsyncProcess;
import com.example.notetakingtask.NoteApplication;
import com.example.notetakingtask.repository.model.NoteModel;
import com.example.notetakingtask.repository.room.DatabaseClient;

import java.util.List;

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

    @Override
    public LiveData<List<NoteModel>> getNoteModelList()
    {
        return DatabaseClient.getInstance(NoteApplication.getInstance()).getNoteDao().getNoteModelList();
    }
}
