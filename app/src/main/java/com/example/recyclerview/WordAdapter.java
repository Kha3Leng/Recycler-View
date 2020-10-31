package com.example.recyclerview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {
    private List<String> stringList = new ArrayList<>();
    private LayoutInflater inflater;

    public WordAdapter(Context contxt, List<String> strList) {
        this.inflater = LayoutInflater.from(contxt);
        this.stringList = strList;
    }

    @NonNull
    @Override
    public WordAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewHolder = inflater.inflate(R.layout.one_listitem, parent, false);
        return new WordViewHolder(viewHolder, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordAdapter.WordViewHolder holder, int position) {
        String str = stringList.get(position);
        holder.mTextView.setText(str);
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView mTextView;
        final WordAdapter adapter;

        public WordViewHolder(View view, WordAdapter adapter){
            super(view);
            this.mTextView = view.findViewById(R.id.word);
            this.adapter = adapter;
            mTextView.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View v) {
            int str = getLayoutPosition();
            stringList.set(str, stringList.get(str)+" is clicked.");
            this.adapter.notifyDataSetChanged();
        }
    }
}
