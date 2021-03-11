package com.example.triviaapp;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    private TextView textViewQuestion, textViewName;
    private RadioGroup rbGroup;
    private CheckBox rb1, rb2, rb3, rb4;
    private Button buttonConfirmNext;
    String checkedValue;
    String opt[] = {
            "Sachin Tendulkar", "Virat Kohali", "Adam GilChrist", "Jacque Kallis"
    };
    String name;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        textViewName = findViewById(R.id.tv_name);
        textViewQuestion = findViewById(R.id.text_view_question);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        rb4 = findViewById(R.id.radio_button4);
        buttonConfirmNext = findViewById(R.id.button_confirm_next);
        sharedPreferences = getSharedPreferences("Trivia_db", Context.MODE_PRIVATE);
        name = sharedPreferences.getString("NAME", " ");
        textViewName.setText("Hello," + name);

        textViewQuestion.setText(R.string.question1);

        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);

        if (name != null)
            checkBoxChecked();

        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(QuizActivity.this, MultiSelectQuiz.class);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("ANS1", checkedValue);
                editor.commit();
                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent1);
            }
        });

    }

    private void checkBoxChecked() {
        name = null;
        rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    checkedValue = compoundButton.getText().toString();
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                }
            }
        });

        rb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    checkedValue = compoundButton.getText().toString();
                    rb1.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                }
            }
        });

        rb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    checkedValue = compoundButton.getText().toString();
                    rb2.setChecked(false);
                    rb1.setChecked(false);
                    rb4.setChecked(false);
                }
            }
        });

        rb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    checkedValue = compoundButton.getText().toString();
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb1.setChecked(false);
                }
            }
        });
    }


}
