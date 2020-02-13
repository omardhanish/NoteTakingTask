package com.example.notetakingtask.viewNote;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.notetakingtask.BaseViewModel;
import com.example.notetakingtask.repository.NoteRepoApi;
import com.example.notetakingtask.repository.NoteRepository;

public class ViewNoteViewModel extends BaseViewModel
{

    //repo
    private NoteRepoApi noteRepository;

    //LiveData
    private MutableLiveData<Boolean> setNoteDetails = new MutableLiveData<>();

    //flag
    boolean fromAddNote = false;
    //ui data
    String title = "" , content = "" , timeStamp = "";


    public ViewNoteViewModel(@NonNull Application application)
    {
        super(application);
        noteRepository = getRepo(RepoName.NOTE , NoteRepository.class);
    }

    MutableLiveData<Boolean> getSetNoteDetails() {
        return setNoteDetails;
    }
}
