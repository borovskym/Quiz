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
    private String TAG = "RANDOM QUESTION";
    Random gen = new Random();
    List<Question> quesList;
    int score=0;
    int qid = gen.nextInt(2-1)+1;
    int lvl=1;
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
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG,"Question ID: "+qid);
        //Log.d(TAG,"Level: "+lvl);
        Button answer = (Button) findViewById(v.getId());

        if (currentQ.getANSWER().equals(answer.getText())) {
            score++;
        }

        if(lvl<6){
        switch(lvl){
            case 1: qid = gen.nextInt(10); currentQ = quesList.get(qid); setQuestionView(); Log.d(TAG, "lvl:"+lvl); break;
            case 2: qid = gen.nextInt(4-3)+3; currentQ = quesList.get(qid); setQuestionView(); Log.d(TAG, "lvl:"+lvl); break;
            case 3: qid = gen.nextInt(6-5)+5; currentQ = quesList.get(qid); setQuestionView(); Log.d(TAG, "lvl:"+lvl); break;
            case 4: qid = gen.nextInt(8-7)+8; currentQ = quesList.get(qid); setQuestionView(); Log.d(TAG, "lvl:"+lvl); break;
            case 5: qid = gen.nextInt(10-9)+9; currentQ = quesList.get(qid); setQuestionView(); Log.d(TAG, "lvl:"+lvl); break;
        }
        ++lvl;

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

