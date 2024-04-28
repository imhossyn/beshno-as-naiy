package com.fateh.beshno_as_naiy;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PoemsViewListFragment extends Fragment {

    RecyclerView poemsRecycleView;
    PoemRecycleViewAdapter recycleViewAdapter;
    ArrayList<String> list_test = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_poems_view_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        poemsRecycleView = view.findViewById(R.id.poem_recycle_view);

        list_test.add("بشنو از نی چون حکایت میکند.");
        list_test.add("بشنو از نی چون حکایت میکند.");
        list_test.add("بشنو از نی چون حکایت میکند. بشنو از نی چون حکایت میکند");
        list_test.add("بشنو از نی چون حکایت میکند.");
        recycleViewAdapter = new PoemRecycleViewAdapter(getContext(), list_test);
        poemsRecycleView.setAdapter(recycleViewAdapter);
        poemsRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));

    }
}