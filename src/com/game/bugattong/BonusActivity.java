package com.game.bugattong;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class BonusActivity extends Activity implements OnClickListener {

	// private SaveUtility saveinstance;
//	private final static char[] BONUSANSWER = { 'S', 'A', 'R', 'N', 'G', 'O',
//			'L', }; // "SARANGGOLA";
	
	private final static char[] BONUSANSWER = { 'L', 'O', 'D', 'S', 'A', 'G',
	'N','E','P','R' }; // "SARANGGOLA";
	private final static String BONUSQUESTION = "Buto’t balat na malapad, kay galing kung lumipad.";
	private TextView[] letters = new TextView[10];
	private ImageView[] letterHints = new ImageView[10];
	private TextView tvQuestion;
	private TextView[] hintedWords = new TextView[5];

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bonuslevel_layout);

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

		letterHints[0] = (ImageView) findViewById(R.id.hint_01); // L
		letterHints[1] = (ImageView) findViewById(R.id.hint_02); // O
		letterHints[2] = (ImageView) findViewById(R.id.hint_03); // D
		letterHints[3] = (ImageView) findViewById(R.id.hint_04); // S
		letterHints[4] = (ImageView) findViewById(R.id.hint_05); // A
		letterHints[5] = (ImageView) findViewById(R.id.hint_06); // G
		letterHints[6] = (ImageView) findViewById(R.id.hint_07); // N
		letterHints[7] = (ImageView) findViewById(R.id.hint_08); // E
		letterHints[8] = (ImageView) findViewById(R.id.hint_09); // P
		letterHints[9] = (ImageView) findViewById(R.id.hint_10); // R

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
}
