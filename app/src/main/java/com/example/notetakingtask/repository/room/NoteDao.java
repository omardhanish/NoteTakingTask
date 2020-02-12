package com.example.notetakingtask.repository.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.notetakingtask.repository.model.NoteModel;

@Dao
public interface NoteDao
{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertNoteModel(NoteModel noteModel);

}
