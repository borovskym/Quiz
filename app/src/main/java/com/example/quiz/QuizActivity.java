package com.example.quiz;

import java.util.List;
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
    //TextView txtLevel;
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

        /*switch(qid){
            case 1: txtLevel.setText("1.000$"); break;
            case 2: txtLevel.setText("5.000$"); break;
            case 3: txtLevel.setText("10.000$"); break;
            case 4: txtLevel.setText("15.000$"); break;
            case 5: txtLevel.setText("20.000$"); break;
            case 6: txtLevel.setText("50.000$"); break;
            case 7: txtLevel.setText("100.000$"); break;
            case 8: txtLevel.setText("250.000$"); break;
            case 9: txtLevel.setText("500.000$"); break;
            case 10: txtLevel.setText("1.000.000$"); break;
        }*/
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
        Log.d("yourans", currentQ.getANSWER() + " " + answer.getText());
        if (currentQ.getANSWER().equals(answer.getText())) {
            score++;
            Log.d("score", "Your score" + score);
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

