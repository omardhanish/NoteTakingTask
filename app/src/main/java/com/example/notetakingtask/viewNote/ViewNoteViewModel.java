package com.example.notetakingtask.viewNote;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.notetakingtask.BaseViewModel;
import com.example.notetakingtask.repository.NoteRepository;

public class ViewNoteViewModel extends BaseViewModel
{

    //repo
    private NoteRepository noteRepository;


    public ViewNoteViewModel(@NonNull Application application)
    {
        super(application);
        noteRepository = getRepo(RepoName.NOTE , NoteRepository.class);
    }

}
