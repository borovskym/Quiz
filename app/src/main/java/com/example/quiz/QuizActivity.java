package com.example.quiz;

import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends Activity implements View.OnClickListener{
    List<Question> quesList;
    int score=0;
    int qid=0;
    Question currentQ;
    TextView txtQuestion;
    Button odpa, odpb, odpc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Database db = new Database(this);
        quesList = db.getAllQuestions();
        currentQ = quesList.get(qid);
        txtQuestion = (TextView) findViewById(R.id.textView);
        odpa = (Button) findViewById(R.id.button);
        odpb = (Button) findViewById(R.id.button2);
        odpc = (Button) findViewById(R.id.button3);
        setQuestionView();

        odpa.setOnClickListener(this);
        odpb.setOnClickListener(this);
        odpc.setOnClickListener(this);
    }

    private void setQuestionView()
    {
        txtQuestion.setText(currentQ.getQUESTION());
        odpa.setText(currentQ.getOPTA());
        odpb.setText(currentQ.getOPTB());
        odpc.setText(currentQ.getOPTC());
        qid++;
    }

    @Override
    public void onClick(View v) {

        Button answer = (Button) findViewById(v.getId());
        //Log.d("yourans", currentQ.getANSWER() + " " + answer.getText());
        if (currentQ.getANSWER().equals(answer.getText())) {
            score++;
            //Log.d("score", "Your score" + score);
        }

        if (qid < 10) {
            currentQ = quesList.get(qid);
            setQuestionView();
        } else {
            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); //Your score
            intent.putExtras(b); //Put your score to your next Intent
            startActivity(intent);
            finish();
        }
    }
}

