package com.example.quiz;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends Activity {
	Button back;
	ListView list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		//get text view
		TextView t=(TextView)findViewById(R.id.textResult);
		list = (ListView) findViewById(R.id.listView);

		//get score
		Bundle b = getIntent().getExtras();
		int score= b.getInt("score");
		ArrayList<String> wrongAnswers = b.getStringArrayList("wrongAnswers");

		//display score
		switch (score)
		{
			//lvl 1
			case 0: t.setText("0/10 Well, atleast you tried."); break;
			case 1: t.setText("1/10 You have to study more. You won 1.000$!"); break;
			case 2: t.setText("2/10 It's something. You won 5.000$!"); break;
			case 3: t.setText("3/10 Hmm better. You won 10.000$!"); break;
			//lvl 2
			case 4:t.setText("4/10 Nice! You won 50.000$!"); break;
			case 5:t.setText("5/10 Woah man, you know stuff. You won 100.000$!"); break;
			case 6: t.setText("6/10 Nice job! You won 250.000$!"); break;
			//lvl 3
			case 7: t.setText("7/10 You are an IT guy man! You won 500.000$!"); break;
			case 8: t.setText("8/10 Well played! You won 1.000.000$!!"); break;
			case 9:t.setText("9/10 Easy peasy right? You won 2.000.000$!!"); break;
			//final lvl
			case 10:t.setText("10/10 GODLIKE!!! You beat us :)"); break;
		}

		//display wrong answers
		ArrayAdapter adapter = new ArrayAdapter<String>(ResultActivity.this, R.layout.wrong_answers_row, wrongAnswers);
		list.setAdapter(adapter);

		back = (Button) findViewById(R.id.b_back);
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), MainActivity.class);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.putExtra("EXIT", true);
				startActivity(i);
			}
		});
	}
}
