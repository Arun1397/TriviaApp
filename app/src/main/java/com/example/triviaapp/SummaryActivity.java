package com.example.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class SummaryActivity extends AppCompatActivity {

    TextView userName, textViewQues1, textViewAns1, textViewQues2, textViewAns2;
    Button buttonFinish;
    SharedPreferences sharedPreferences;
    private String name,ans1, ans2,ques1, ques2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        userName = findViewById(R.id.tv_user_name);
        textViewQues1 = findViewById(R.id.tv_ques1);
        textViewAns1 = findViewById(R.id.tv_ans1);
        textViewQues2 = findViewById(R.id.tv_ques2);
        textViewAns2 = findViewById(R.id.tv_ans2);
        buttonFinish = findViewById(R.id.btn_finish);

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("dd-MMM-Y HH:mm a");
        date.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));

        String localTime = date.format(currentLocalTime);
        ques1 = "What are the colors in the Indian national flag? Select all:";

        sharedPreferences = getSharedPreferences("Trivia_db", Context.MODE_PRIVATE);
        name = sharedPreferences.getString("NAME", " ");
        ans1 = sharedPreferences.getString("ANS1", " ");
        ans2 = sharedPreferences.getString("ANS2", " ");

        userName.setText("Hello ,"+name);

        textViewQues1.setText(("Q1: ")+getString(R.string.question1));
        textViewQues2.setText("Q2: "+getString(R.string.question2));

        textViewAns1.setText("Answer: " + ans1);
        textViewAns2.setText("Answer: " + ans2);

        QuizDbHelper db = new QuizDbHelper(this);

        // Inserting Contacts
        db.addQuestion(new Question(name, localTime, getString(R.string.question1), ans1, getString(R.string.question2), ans2));

        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Intent intent1=new Intent(SummaryActivity.this,MainActivity.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent1);

                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}