package com.example.notetakingtask.repository.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.notetakingtask.repository.model.NoteModel;

import java.util.List;

@Dao
public interface NoteDao
{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertNoteModel(NoteModel noteModel);

    @Query("select * from NoteModel order by id desc")
    LiveData<List<NoteModel>> getNoteModelList();

}
