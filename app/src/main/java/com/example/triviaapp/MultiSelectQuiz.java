package com.example.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MultiSelectQuiz extends AppCompatActivity {


    private CheckBox chkBtn5, chkBtn6, chkBtn7, chkBtn8;
    private Button nextBtn;
    private TextView questionText2;
    private String checkedAns = "";
    private SharedPreferences sharedPreferences;
    String opt[] = {
            "White", "Yellow", "Green", "Orange",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_select_quiz);

        chkBtn5 = findViewById(R.id.chk_btn_5);
        chkBtn6 = findViewById(R.id.chk_btn_6);
        chkBtn7 = findViewById(R.id.chk_btn_7);
        chkBtn8 = findViewById(R.id.chk_btn_8);
        nextBtn = findViewById(R.id.button_confirm_next2);
        questionText2 = findViewById(R.id.text_view_question2);

        questionText2.setText(R.string.question2);

        chkBtn5.setText(opt[0]);
        chkBtn6.setText(opt[1]);
        chkBtn7.setText(opt[2]);
        chkBtn8.setText(opt[3]);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCheckedAns();

                sharedPreferences = getSharedPreferences("Trivia_db", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("ANS2", checkedAns);
                editor.commit();
                Intent intent=new Intent(MultiSelectQuiz.this, SummaryActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void getCheckedAns() {
        if(chkBtn5.isChecked()){
            checkedAns = opt[0];
        }
        if(chkBtn6.isChecked()){
            checkedAns += " ," +opt[1];
        }
        if(chkBtn7.isChecked()){
            checkedAns +=  " ," +opt[2];
        }
        if(chkBtn8.isChecked()){
            checkedAns += " ," +opt[3];
        }
    }
}