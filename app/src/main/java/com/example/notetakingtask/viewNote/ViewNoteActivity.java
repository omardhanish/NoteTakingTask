package com.example.notetakingtask.viewNote;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.notetakingtask.BaseActivity;
import com.example.notetakingtask.R;
import com.example.notetakingtask.addNote.AddNoteActivity;
import com.example.notetakingtask.noteList.NoteListActivity;

public class ViewNoteActivity extends BaseActivity {

    //view
    private TextView tv_title , tv_timestamp , tv_note;

    //viewModel
    private ViewNoteViewModel mViewNoteViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);

        tv_title = findViewById(R.id.tv_title);
        tv_timestamp = findViewById(R.id.tv_timestamp);
        tv_note = findViewById(R.id.tv_note);

        mViewNoteViewModel = new ViewModelProvider(this).get(ViewNoteViewModel.class);

        String title = getIntent().getStringExtra(AddNoteActivity.IntentData.TITLE.name());
        String content = getIntent().getStringExtra(AddNoteActivity.IntentData.CONTENT.name());

        tv_title.setText(title);
        tv_note.setText(content);
    }

    @Override
    protected void initObservers() {

    }

    @Override
    protected void initClickListener() {

    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();

        if(getIntent().hasExtra(AddNoteActivity.IntentData.FROM_ADD_NOTE.name()))
        {
            Intent intent = new Intent(ViewNoteActivity.this , NoteListActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}
