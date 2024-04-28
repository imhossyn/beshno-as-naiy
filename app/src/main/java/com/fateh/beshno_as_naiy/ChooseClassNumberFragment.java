package com.fateh.beshno_as_naiy;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ChooseClassNumberFragment extends Fragment {

    RadioGroup class_number_RG;
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
        class_number_RG = view.findViewById(R.id.ClassNumbers);
        insert_btn = view.findViewById(R.id.enter_btn);


        insert_btn.setOnClickListener(new View.OnClickListener() {
            int class_selected = 0;

            @Override
            public void onClick(View v) {
                class_selected = class_number_RG.getCheckedRadioButtonId();
                if (class_selected == -1) {
                    Toast.makeText(getContext(), "لطفا یکی از گزینه ها را انتخاب کنید!", Toast.LENGTH_SHORT).show();
                } else {
                    class_selected_RB = view.findViewById(class_selected);
//                    Toast.makeText(getContext(), class_selected_RB.getText(), Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(v).navigate(R.id.action_chooseClassNumberFragment_to_poemsViewList);
                }
            }
        });
    }
}