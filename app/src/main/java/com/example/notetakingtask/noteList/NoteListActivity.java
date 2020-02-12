package com.example.notetakingtask.noteList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notetakingtask.BaseActivity;
import com.example.notetakingtask.R;
import com.example.notetakingtask.noteAddView.NoteAddEditActivity;
import com.example.notetakingtask.repository.model.NoteModel;

import java.util.ArrayList;
import java.util.List;

public class NoteListActivity extends BaseActivity
{

    //View
    RecyclerView rv_note_list;
    TextView tv_add;

    //adapter
    NoteListAdapter mAdapter;

    //viewModel
    NoteListViewModel mNoteListViewModel;

    List<NoteModel> mNoteModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        rv_note_list = findViewById(R.id.rv_note_list);
        tv_add = findViewById(R.id.tv_add);

        mNoteListViewModel = new ViewModelProvider(this).get(NoteListViewModel.class);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this , RecyclerView.VERTICAL , false);
        rv_note_list.setLayoutManager(linearLayoutManager);

        mAdapter = new NoteListAdapter(this , mNoteModelList);
        rv_note_list.setAdapter(mAdapter);

        initClickListener();
        initObservers();
    }

    @Override
    protected void initClickListener()
    {
        tv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                mNoteListViewModel.setAddNoteOnClick(true);
            }
        });
    }

    @Override
    protected void initObservers()
    {
        mNoteListViewModel.getAddNoteOnClick().observe(this, new Observer<Boolean>()
        {
            @Override
            public void onChanged(Boolean onClick)
            {
                if(onClick != null && onClick)
                {
                    Intent intent = new Intent(NoteListActivity.this , NoteAddEditActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


}
