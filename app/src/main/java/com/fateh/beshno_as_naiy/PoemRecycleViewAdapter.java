package com.fateh.beshno_as_naiy;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PoemRecycleViewAdapter extends RecyclerView.Adapter<PoemRecycleViewAdapter.ViewHolder> {

    Context context;
    ArrayList<String> poem_title_list;

    public PoemRecycleViewAdapter(Context context, ArrayList<String> poem_title_list) {

        this.context = context;
        this.poem_title_list = poem_title_list;
    }

    @NonNull
    @Override
    public PoemRecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PoemRecycleViewAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView poem_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            poem_title = itemView.findViewById(R.id.poem_title);
            poem_title.setText("");

        }
    }
}
