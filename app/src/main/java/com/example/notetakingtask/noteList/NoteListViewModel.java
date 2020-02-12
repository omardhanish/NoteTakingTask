package com.example.notetakingtask.noteList;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.notetakingtask.BaseViewModel;
import com.example.notetakingtask.repository.NoteRepoApi;
import com.example.notetakingtask.repository.NoteRepository;

public class NoteListViewModel extends BaseViewModel
{

    // repository
    private NoteRepoApi mNoteRepoApi;

    //LiveData
    private MutableLiveData<Boolean> addNoteOnClick = new MutableLiveData<>();

    public NoteListViewModel(@NonNull Application application)
    {
        super(application);

        mNoteRepoApi = getRepo(RepoName.NOTE , NoteRepository.class);
    }

    public MutableLiveData<Boolean> getAddNoteOnClick() {
        return addNoteOnClick;
    }

    public void setAddNoteOnClick(Boolean addNoteOnClick) {
        this.addNoteOnClick.setValue(addNoteOnClick);
    }
}
