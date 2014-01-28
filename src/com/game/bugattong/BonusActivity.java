package com.game.bugattong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView;
import android.widget.Toast;

import com.game.bugattong.settings.GameSettings;

public class BonusActivity extends Activity implements OnClickListener {

	// private SaveUtility saveinstance;
//	private final static char[] BONUSANSWER = { 'S', 'A', 'R', 'N', 'G', 'O',
//			'L', }; // "SARANGGOLA";
	
	private final static char[] BONUSANSWER = { 'L', 'O', 'D', 'S', 'A', 'G',
	'N','E','P','R' }; // "SARANGGOLA";
	private final static String BONUSQUESTION = "Buto’t balat na malapad, kay galing kung lumipad.";
	private TextView[] letters = new TextView[10];
	private TextView[] letterHints = new TextView[10];
	private TextView tvQuestion;
	private TextView[] hintedWords = new TextView[5];
	private TextView txtMysteryongBagay;
	
	private ImageView imgItem;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bonuslevel_layout);
		
		imgItem = (ImageView) findViewById(R.id.bonus_item_saranggola);

		tvQuestion = (TextView) findViewById(R.id.question);
		letters[0] = (TextView) findViewById(R.id.answer_01);
		letters[1] = (TextView) findViewById(R.id.answer_02);
		letters[2] = (TextView) findViewById(R.id.answer_03);
		letters[3] = (TextView) findViewById(R.id.answer_04);
		letters[4] = (TextView) findViewById(R.id.answer_05);
		letters[5] = (TextView) findViewById(R.id.answer_06);
		letters[6] = (TextView) findViewById(R.id.answer_07);
		letters[7] = (TextView) findViewById(R.id.answer_08);
		letters[8] = (TextView) findViewById(R.id.answer_09);
		letters[9] = (TextView) findViewById(R.id.answer_10);
		txtMysteryongBagay = (TextView) findViewById(R.id.word_0);

		letterHints[0] = (TextView) findViewById(R.id.hint_01); // L
		letterHints[1] = (TextView) findViewById(R.id.hint_02); // O
		letterHints[2] = (TextView) findViewById(R.id.hint_03); // D
		letterHints[3] = (TextView) findViewById(R.id.hint_04); // S
		letterHints[4] = (TextView) findViewById(R.id.hint_05); // A
		letterHints[5] = (TextView) findViewById(R.id.hint_06); // G
		letterHints[6] = (TextView) findViewById(R.id.hint_07); // N
		letterHints[7] = (TextView) findViewById(R.id.hint_08); // E
		letterHints[8] = (TextView) findViewById(R.id.hint_09); // P
		letterHints[9] = (TextView) findViewById(R.id.hint_10); // R

		hintedWords[0] = (TextView) findViewById(R.id.hintword_1);
		hintedWords[1] = (TextView) findViewById(R.id.hintword_2);
		hintedWords[2] = (TextView) findViewById(R.id.hintword_3);
		hintedWords[3] = (TextView) findViewById(R.id.hintword_4);
		hintedWords[4] = (TextView) findViewById(R.id.hintword_5);

		hintedWords[0].setText("WALIS-TINGTING");
		hintedWords[1].setText("PISI");
		hintedWords[2].setText("DYARYO");
		hintedWords[3].setText("LAPIS");
		hintedWords[4].setText("GUNTING");
		
		
		GameSettings.CustomTextView(BonusActivity.this, tvQuestion);
		GameSettings.CustomTextView(BonusActivity.this, txtMysteryongBagay);
		
		int hintCounter = 0;
		while(hintCounter < 5){
			GameSettings.CustomTextView(BonusActivity.this, hintedWords[hintCounter]);
		 hintCounter ++;
		}
		
		
		letters[0].setOnClickListener(this);
		letters[1].setOnClickListener(this);
		letters[2].setOnClickListener(this);
		letters[3].setOnClickListener(this);
		letters[4].setOnClickListener(this);
		letters[5].setOnClickListener(this);
		letters[6].setOnClickListener(this);
		letters[7].setOnClickListener(this);
		letters[8].setOnClickListener(this);
		letters[9].setOnClickListener(this);

		letterHints[0].setOnClickListener(this);
		letterHints[1].setOnClickListener(this);
		letterHints[2].setOnClickListener(this);
		letterHints[3].setOnClickListener(this);
		letterHints[4].setOnClickListener(this);
		letterHints[5].setOnClickListener(this);
		letterHints[6].setOnClickListener(this);
		letterHints[7].setOnClickListener(this);
		letterHints[8].setOnClickListener(this);
		letterHints[9].setOnClickListener(this);
		tvQuestion.setText(BONUSQUESTION);
	}

	// { 'S', 'A', 'R', 'N', 'G', 'O','L'};
	// SARANGGOLA
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.hint_01:
			setLetter(BONUSANSWER[0]);
			break;
		case R.id.hint_02:
			setLetter(BONUSANSWER[1]);
			break;
		case R.id.hint_03:				//
			setLetter(BONUSANSWER[2]);
			break;
		case R.id.hint_04:
			setLetter(BONUSANSWER[3]);
			break;
		case R.id.hint_05:
			setLetter(BONUSANSWER[4]);
			break;
		case R.id.hint_06:
			setLetter(BONUSANSWER[5]);
			break;
		case R.id.hint_07:
			setLetter(BONUSANSWER[6]);
			break;
		case R.id.hint_08:			//
			setLetter(BONUSANSWER[7]);
			break;
		case R.id.hint_09:			//
			setLetter(BONUSANSWER[8]);
			break;
		case R.id.hint_10:
			setLetter(BONUSANSWER[9]);
			break;

		case R.id.answer_01:
			removeLetter(0);
			break;
		case R.id.answer_02:
			removeLetter(1);
			break;
		case R.id.answer_03:
			removeLetter(2);
			break;
		case R.id.answer_04:
			removeLetter(3);
			break;
		case R.id.answer_05:
			removeLetter(4);
			break;
		case R.id.answer_06:
			removeLetter(5);
			break;
		case R.id.answer_07:
			removeLetter(6);
			break;
		case R.id.answer_08:
			removeLetter(7);
			break;
		case R.id.answer_09:
			removeLetter(8);
			break;
		case R.id.answer_10:
			removeLetter(9);
			break;
		}

		if (!GameSettings.hasAnsweredBonus)
			if (checkAnswer()) {
				Toast.makeText(getApplicationContext(),"You have answered the bonus question.",Toast.LENGTH_SHORT).show();
				startActivityIntent();
				imgItem.setBackgroundResource(R.drawable.saranggola);
				GameSettings.hasAnsweredBonus = true;
			}
	}

	private boolean checkAnswer() {
		if (letters[0].getText().toString().equals("S")
				&& letters[1].getText().toString().equals("A")
				&& letters[2].getText().toString().equals("R")
				&& letters[3].getText().toString().equals("A")
				&& letters[4].getText().toString().equals("N")
				&& letters[5].getText().toString().equals("G")
				&& letters[6].getText().toString().equals("G")
				&& letters[7].getText().toString().equals("O")
				&& letters[8].getText().toString().equals("L")
				&& letters[9].getText().toString().equals("A"))
			return true;
		return false;
	}

	private boolean[] hasLetter = new boolean[10];

	public void setLetter(char hintLetter) {

		for (int index = 0; index < 10; index++) {
			if (!hasLetter[index]) {
				hasLetter[index] = true;
				letters[index].setText(hintLetter + "");
				break;

			}
		}
	}

	public void removeLetter(int index) {

		hasLetter[index] = false;
		letters[index].setText(" ");

	}
	
	
	private void startActivityIntent(){
		
		CountDownTimer timer = new CountDownTimer(3000,1000) {
			@Override
			public void onTick(long millisUntilFinished) {
			}
			@Override
			public void onFinish() {
				Intent intent = new Intent(BonusActivity.this, StoryView.class);
				intent.putExtra("getNextPage", "wakas");
				startActivity(intent);
				finish();				
			}
		}.start();
		
	}
}
