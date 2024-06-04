package com.fateh.beshno_as_naiy;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class ChooseClassNumberFragment extends Fragment {

    ArrayList<PoemModel> all_data;
    RadioGroup level_select_RG;
    RadioButton class_selected_RB;
    Button insert_btn;
    TextView title_txt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_class_number, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title_txt = view.findViewById(R.id.TitleTxt);
        level_select_RG = view.findViewById(R.id.ClassNumbers);
        insert_btn = view.findViewById(R.id.enter_btn);

        insert_btn.setOnClickListener(new View.OnClickListener() {
            int level_selected_id = 0;

            @Override
            public void onClick(View v) {
                level_selected_id = level_select_RG.getCheckedRadioButtonId();
                if (level_selected_id == -1) {
                    Toast.makeText(getContext(), "لطفا یکی از گزینه ها را انتخاب کنید!", Toast.LENGTH_SHORT).show();
                } else {
                    class_selected_RB = view.findViewById(level_selected_id);
                    Toast.makeText(getContext(), class_selected_RB.getText(), Toast.LENGTH_SHORT).show();
                    ArrayList<PoemModel> tmpPoemList = getPoems((String) class_selected_RB.getText());
                    Log.d("poemsList generated", String.valueOf(tmpPoemList.size()));
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("poemsList", tmpPoemList);
                    Navigation.findNavController(v).navigate(R.id.action_chooseClassNumberFragment_to_poemsViewList, bundle);
                }
            }
        });
    }

    private ArrayList<PoemModel> getPoems(String level) {
        ArrayList<PoemModel> tmpPoemList = new ArrayList<>();
        int tmpLevel = 0;
        switch (level) {
            case "پایه هفتم":
                tmpLevel = 7;
                break;
            case "پایه هشتم":
                tmpLevel = 8;
                break;
            case "پایه نهم":
                tmpLevel = 9;
                break;
        }
        try {
            MyDBHelper myDBHelper = new MyDBHelper(getContext());
            ArrayList<PoemModel> poemList = myDBHelper.getAllData();
            for (PoemModel poem : poemList) {
                if (poem.getLevel() == tmpLevel) {
                    tmpPoemList.add(poem);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("Chossing level poems", String.valueOf(tmpPoemList.size()));
        return tmpPoemList;
    }
}