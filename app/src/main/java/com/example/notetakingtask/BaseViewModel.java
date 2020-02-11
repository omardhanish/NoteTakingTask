package com.example.notetakingtask;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.notetakingtask.repository.NoteRepository;

public abstract class BaseViewModel extends AndroidViewModel
{

    public enum RepoName
    {
        NOTE
    }

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    protected <T> T getRepo(RepoName repoName , Class<T> type) throws ClassCastException
    {
        switch (repoName)
        {
            case NOTE:
                return type.cast(NoteRepository.getINSTANCE(getApplication()));
        }

        return null;
    }

}
