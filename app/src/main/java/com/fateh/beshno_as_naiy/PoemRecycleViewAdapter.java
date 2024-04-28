package com.fateh.beshno_as_naiy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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
        View view = LayoutInflater.from(context).inflate(R.layout.poem_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PoemRecycleViewAdapter.ViewHolder holder, int position) {
        holder.poem_title.setText(poem_title_list.get(position));
        holder.listen_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "poem", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return poem_title_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView poem_title;
        ImageButton listen_btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            listen_btn = itemView.findViewById(R.id.listenButton);
            poem_title = itemView.findViewById(R.id.poem_title);
            poem_title.setText("");

        }
    }
}
