package com.example.notetakingtask.noteList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notetakingtask.repository.model.NoteModel;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.ViewHolder>
{
    private Context mContext;
    private List<NoteModel> mNoteModelList;

    public NoteListAdapter(Context mContext, List<NoteModel> mNoteModelList)
    {
        this.mContext = mContext;
        this.mNoteModelList = mNoteModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
