package com.example.notetakingtask;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.notetakingtask.repository.model.NoteModel;
import com.example.notetakingtask.repository.room.DatabaseClient;
import com.example.notetakingtask.repository.room.NoteDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AsyncProcess
{

    public interface PerformTask<V>
    {
        void onSuccess(boolean success, V data);
    }

    public enum AsyncTaskName
    {
        ADD_NOTE , GET_NOTE_LIST , GET_NOTE_DETAIL
    }

    public static synchronized void commonAsyncTaskPerformer(final AsyncTaskName asyncTaskName , final PerformTask performTask , final Object... inputArgs)
    {
        class PerformTask extends AsyncTask<Void , Void ,Object>
        {
            @Override
            protected Object doInBackground(Void... voids)
            {
                Map<String , Object> map = new HashMap<>();

                try
                {
                    return performNoteRelatedformTask(asyncTaskName , map , inputArgs);
                }catch (Exception e)
                {
                    e.printStackTrace();
                    map.put("ERROR" , "ERROR");
                    return map;
                }
            }

            @Override
            protected void onPostExecute(Object o)
            {
                super.onPostExecute(o);

                if(performTask != null)
                {
                    Map<String, Object> map = (Map<String, Object>) o;

                    if(map == null){
                        performTask.onSuccess(false , null);
                    }else if(map.containsKey("ERROR")){
                        performTask.onSuccess(false , null);
                    }else {
                        performTask.onSuccess(false , null);
                    }
                }

            }
        }

        PerformTask perTask = new PerformTask();
        perTask.execute();
    }


    private static Map<String , Object> performNoteRelatedformTask(AsyncTaskName asyncTaskName , Map<String , Object> map, final Object... inputArgs)
    {
        Context context = NoteApplication.getInstance();
        NoteDao noteDao = DatabaseClient.getInstance(context).getNoteDao();

        switch (asyncTaskName)
        {
            case ADD_NOTE:
                noteDao.insertNoteModel((NoteModel) inputArgs[0]);
                break;
        }

        map.put("ERROR" , "ERROR");
        return map;
    }

}
