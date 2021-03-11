package com.example.triviaapp;

public class Question {
    private int _id;
    private String name;
    private String dateandtime;
    private String ques1;
    private String ans1;
    private String ques2;
    private String ans2;


    public Question(){}

    public Question(String name, String dateandtime, String ques1, String ans1, String ques2, String ans2) {
        this.name = name;
        this.dateandtime = dateandtime;
        this.ques1 = ques1;
        this.ans1 = ans1;
        this.ques2 = ques2;
        this.ans2 = ans2;
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateandtime() {
        return dateandtime;
    }

    public void setDateandtime(String dateandtime) {
        this.dateandtime = dateandtime;
    }

    public String getQues1() {
        return ques1;
    }

    public void setQues1(String ques1) {
        this.ques1 = ques1;
    }

    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getQues2() {
        return ques2;
    }

    public void setQues2(String ques2) {
        this.ques2 = ques2;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }
}