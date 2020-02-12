package com.example.notetakingtask.noteAddView;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.notetakingtask.BaseActivity;
import com.example.notetakingtask.R;

public class NoteAddEditActivity extends BaseActivity
{

    //View


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_note_add_edit);

        initClickListener();
        initObservers();
    }

    @Override
    protected void initClickListener()
    {

    }

    @Override
    protected void initObservers() {

    }

}
