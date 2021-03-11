package com.example.triviaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private ArrayList<Question> questions;
    private Context context;
    Date b_date_and_time;

    public HistoryAdapter(ArrayList<Question> questions, Context context) {
        this.context = context;
        this.questions = questions;
    }

    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_recycle_view, parent, false);
        return new HistoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, int position) {

        int uid = questions.get(position).get_id();
        String name = questions.get(position).getName();
        String dateandtime = questions.get(position).getDateandtime();
        String ques1 = questions.get(position).getQues1();
        String ans1 = questions.get(position).getAns1();
        String ques2 = questions.get(position).getQues2();
        String ans2 = questions.get(position).getAns2();


        holder.textviewName.setText("Name :"+name);
        holder.textViewid.setText("GAME"+uid+":"+dateandtime);
        holder.textViewQues1.setText(ques1);
        holder.textViewAns1.setText("Answer :"+ans1);
        holder.textViewQues2.setText(ques2);
        holder.textViewAns2.setText("Answer :"+ans2);

    }

    @Override
    public int getItemCount() {

        return questions.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textviewName,textViewid,textViewQues1,textViewQues2,textViewAns1,textViewAns2;


        public ViewHolder(View view) {
            super(view);
            textviewName = (TextView) view.findViewById(R.id.recycleview_name);
            textViewid = (TextView) view.findViewById(R.id.recycleview_id);
            textViewQues1 = (TextView) view.findViewById(R.id.recycleview_ques1);
            textViewAns1 = (TextView) view.findViewById(R.id.recycleview_ans1);
            textViewQues2 = (TextView) view.findViewById(R.id.recycleview_ques2);
            textViewAns2 = (TextView) view.findViewById(R.id.recycleview_ans2);



        }
    }
}
