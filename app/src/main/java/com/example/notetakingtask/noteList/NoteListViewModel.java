package com.example.notetakingtask.noteList;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.notetakingtask.BaseViewModel;
import com.example.notetakingtask.repository.NoteRepoApi;
import com.example.notetakingtask.repository.NoteRepository;
import com.example.notetakingtask.repository.model.NoteModel;

import java.util.List;

public class NoteListViewModel extends BaseViewModel
{

    // repository
    private NoteRepoApi mNoteRepoApi;

    //LiveData
    private MutableLiveData<View> addNoteOnClick = new MutableLiveData<>();
    private LiveData<List<NoteModel>> noteModelList;

    public NoteListViewModel(@NonNull Application application)
    {
        super(application);

        mNoteRepoApi = getRepo(RepoName.NOTE , NoteRepository.class);
        noteModelList = mNoteRepoApi.getNoteModelList();
    }

    //liveData
    MutableLiveData<View> getAddNoteOnClick() {
        return addNoteOnClick;
    }

    LiveData<List<NoteModel>> getNoteModelList() {
        return noteModelList;
    }

    void setAddNoteOnClick(View view) {
        this.addNoteOnClick.setValue(view);
    }
}
