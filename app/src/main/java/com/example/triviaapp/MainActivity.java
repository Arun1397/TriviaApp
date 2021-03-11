package com.example.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonnxt, historyBtn;
    EditText editTextName;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonnxt = findViewById(R.id.btn_nxt1);
        editTextName = findViewById(R.id.et_name);
        historyBtn = findViewById(R.id.btn_history);


        buttonnxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextName.getText().toString().trim().matches(""))
                    Toast.makeText(MainActivity.this, "Please enter name ", Toast.LENGTH_SHORT).show();
                else
                    quiz();
            }
        });

        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, HistoryActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });


    }

    void quiz() {

        Intent intent = new Intent(this, QuizActivity.class);
        String name = editTextName.getText().toString();
        sp = getSharedPreferences("Trivia_db", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("NAME", name);
        editor.commit();
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }
}