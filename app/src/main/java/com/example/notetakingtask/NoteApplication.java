package com.example.notetakingtask;

import android.app.Application;

public class NoteApplication extends Application {

    private static Application application;

    public static Application getInstance()
    {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }
}
