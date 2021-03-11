package com.example.triviaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class QuizDbHelper  extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TriviaApps";
    private static final String TABLE_NAME = "quiz_questions";
    private static final String KEY_ID = "_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DATEANDTIME = "dateandtime";
    private static final String KEY_QUESTION1 = "ques1";
    private static final String KEY_ANSWER1 = "ans1";
    private static final String KEY_QUESTION2 = "ques2";
    private static final String KEY_ANSWER2 = "ans2";


    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_QUESTIONS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_DATEANDTIME + " TEXT," +  KEY_QUESTION1 + " TEXT," +  KEY_ANSWER1 + " TEXT," +  KEY_QUESTION2 + " TEXT," +  KEY_ANSWER2 + " TEXT" + ")";
        db.execSQL(CREATE_QUESTIONS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // code to add the new contact
    void addQuestion(Question question) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, question.getName());
        values.put(KEY_DATEANDTIME, question.getDateandtime());
        values.put(KEY_QUESTION1, question.getQues1());
        values.put(KEY_ANSWER1, question.getAns1());
        values.put(KEY_QUESTION2, question.getQues2());
        values.put(KEY_ANSWER2, question.getAns2());


        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<Question>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.set_id(Integer.parseInt(cursor.getString(0)));
                question.setName(cursor.getString(1));
                question.setDateandtime(cursor.getString(2));
                question.setQues1(cursor.getString(3));
                question.setAns1(cursor.getString(4));
                question.setQues2(cursor.getString(5));
                question.setAns2(cursor.getString(6));
                questionList.add(question);
            } while (cursor.moveToNext());
        }

        return questionList;
    }

}