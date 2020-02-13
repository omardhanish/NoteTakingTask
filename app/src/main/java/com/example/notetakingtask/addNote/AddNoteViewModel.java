package com.example.notetakingtask.addNote;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.notetakingtask.BaseViewModel;
import com.example.notetakingtask.repository.NoteRepoApi;
import com.example.notetakingtask.repository.NoteRepository;
import com.example.notetakingtask.repository.model.NoteModel;

public class AddNoteViewModel extends BaseViewModel
{
    //repo
    private NoteRepoApi mNoteRepository;

    //liveData
    private MutableLiveData<View> saveOnClick = new MutableLiveData<>();
    private MutableLiveData<Boolean> updateUiBasedOnContent = new MutableLiveData<>();

    //flag
    boolean allowSaveClick = false;

    public AddNoteViewModel(@NonNull Application application) {
        super(application);
        mNoteRepository = getRepo(RepoName.NOTE , NoteRepository.class);
    }

    // liveData
    MutableLiveData<View> getSaveOnClick() { return saveOnClick; }

    MutableLiveData<Boolean> getUpdateUiBasedOnContent() {
        return updateUiBasedOnContent;
    }

    //repo helper methods
    void addNote(NoteModel noteModel)
    {
        mNoteRepository.addNote(noteModel);
    }

    //Test logic's
    public boolean isTitleNoteNotEmpty(String title , String note)
    {
        return title != null && note != null && title.trim().length() > 0  && note.trim().length() > 0;
    }

}
