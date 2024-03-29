package com.gowgos5.architecturecomponents;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    private List<Note> notes = new ArrayList<>();

    @NonNull
    @Override
    // This method is called right when the adapter is created and is used to initialise your ViewHolder(s).
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = View.inflate(parent.getContext(), R.layout.note_item, null);
        return new NoteHolder(itemView);
    }

    @Override
    // This method is called for each ViewHolder to bind it to the adapter. This is where we will pass our data to our ViewHolder.
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note currentNote = notes.get(position);
        holder.tvPriority.setText(String.valueOf(currentNote.getPriority()));
        holder.tvTitle.setText(currentNote.getTitle());
        holder.tvDesc.setText(currentNote.getDescription());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;

        // Not the most efficient way of updating the adapter. Used here for simplicity!
        notifyDataSetChanged();
    }

    // The ViewHolder pattern is a pattern that a developer can use to increase the speed at which
    // their ListView renders data. The reason for this improvement is that the number of times
    // which the findViewById method is invoked is drastically reduced; existing views do not have
    // to be garbage collected and new views do not have to be inflated.
    class NoteHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvDesc;
        private TextView tvPriority;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            this.tvTitle = itemView.findViewById(R.id.tv_title);
            this.tvDesc = itemView.findViewById(R.id.tv_description);
            this.tvPriority = itemView.findViewById(R.id.tv_priority);
        }
    }
}
