package com.example.notetakingtask.addNote;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.notetakingtask.BaseViewModel;
import com.example.notetakingtask.repository.NoteRepository;
import com.example.notetakingtask.repository.model.NoteModel;

public class AddNoteViewModel extends BaseViewModel
{
    //repo
    private NoteRepository mNoteRepository;

    //liveData
    private MutableLiveData<View> saveOnClick = new MutableLiveData<>();
    private MutableLiveData<Boolean> showHideShowButton = new MutableLiveData<>();

    public AddNoteViewModel(@NonNull Application application) {
        super(application);
        mNoteRepository = getRepo(RepoName.NOTE , NoteRepository.class);
    }

    // live
    MutableLiveData<View> getSaveOnClick() {
        return saveOnClick;
    }

    void setSaveOnClick(View view)
    {
        saveOnClick.setValue(view);
    }

    MutableLiveData<Boolean> getShowHideShowButton() {
        return showHideShowButton;
    }

    void setShowHideShowButton(String title , String note)
    {
        this.showHideShowButton.setValue(title.length() > 0  && note.length() > 0);
    }

    // other
    void addNote(NoteModel noteModel)
    {
        mNoteRepository.addNote(noteModel);
    }


}
