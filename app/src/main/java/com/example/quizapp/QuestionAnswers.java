package com.example.quizapp;

public class QuestionAnswers {

    private int ques, optionA, optionB, optionC, optionD, ans;

    public QuestionAnswers(int ques1, int ques1_a, int ques1_b, int ques1_c, int ques1_d, int ques1_ans) {
        ques = ques1;
        optionA = ques1_a;
        optionB = ques1_b;
        optionC = ques1_c;
        optionD = ques1_d;
        ans = ques1_ans;
    }

    public int getQues() {
        return ques;
    }

    public int getOptionA() {
        return optionA;
    }

    public int getOptionB() {
        return optionB;
    }

    public int getOptionC() {
        return optionC;
    }

    public int getOptionD() {
        return optionD;
    }

    public int getAns() {
        return ans;
    }
}
