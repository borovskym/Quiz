package com.example.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends Activity implements View.OnClickListener{
    private Random gen = new Random();
    private List<Question> quesList;
    private List<Question> generatedQ;
    private Question currentQ;
    private Bundle b = new Bundle();
    private ArrayList<String> wrongAnswers = new ArrayList<>();
    private ValueAnimator anim;

    private int score=0;
    private int qid = gen.nextInt(10-1)+1;
    private int lvl=1;
    private int qCounter=1;


    private TextView txtQuestion;
    private Button odpa, odpb, odpc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Database db = new Database(this);

        quesList = db.getAllQuestions();
        currentQ = quesList.get(qid);
        generatedQ = new ArrayList<>();

        txtQuestion = (TextView) findViewById(R.id.textView);
        odpa = (Button) findViewById(R.id.button);
        odpb = (Button) findViewById(R.id.button2);
        odpc = (Button) findViewById(R.id.button3);
        setQuestionView();

        odpa.setOnClickListener(this);
        odpb.setOnClickListener(this);
        odpc.setOnClickListener(this);

    }

    private void setQuestionView() {
        txtQuestion.setText(currentQ.getQUESTION());
        odpa.setText(currentQ.getOPTA());
        odpb.setText(currentQ.getOPTB());
        odpc.setText(currentQ.getOPTC());
    }

    @Override
    public void onClick(View v) {

        Button answer = (Button) findViewById(v.getId());
        checkAnswer(answer);
        checkLvl();

    }

    private void checkAnswer(Button answer) {
        if (currentQ.getANSWER().equals(answer.getText())) {
            startGoodAnswerAnimation(answer);
            score++;

        } else {
            startWrongAnswerAnimation(answer);
            wrongAnswers.add(currentQ.getQUESTION()+" Right answer is: "+currentQ.getANSWER());
        }
    }

    private void generateQuestion(){
        switch(lvl){
            case 1: qid = gen.nextInt(10-1)+1; currentQ = quesList.get(qid); setQuestionView(); break;
            case 2: qid = gen.nextInt(20-11)+11; currentQ = quesList.get(qid); setQuestionView(); break;
            case 3: qid = gen.nextInt(30-21)+21; currentQ = quesList.get(qid); setQuestionView(); break;
            case 4: qid = gen.nextInt(35-31)+31; currentQ = quesList.get(qid); setQuestionView(); break;
        }
    }

    private void checkLvl(){
        if(lvl<5){
            generateQuestion();

            while(generatedQ.contains(currentQ)){
                generateQuestion();
            }

            generatedQ.add(currentQ);
            ++qCounter;

            if(qCounter % 3 == 0 || qCounter == 10){
                ++lvl;
            }

        } else {
            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            b.putInt("score", score); //Score
            b.putStringArrayList("wrongAnswers",wrongAnswers); //Array with wrong answers
            intent.putExtras(b); //Score and wrong answers are sent to another intent
            startActivity(intent);
            finish();
        }
    }

    private void startWrongAnswerAnimation(final View v) {
        int colorStart = v.getSolidColor();
        int colorEnd = 0xFFFF0000;
        anim = ObjectAnimator.ofInt(v,"backgroundColor",colorStart,colorEnd);

        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation){
                anim.setDuration(500);
                anim.setEvaluator(new ArgbEvaluator());
                anim.setRepeatCount(1);
                anim.setRepeatMode(ValueAnimator.REVERSE);
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                v.setBackgroundColor(Color.WHITE);
            }
        });
        anim.start();
    }

    private void startGoodAnswerAnimation(final View v) {
        int colorStart = v.getSolidColor();
        int colorEnd = 0xFF99FF00;
        anim = ObjectAnimator.ofInt(v,"backgroundColor",colorStart,colorEnd);

        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation){
                anim.setDuration(500);
                anim.setEvaluator(new ArgbEvaluator());
                anim.setRepeatCount(1);
                anim.setRepeatMode(ValueAnimator.REVERSE);
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                v.setBackgroundColor(Color.WHITE);
            }
        });
        anim.start();
    }
}