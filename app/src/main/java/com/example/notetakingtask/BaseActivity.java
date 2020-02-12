package com.example.notetakingtask;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity
{

    protected final String TAG = getClass().getSimpleName();

    protected abstract void initObservers();
    protected abstract void initClickListener();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

}
