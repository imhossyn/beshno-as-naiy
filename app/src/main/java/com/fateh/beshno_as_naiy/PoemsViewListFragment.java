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
import android.widget.ListView;

import java.util.ArrayList;

public class PoemsViewListFragment extends Fragment {

    ListView poemListView;
    PoemListViewAdapter poemListViewAdapter;
    ArrayList<PoemModel>list_test;

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

        poemListView = view.findViewById(R.id.list_poems);

        list_test = new ArrayList<PoemModel>();
        list_test.add(new PoemModel("بشنو از نی چون حکایت می کند."));
        list_test.add(new PoemModel("بشنو از نی چون حکایت می کند."));
        list_test.add(new PoemModel("بشنو از نی چون حکایت می کند."));
        list_test.add(new PoemModel("بشنو از نی چون حکایت می کند."));
        list_test.add(new PoemModel("بشنو از نی چون حکایت می کند."));
        list_test.add(new PoemModel("بشنو از نی چون حکایت می کند."));
        list_test.add(new PoemModel("بشنو از نی چون حکایت می کند."));
        list_test.add(new PoemModel("بشنو از نی چون حکایت می کند."));
        list_test.add(new PoemModel("بشنو از نی چون حکایت می کند."));
        list_test.add(new PoemModel("بشنو از نی چون حکایت می کند."));
        list_test.add(new PoemModel("بشنو از نی چون حکایت می کند."));
        list_test.add(new PoemModel("بشنو از نی چون حکایت می کند."));
        list_test.add(new PoemModel("بشنو از نی چون حکایت می کند."));
        list_test.add(new PoemModel("بشنو از نی چون حکایت می کند."));
        list_test.add(new PoemModel("بشنو از نی چون حکایت می کند."));
        list_test.add(new PoemModel("بشنو از نی چون حکایت می کند."));
        list_test.add(new PoemModel("بشنو از نی چون حکایت می کند."));
        list_test.add(new PoemModel("بشنو از نی چون حکایت می کند."));


        poemListViewAdapter = new PoemListViewAdapter(getContext(), list_test);
        poemListView.setAdapter(poemListViewAdapter);

    }
}