package com.example.triviaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    private HistoryAdapter historyAdapter;
    private ArrayList<Question> questions = new ArrayList<>();
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        recyclerView=findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        QuizDbHelper db = new QuizDbHelper(this);

        List<Question> questionList = db.getAllQuestions();

        if (questionList.size() == 0) {
            Toast.makeText(this, "No data found!", Toast.LENGTH_SHORT).show();
        }else{
            for (Question cn : questionList) {
                questions.add(cn);
            }
            historyAdapter = new HistoryAdapter(questions, HistoryActivity.this);
            recyclerView.setAdapter(historyAdapter);
        }
    }
}