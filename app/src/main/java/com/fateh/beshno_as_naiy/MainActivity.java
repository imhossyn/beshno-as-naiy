package com.fateh.beshno_as_naiy;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup class_number_RG;
    RadioButton class_selected_RB;
    Button insert_btn;
    TextView title_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        title_txt = findViewById(R.id.TitleTxt);
        class_number_RG = findViewById(R.id.ClassNumbers);
        insert_btn = findViewById(R.id.enter_btn);


        insert_btn.setOnClickListener(new View.OnClickListener() {
            int class_selected = 0;

            @Override
            public void onClick(View v) {
                class_selected = class_number_RG.getCheckedRadioButtonId();
                if (class_selected == -1) {
                    Toast.makeText(MainActivity.this, "لطفا یکی از گزینه ها را انتخاب کنید!", Toast.LENGTH_SHORT).show();
                } else {
                    class_selected_RB = (RadioButton) findViewById(class_selected);
                    Toast.makeText(MainActivity.this, class_selected_RB.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}