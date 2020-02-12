package com.example.notetakingtask.repository;

import androidx.lifecycle.LiveData;

import com.example.notetakingtask.repository.model.NoteModel;

import java.util.List;

public interface NoteRepoApi
{

    void addNote(NoteModel noteModel);

    LiveData<List<NoteModel>> getNoteModelList();

}
