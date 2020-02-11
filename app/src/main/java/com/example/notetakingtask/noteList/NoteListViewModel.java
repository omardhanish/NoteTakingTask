package com.example.notetakingtask.noteList;

import android.app.Application;

import androidx.annotation.NonNull;

import com.example.notetakingtask.BaseViewModel;
import com.example.notetakingtask.repository.NoteRepository;

public class NoteListViewModel extends BaseViewModel
{

    private NoteRepository repository;

    public NoteListViewModel(@NonNull Application application)
    {
        super(application);

        repository = getRepo(RepoName.NOTE , NoteRepository.class);
    }

}
