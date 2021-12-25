package com.example.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView ques, optionA, optionB, optionC, optionD, selectedOption, correctAns, score, questionNo;
    int quesNo = 1;
    int quesIdx = 0, mScore = 0;
    ProgressBar progressBar;
    int currentQues, currentOptionA, currentOptionB, currentOptionC, currentOptionD;
    private final QuestionAnswers[] questionAnswers = new QuestionAnswers[]{
            new QuestionAnswers(R.string.ques1, R.string.ques1_a, R.string.ques1_b, R.string.ques1_c, R.string.ques1_d, R.string.ques1_ans),
            new QuestionAnswers(R.string.ques2, R.string.ques2_a, R.string.ques2_b, R.string.ques2_c, R.string.ques2_d, R.string.ques2_ans),
            new QuestionAnswers(R.string.ques3, R.string.ques3_a, R.string.ques3_b, R.string.ques3_c, R.string.ques3_d, R.string.ques3_ans),
            new QuestionAnswers(R.string.ques4, R.string.ques4_a, R.string.ques4_b, R.string.ques4_c, R.string.ques4_d, R.string.ques4_ans)
    };
    final int PROGRESS_BAR = (int) Math.ceil(100/questionAnswers.length);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ques = findViewById(R.id.question);
        optionA = findViewById(R.id.optionA);
        optionB = findViewById(R.id.optionB);
        optionC = findViewById(R.id.optionC);
        optionD = findViewById(R.id.optionD);
        selectedOption = findViewById(R.id.selectedOption);
        correctAns = findViewById(R.id.correctAns);
        score = findViewById(R.id.score);
        progressBar = findViewById(R.id.progress);
        questionNo = findViewById(R.id.questionNo);
        currentQues = questionAnswers[quesIdx].getQues();
        currentOptionA = questionAnswers[quesIdx].getOptionA();
        currentOptionB = questionAnswers[quesIdx].getOptionB();
        currentOptionC = questionAnswers[quesIdx].getOptionC();
        currentOptionD = questionAnswers[quesIdx].getOptionD();
        ques.setText(currentQues);
        optionA.setText(currentOptionA);
        optionB.setText(currentOptionB);
        optionC.setText(currentOptionC);
        optionD.setText(currentOptionD);
    }

    public void optionA(View view) {
        checkAns(currentOptionA);
        updateQuestion();
    }

    public void optionB(View view) {
        checkAns(currentOptionB);
        updateQuestion();
    }

    public void optionC(View view) {
        checkAns(currentOptionC);
        updateQuestion();
    }

    public void optionD(View view) {
        checkAns(currentOptionD);
        updateQuestion();
    }

    private void checkAns(int option) {
        int correct = questionAnswers[quesIdx].getAns();
        selectedOption.setText(option);
        correctAns.setText(correct);
        String m = selectedOption.getText().toString().trim();
        String n = correctAns.getText().toString().trim();
        if(m.equals(n)) {
            Toast.makeText(getApplicationContext(), "Right", Toast.LENGTH_SHORT).show();
            mScore++;
        }else {
            Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateQuestion() {
        quesIdx = (quesIdx + 1) % questionAnswers.length;
        if (quesIdx == 0) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle("Game over");
            alertDialog.setCancelable(false);
            alertDialog.setPositiveButton("Close Application", (dialogInterface, i) -> finish());
            alertDialog.setNegativeButton("No", (dialogInterface, i) -> {
                mScore = 0;
                quesNo = 1;
                progressBar.setProgress(0);
                questionNo.setText(quesNo + "/" + questionAnswers.length + " Questions");
                score.setText("Score " + mScore + "/" + questionAnswers.length);
            });
            alertDialog.show();
        }
        currentQues = questionAnswers[quesIdx].getQues();
        currentOptionA = questionAnswers[quesIdx].getOptionA();
        currentOptionB = questionAnswers[quesIdx].getOptionB();
        currentOptionC = questionAnswers[quesIdx].getOptionC();
        currentOptionD = questionAnswers[quesIdx].getOptionD();
        ques.setText(currentQues);
        optionA.setText(currentOptionA);
        optionB.setText(currentOptionB);
        optionC.setText(currentOptionC);
        optionD.setText(currentOptionD);
        quesNo++;
        if(quesNo <= questionAnswers.length) {
            questionNo.setText(quesNo + "/" + questionAnswers.length + " Questions");
        }
        score.setText("Score " + mScore + "/" + questionAnswers.length);
        progressBar.incrementProgressBy(PROGRESS_BAR);
    }
}