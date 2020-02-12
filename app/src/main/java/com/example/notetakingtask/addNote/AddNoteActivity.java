package com.example.notetakingtask.addNote;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.notetakingtask.BaseActivity;
import com.example.notetakingtask.R;
import com.example.notetakingtask.repository.model.NoteModel;
import com.example.notetakingtask.viewNote.ViewNoteActivity;

public class AddNoteActivity extends BaseActivity
{

    public enum IntentData {
        TITLE , CONTENT , FROM_ADD_NOTE
    }

    //View
    EditText et_title , et_note;
    TextView tv_save;

    //viewModel
    AddNoteViewModel mAddNoteViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_note_add_edit);

        et_note = findViewById(R.id.et_note);
        et_title = findViewById(R.id.et_title);
        tv_save = findViewById(R.id.tv_save);

        mAddNoteViewModel = new ViewModelProvider(this).get(AddNoteViewModel.class);

        initClickListener();
        initObservers();
    }

    @Override
    protected void initClickListener()
    {
        tv_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAddNoteViewModel.setSaveOnClick(view);
            }
        });

        et_title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mAddNoteViewModel.setShowHideShowButton(et_title.getText().toString().trim() , et_note.getText().toString().trim());
            }
        });

        et_note.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mAddNoteViewModel.setShowHideShowButton(et_title.getText().toString().trim() , et_note.getText().toString().trim());
            }
        });
    }

    @Override
    protected void initObservers()
    {
        mAddNoteViewModel.getShowHideShowButton().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean show)
            {
                if(show)
                    tv_save.setVisibility(View.VISIBLE);
                else
                    tv_save.setVisibility(View.INVISIBLE);
            }
        });

        mAddNoteViewModel.getSaveOnClick().observe(this, new Observer<View>() {
            @Override
            public void onChanged(View view)
            {
                NoteModel noteModel = new NoteModel();
                noteModel.setTitle(et_title.getText().toString());
                noteModel.setContent(et_note.getText().toString());

                mAddNoteViewModel.addNote(noteModel);

                Intent intent = new Intent(AddNoteActivity.this , ViewNoteActivity.class);
                intent.putExtra(IntentData.CONTENT.name() , noteModel.getContent());
                intent.putExtra(IntentData.TITLE.name() , noteModel.getTitle());
                intent.putExtra(IntentData.FROM_ADD_NOTE.name() , true);
                startActivity(intent);
            }
        });
    }

}
