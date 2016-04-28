package com.example.quiz;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
public class ResultActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		//get text view
		TextView t=(TextView)findViewById(R.id.textResult);
		//get score
		Bundle b = getIntent().getExtras();
		int score= b.getInt("score");
		//display score

		switch (score)
		{
			case 0: t.setText("0/10 What have you done?!"); break;
			case 1: t.setText("1/10 Ehh..."); break;
			case 2: t.setText("2/10 Not good..."); break;
			case 3: t.setText("3/10 Hmm better."); break;
			case 4:t.setText("4/10 Nice!"); break;
			case 5:t.setText("5/10 You are the best!"); break;
			case 6: t.setText("6/10 Ehh..."); break;
			case 7: t.setText("7/10 Not good..."); break;
			case 8: t.setText("8/10 Hmm better."); break;
			case 9:t.setText("9/10 Nice!"); break;
			case 10:t.setText("10/10 You are the best!"); break;
		}
	}
}
