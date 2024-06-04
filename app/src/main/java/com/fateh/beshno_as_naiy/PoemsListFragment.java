package com.fateh.beshno_as_naiy;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class PoemsListFragment extends Fragment {

    private static final String TAG = "poemlist";
    ListView poemListView;
    ListViewAdapter listViewAdapter;
    ArrayList<PoemModel> poemsList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null){
            poemsList = bundle.getParcelableArrayList("poemsList");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_poems_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        poemListView = view.findViewById(R.id.list_poems);
        listViewAdapter = new ListViewAdapter(getContext(), poemsList);
        poemListView.setAdapter(listViewAdapter);

    }
}