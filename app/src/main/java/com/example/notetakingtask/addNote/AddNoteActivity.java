package com.example.notetakingtask.addNote;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.notetakingtask.BaseActivity;
import com.example.notetakingtask.R;
import com.example.notetakingtask.repository.model.NoteModel;
import com.example.notetakingtask.utils.CommonUtils;
import com.example.notetakingtask.viewNote.ViewNoteActivity;

public class AddNoteActivity extends BaseActivity
{

    public enum IntentData {
        TITLE , CONTENT , TIMESTAMP ,  FROM_ADD_NOTE
    }

    //View
    EditText et_title , et_note;
    TextView tv_save , tv_max_lengt;

    //viewModel
    AddNoteViewModel mAddNoteViewModel;

    //flag
    private boolean allowSaveClick = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_note_add_edit);

        et_note = findViewById(R.id.et_note);
        et_title = findViewById(R.id.et_title);
        tv_save = findViewById(R.id.tv_save);
        tv_max_lengt = findViewById(R.id.tv_max_lengt);

        mAddNoteViewModel = new ViewModelProvider(this).get(AddNoteViewModel.class);

        initClickListener();
        initObservers();

        setUpdateUiBasedOnContent();
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
                setUpdateUiBasedOnContent();
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
                setUpdateUiBasedOnContent();
            }
        });
    }

    private void setUpdateUiBasedOnContent()
    {
        mAddNoteViewModel.setUpdateUiBasedOnContent(et_title.getText().toString().trim() , et_note.getText().toString().trim());
    }

    @Override
    protected void initObservers()
    {
        mAddNoteViewModel.getUpdateUiBasedOnContent().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean show)
            {
                allowSaveClick = show;
                tv_max_lengt.setText("(" + et_title.getText().toString().length() +  "/100) ");
                if(show)
                {
                    tv_save.setBackground(getResources().getDrawable(R.drawable.border_green));
                } else{
                    tv_save.setBackground(getResources().getDrawable(R.drawable.border_green_disabled));
                }
            }
        });

        mAddNoteViewModel.getSaveOnClick().observe(this, new Observer<View>() {
            @Override
            public void onChanged(View view)
            {
                if(allowSaveClick)
                {
                    NoteModel noteModel = new NoteModel();
                    noteModel.setTitle(et_title.getText().toString());
                    noteModel.setContent(et_note.getText().toString());
                    noteModel.setTimestamp(CommonUtils.getTimeStamp());

                    mAddNoteViewModel.addNote(noteModel);

                    Intent intent = new Intent(AddNoteActivity.this , ViewNoteActivity.class);
                    intent.putExtra(IntentData.CONTENT.name() , noteModel.getContent());
                    intent.putExtra(IntentData.TITLE.name() , noteModel.getTitle());
                    intent.putExtra(IntentData.TIMESTAMP.name() , noteModel.getTimestamp());
                    intent.putExtra(IntentData.FROM_ADD_NOTE.name() , true);
                    startActivity(intent);
                }else {
                    Toast.makeText(AddNoteActivity.this, getString(R.string.title_and_content_must_not_be_empty), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
