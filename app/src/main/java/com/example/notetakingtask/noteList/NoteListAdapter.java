package com.example.notetakingtask.noteList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notetakingtask.R;
import com.example.notetakingtask.repository.model.NoteModel;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.ViewHolder>
{
    private Context mContext;
    private List<NoteModel> mNoteModelList;
    View transitionView;

    View getTransitionView() {
        return transitionView;
    }

    NoteListAdapter(Context mContext, List<NoteModel> mNoteModelList)
    {
        this.mContext = mContext;
        this.mNoteModelList = mNoteModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_note_list , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position)
    {
        holder.tv_title.setText(mNoteModelList.get(position).getTitle());
        holder.tv_content.setText(mNoteModelList.get(position).getContent());
        holder.tv_timestamp.setText(mNoteModelList.get(position).getTimestamp());

        holder.ll_parent.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                transitionView = holder.tv_title;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNoteModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv_title , tv_content , tv_timestamp;
        LinearLayout ll_parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_title);
            tv_content = itemView.findViewById(R.id.tv_content);
            tv_timestamp = itemView.findViewById(R.id.tv_timestamp);
            ll_parent = itemView.findViewById(R.id.ll_parent);

        }
    }

}
