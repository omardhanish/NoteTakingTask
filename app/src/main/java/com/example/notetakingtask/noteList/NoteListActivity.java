package com.example.notetakingtask.noteList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notetakingtask.BaseActivity;
import com.example.notetakingtask.R;
import com.example.notetakingtask.addNote.AddNoteActivity;
import com.example.notetakingtask.repository.model.NoteModel;
import com.example.notetakingtask.viewNote.ViewNoteActivity;

import java.util.ArrayList;
import java.util.List;

public class NoteListActivity extends BaseActivity
{
    public enum IntentData {
        TITLE , CONTENT , FROM_NOTE_LIST
    }

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
        mAdapter.setNoteListViewModel(mNoteListViewModel);
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
                mNoteListViewModel.setAddNoteOnClick(view);
            }
        });
    }

    @Override
    protected void initObservers()
    {
        mNoteListViewModel.getAddNoteOnClick().observe(this, new Observer<View>()
        {
            @Override
            public void onChanged(View view)
            {
                if(view != null)
                {
                    Intent intent = new Intent(NoteListActivity.this , AddNoteActivity.class);
                    startActivity(intent);
                }
            }
        });

        mNoteListViewModel.getNoteModelList().observe(this, new Observer<List<NoteModel>>() {
            @Override
            public void onChanged(final List<NoteModel> noteModels)
            {
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        if(noteModels != null)
                        {
                            mNoteModelList.clear();
                            mNoteModelList.addAll(noteModels);

                            if(mAdapter != null)
                                mAdapter.notifyDataSetChanged();
                        }
                    }
                });
            }
        });

        mNoteListViewModel.getCallViewActivity().observe(this, new Observer<Integer>()
        {
            @Override
            public void onChanged(Integer position)
            {
                Intent intent  = new Intent(NoteListActivity.this , ViewNoteActivity.class);
                intent.putExtra(IntentData.TITLE.name() , mNoteModelList.get(position).getTitle());
                intent.putExtra(IntentData.CONTENT.name() , mNoteModelList.get(position).getContent());
                intent.putExtra(IntentData.FROM_NOTE_LIST.name() , true);

                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(NoteListActivity.this ,
                        mAdapter.getTransitionView() , mAdapter.getTransitionView().getTransitionName());

                startActivity(intent , activityOptionsCompat.toBundle());
            }
        });
    }


}
