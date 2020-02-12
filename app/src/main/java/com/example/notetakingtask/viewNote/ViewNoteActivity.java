package com.example.notetakingtask.viewNote;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.notetakingtask.BaseActivity;
import com.example.notetakingtask.R;
import com.example.notetakingtask.addNote.AddNoteActivity;
import com.example.notetakingtask.noteList.NoteListActivity;

public class ViewNoteActivity extends BaseActivity {

    //view
    private TextView  tv_timestamp , tv_note, tv_header_toolbar;

    //viewModel
    private ViewNoteViewModel mViewNoteViewModel;

    //flags
    private boolean fromAddNote = false;

    String title = "" , content = "" , timeStamp = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);

        tv_timestamp = findViewById(R.id.tv_timestamp);
        tv_note = findViewById(R.id.tv_note);
        tv_header_toolbar = findViewById(R.id.tv_header_toolbar);

        mViewNoteViewModel = new ViewModelProvider(this).get(ViewNoteViewModel.class);

        fromAddNote = getIntent().getBooleanExtra(AddNoteActivity.IntentData.FROM_ADD_NOTE.name() , false);
        title = fromAddNote ? getIntent().getStringExtra(AddNoteActivity.IntentData.TITLE.name()) :
                getIntent().getStringExtra(NoteListActivity.IntentData.TITLE.name());
        content = fromAddNote ? getIntent().getStringExtra(AddNoteActivity.IntentData.CONTENT.name()) :
                getIntent().getStringExtra(NoteListActivity.IntentData.TITLE.name());
        timeStamp = fromAddNote ? getIntent().getStringExtra(AddNoteActivity.IntentData.TIMESTAMP.name()) :
                getIntent().getStringExtra(NoteListActivity.IntentData.TIMESTAMP.name());

        initObservers();

        mViewNoteViewModel.getSetNoteDetails().setValue(true);
    }

    @Override
    protected void initObservers()
    {
        mViewNoteViewModel.getSetNoteDetails().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean update)
            {
                if(update)
                {
                    tv_header_toolbar.setText(title);
                    tv_note.setText(content);
                    tv_timestamp.setText(timeStamp);
                }
            }
        });
    }

    @Override
    protected void initClickListener() {

    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();

        if(fromAddNote)
        {
            Intent intent = new Intent(ViewNoteActivity.this , NoteListActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}
