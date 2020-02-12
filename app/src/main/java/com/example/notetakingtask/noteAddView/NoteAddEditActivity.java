package com.example.notetakingtask.noteAddView;

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

public class NoteAddEditActivity extends BaseActivity
{

    //View
    EditText et_title , et_note;
    TextView tv_save;

    //viewModel
    NoteAddEditViewModel mNoteAddEditViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_note_add_edit);

        et_note = findViewById(R.id.et_note);
        et_title = findViewById(R.id.et_title);
        tv_save = findViewById(R.id.tv_save);

        mNoteAddEditViewModel = new ViewModelProvider(this).get(NoteAddEditViewModel.class);

        initClickListener();
        initObservers();
    }

    @Override
    protected void initClickListener()
    {
        tv_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNoteAddEditViewModel.setSaveOnClick(view);
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
                mNoteAddEditViewModel.setShowHideShowButton(et_title.getText().toString().trim() , et_note.getText().toString().trim());
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
                mNoteAddEditViewModel.setShowHideShowButton(et_title.getText().toString().trim() , et_note.getText().toString().trim());
            }
        });
    }

    @Override
    protected void initObservers()
    {
        mNoteAddEditViewModel.getShowHideShowButton().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean show)
            {
                if(show)
                    tv_save.setVisibility(View.VISIBLE);
                else
                    tv_save.setVisibility(View.INVISIBLE);
            }
        });

        mNoteAddEditViewModel.getSaveOnClick().observe(this, new Observer<View>() {
            @Override
            public void onChanged(View view)
            {
                NoteModel noteModel = new NoteModel();
                noteModel.setTitle(et_title.getText().toString());
                noteModel.setContent(et_note.getText().toString());

                mNoteAddEditViewModel.addNote(noteModel);
            }
        });
    }

}
