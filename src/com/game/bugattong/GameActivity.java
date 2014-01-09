package com.game.bugattong;

/*
 *	01072014 added MAXANSWERTOUNLOCK
 */

import java.util.StringTokenizer;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.game.bugattong.pregame.MainScreen;
import com.game.bugattong.settings.Constants;
import com.game.bugattong.settings.GameSettings;

public class GameActivity extends Activity implements OnClickListener,
		OnTouchListener {

	private LinearLayout questionsmenu;
	private RelativeLayout gameArea;
	private Button btnqstnumber, btnhint, btnPause;
	private TextView tvquestion, tvpoints, tvanswer;
	private Button[] btnquestions = new Button[Constants.MAXQUESTIONS];
	private ImageView[] ivImages = new ImageView[Constants.MAXQUESTIONS];
	private int shownHints = 0;

	private Dialog gameMenuDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gamescreen);
		init();
		initImages();
	}

	private void init() {

		gameArea = (RelativeLayout) findViewById(R.id.gamearea);
		questionsmenu = (LinearLayout) findViewById(R.id.questionmenu);
		btnqstnumber = (Button) findViewById(R.id.btnqstnumber);
		btnhint = (Button) findViewById(R.id.btnhint);
		btnPause = (Button) findViewById(R.id.game_screen_btn_pause);
		tvquestion = (TextView) findViewById(R.id.tvquestion);
		tvpoints = (TextView) findViewById(R.id.tvpoints);
		tvanswer = (TextView) findViewById(R.id.tvanswer);
		btnquestions[0] = (Button) findViewById(R.id.btnquestion1_1);
		btnquestions[1] = (Button) findViewById(R.id.btnquestion1_2);
		btnquestions[2] = (Button) findViewById(R.id.btnquestion1_3);
		btnquestions[3] = (Button) findViewById(R.id.btnquestion1_4);
		btnquestions[4] = (Button) findViewById(R.id.btnquestion1_5);
		btnquestions[5] = (Button) findViewById(R.id.btnquestion2_1);
		btnquestions[6] = (Button) findViewById(R.id.btnquestion2_2);
		btnquestions[7] = (Button) findViewById(R.id.btnquestion2_3);
		btnquestions[8] = (Button) findViewById(R.id.btnquestion2_4);
		btnquestions[9] = (Button) findViewById(R.id.btnquestion2_5);
		btnquestions[10] = (Button) findViewById(R.id.btnquestion3_1);
		btnquestions[11] = (Button) findViewById(R.id.btnquestion3_2);
		btnquestions[12] = (Button) findViewById(R.id.btnquestion3_3);
		btnquestions[13] = (Button) findViewById(R.id.btnquestion3_4);
		btnquestions[14] = (Button) findViewById(R.id.btnquestion3_5);

		btnqstnumber.setOnClickListener(this);
		btnhint.setOnClickListener(this);
		btnPause.setOnClickListener(this);
		btnquestions[0].setOnClickListener(this);
		btnquestions[1].setOnClickListener(this);
		btnquestions[2].setOnClickListener(this);
		btnquestions[3].setOnClickListener(this);
		btnquestions[4].setOnClickListener(this);
		btnquestions[5].setOnClickListener(this);
		btnquestions[6].setOnClickListener(this);
		btnquestions[7].setOnClickListener(this);
		btnquestions[8].setOnClickListener(this);
		btnquestions[9].setOnClickListener(this);
		btnquestions[10].setOnClickListener(this);
		btnquestions[11].setOnClickListener(this);
		btnquestions[12].setOnClickListener(this);
		btnquestions[13].setOnClickListener(this);
		btnquestions[14].setOnClickListener(this);

		btnquestions[0]
				.setBackgroundResource(R.drawable.gamescreen_question_button_red_state);
		btnquestions[1]
				.setBackgroundResource(R.drawable.gamescreen_question_button_red_state);
		btnquestions[2]
				.setBackgroundResource(R.drawable.gamescreen_question_button_red_state);
		btnquestions[3]
				.setBackgroundResource(R.drawable.gamescreen_question_button_red_state);
		btnquestions[4]
				.setBackgroundResource(R.drawable.gamescreen_question_button_red_state);
		btnquestions[5]
				.setBackgroundResource(R.drawable.gamescreen_question_button_red_state);
		btnquestions[6]
				.setBackgroundResource(R.drawable.gamescreen_question_button_red_state);
		btnquestions[7]
				.setBackgroundResource(R.drawable.gamescreen_question_button_red_state);
		btnquestions[8]
				.setBackgroundResource(R.drawable.gamescreen_question_button_red_state);
		btnquestions[9]
				.setBackgroundResource(R.drawable.gamescreen_question_button_red_state);
		btnquestions[10]
				.setBackgroundResource(R.drawable.gamescreen_question_button_red_state);
		btnquestions[11]
				.setBackgroundResource(R.drawable.gamescreen_question_button_red_state);
		btnquestions[12]
				.setBackgroundResource(R.drawable.gamescreen_question_button_red_state);
		btnquestions[13]
				.setBackgroundResource(R.drawable.gamescreen_question_button_red_state);
		btnquestions[14]
				.setBackgroundResource(R.drawable.gamescreen_question_button_red_state);

		ivImages[0] = (ImageView) findViewById(R.id.image01);
		ivImages[1] = (ImageView) findViewById(R.id.image02);
		ivImages[2] = (ImageView) findViewById(R.id.image03);
		ivImages[3] = (ImageView) findViewById(R.id.image04);
		ivImages[4] = (ImageView) findViewById(R.id.image05);
		ivImages[5] = (ImageView) findViewById(R.id.image06);
		ivImages[6] = (ImageView) findViewById(R.id.image07);
		ivImages[7] = (ImageView) findViewById(R.id.image08);
		ivImages[8] = (ImageView) findViewById(R.id.image09);
		ivImages[9] = (ImageView) findViewById(R.id.image10);
		ivImages[10] = (ImageView) findViewById(R.id.image11);
		ivImages[11] = (ImageView) findViewById(R.id.image12);
		ivImages[12] = (ImageView) findViewById(R.id.image13);
		ivImages[13] = (ImageView) findViewById(R.id.image14);
		ivImages[14] = (ImageView) findViewById(R.id.image15);

		if (GameSettings.currentLevel == 1) {
			gameArea.setBackgroundResource(R.drawable.bg_hardin);
		} else if (GameSettings.currentLevel == 2) {
			gameArea.setBackgroundResource(R.drawable.bg_tulugan);
		} else if (GameSettings.currentLevel == 3) {
			gameArea.setBackgroundResource(R.drawable.bg_sala);
		} else if (GameSettings.currentLevel == 4) {
			gameArea.setBackgroundResource(R.drawable.bg_kagubatan);
		} else if (GameSettings.currentLevel == 5) {
			gameArea.setBackgroundResource(R.drawable.bg_attic);
		}// TODO how abput bonus level?

		ivImages[0].setBackgroundResource(R.drawable.item_01);
		ivImages[1].setBackgroundResource(R.drawable.item_02);
		ivImages[2].setBackgroundResource(R.drawable.item_03);
		ivImages[3].setBackgroundResource(R.drawable.item_04);
		ivImages[4].setBackgroundResource(R.drawable.item_05);
		ivImages[5].setBackgroundResource(R.drawable.item_06);
		ivImages[6].setBackgroundResource(R.drawable.item_07);
		ivImages[7].setBackgroundResource(R.drawable.item_08);
		ivImages[8].setBackgroundResource(R.drawable.item_09);
		ivImages[9].setBackgroundResource(R.drawable.item_10);
		ivImages[10].setBackgroundResource(R.drawable.item_11);
		ivImages[11].setBackgroundResource(R.drawable.item_12);
		ivImages[12].setBackgroundResource(R.drawable.item_13);
		ivImages[13].setBackgroundResource(R.drawable.item_14);
		ivImages[14].setBackgroundResource(R.drawable.item_15);

		ivImages[0].setOnTouchListener(this);
		ivImages[1].setOnTouchListener(this);
		ivImages[2].setOnTouchListener(this);
		ivImages[3].setOnTouchListener(this);
		ivImages[4].setOnTouchListener(this);
		ivImages[5].setOnTouchListener(this);
		ivImages[6].setOnTouchListener(this);
		ivImages[7].setOnTouchListener(this);
		ivImages[8].setOnTouchListener(this);
		ivImages[9].setOnTouchListener(this);
		ivImages[10].setOnTouchListener(this);
		ivImages[11].setOnTouchListener(this);
		ivImages[12].setOnTouchListener(this);
		ivImages[13].setOnTouchListener(this);
		ivImages[14].setOnTouchListener(this);

		shownHints = 0;
		showQuestion();
		showAnswer(false, false);
		showPoints();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		switch (v.getId()) {
		case R.id.image01:
			setCorrectAnswer(1);
			break;
		case R.id.image02:
			setCorrectAnswer(2);
			break;
		case R.id.image03:
			setCorrectAnswer(3);
			break;
		case R.id.image04:
			setCorrectAnswer(4);
			break;
		case R.id.image05:
			setCorrectAnswer(5);
			break;
		case R.id.image06:
			setCorrectAnswer(6);
			break;
		case R.id.image07:
			setCorrectAnswer(7);
			break;
		case R.id.image08:
			setCorrectAnswer(8);
			break;
		case R.id.image09:
			setCorrectAnswer(9);
			break;
		case R.id.image10:
			setCorrectAnswer(10);
			break;
		case R.id.image11:
			setCorrectAnswer(11);
			break;
		case R.id.image12:
			setCorrectAnswer(12);
			break;
		case R.id.image13:
			setCorrectAnswer(13);
			break;
		case R.id.image14:
			setCorrectAnswer(14);
			break;
		case R.id.image15:
			setCorrectAnswer(15);
			break;

		}

		// check if all has been answered
		int correctCount = 0;
		int questionindex = 0;

		for (questionindex = 0; questionindex < Constants.MAXQUESTIONS; questionindex++) {
			if (GameSettings.userCorrectAnswers[GameSettings.currentLevel - 1][questionindex]) {
				correctCount++;
			}
		}
		if (correctCount == Constants.MAXANSWERTOUNLOCK) {
			if (Constants.MAXLEVELS > GameSettings.currentLevel) {
				GameSettings.levelLocked[GameSettings.currentLevel] = false;

				if (GameSettings.currentLevel == Constants.MAXLEVELS) {
					Toast.makeText(getApplicationContext(),
							"BONUS STAGE UNLOCKED", Toast.LENGTH_SHORT).show();
				}

				System.out.println("[DATA] Unlock "
						+ (GameSettings.currentLevel));
				// goToSelectLevel();
			}

			System.out.println("CALLED");
			// goToSelectLevel();
		}
		return true;
	}

	private void goToSelectLevel() {
		// Intent intent = ;
		// intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(new Intent(GameActivity.this, SelectLevel.class));
		finish();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.btnqstnumber:
			if (questionsmenu.isShown()) {
				questionsmenu.setVisibility(View.GONE);
			} else {
				questionsmenu.setVisibility(View.VISIBLE);
			}
			break;
		case R.id.btnhint:
			if (!GameSettings.userCorrectAnswers[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1]) {
				if (GameSettings.currentPoints >= Constants.HINTPENALTYPOINTS) {
					showAnswer(true, false);
					showPoints();
				} else if (GameSettings.currentPoints < Constants.HINTPENALTYPOINTS)
					Toast.makeText(getApplicationContext(),
							"Not Enough Points to show Hints",
							Toast.LENGTH_SHORT).show();
				else if (shownHints == GameSettings.levelQuestions[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1]
						.getAnswer().length() - 1)
					Toast.makeText(getApplicationContext(),
							"No More Hints can be shown", Toast.LENGTH_SHORT)
							.show();
			} else {
				Toast.makeText(getApplicationContext(),
						"This Question has been Answered.", Toast.LENGTH_SHORT)
						.show();
			}
			break;

		case R.id.game_screen_btn_pause:
			gameMenuDialog = new Dialog(this);
			gameMenuDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			gameMenuDialog.setContentView(R.layout.gamescreen_pause_menu);

			Button menuBtnResume,
			menuBtnLevel,
			menuBtnMain,
			menuBtnSounds;

			menuBtnResume = (Button) gameMenuDialog
					.findViewById(R.id.game_screen_menu_btn_resume);
			menuBtnLevel = (Button) gameMenuDialog
					.findViewById(R.id.game_screen_menu_btn_level);
			menuBtnMain = (Button) gameMenuDialog
					.findViewById(R.id.game_screen_menu_btn_main);
			menuBtnSounds = (Button) gameMenuDialog
					.findViewById(R.id.game_screen_menu_btn_sound);

			menuBtnResume.setOnClickListener(menuOnClick);
			menuBtnLevel.setOnClickListener(menuOnClick);
			menuBtnMain.setOnClickListener(menuOnClick);
			menuBtnSounds.setOnClickListener(menuOnClick);

			gameMenuDialog.show();

			break;
		case R.id.btnquestion1_1:
			GameSettings.currentQuestion = 1;
			reset();
			break;
		case R.id.btnquestion1_2:
			GameSettings.currentQuestion = 2;
			reset();
			break;
		case R.id.btnquestion1_3:
			GameSettings.currentQuestion = 3;
			reset();
			break;
		case R.id.btnquestion1_4:
			GameSettings.currentQuestion = 4;
			reset();
			break;
		case R.id.btnquestion1_5:
			GameSettings.currentQuestion = 5;
			reset();
			break;
		case R.id.btnquestion2_1:
			GameSettings.currentQuestion = 6;
			reset();
			break;
		case R.id.btnquestion2_2:
			GameSettings.currentQuestion = 7;
			reset();
			break;
		case R.id.btnquestion2_3:
			GameSettings.currentQuestion = 8;
			reset();
			break;
		case R.id.btnquestion2_4:
			GameSettings.currentQuestion = 9;
			reset();
			break;
		case R.id.btnquestion2_5:
			GameSettings.currentQuestion = 10;
			reset();
			break;
		case R.id.btnquestion3_1:
			GameSettings.currentQuestion = 11;
			reset();
			break;
		case R.id.btnquestion3_2:
			GameSettings.currentQuestion = 12;
			reset();
			break;
		case R.id.btnquestion3_3:
			GameSettings.currentQuestion = 13;
			reset();
			break;
		case R.id.btnquestion3_4:
			GameSettings.currentQuestion = 14;
			reset();
			break;
		case R.id.btnquestion3_5:
			GameSettings.currentQuestion = 15;
			reset();
			break;
		}
	}

	OnClickListener menuOnClick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			switch (v.getId()) {

			case R.id.game_screen_menu_btn_resume:
				gameMenuDialog.dismiss();
				break;

			case R.id.game_screen_menu_btn_level:
				gameMenuDialog.dismiss();
				goToSelectLevel();
				break;

			case R.id.game_screen_menu_btn_main:
				gameMenuDialog.dismiss();
				startActivity(new Intent(getBaseContext(), MainScreen.class));
				finish();

				break;

			case R.id.game_screen_menu_btn_sound:

				break;

			}

		}
	};

	private void setCorrectAnswer(int btnquestionIndex) {
		if (!GameSettings.userCorrectAnswers[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1]
				&& btnquestionIndex == GameSettings.currentQuestion) {
			GameSettings.currentPoints += Constants.CORRECTPOINT;
			GameSettings.userCorrectAnswers[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1] = true;

			String answer = GameSettings.levelQuestions[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1]
					.getAnswer();
			tvanswer.setText(answer);

			if (btnquestionIndex == 15)
				btnquestions[btnquestionIndex - 1]
						.setBackgroundResource(R.drawable.gamescreen_question_button_yellow_state);
			else
				btnquestions[btnquestionIndex - 1]
						.setBackgroundResource(R.drawable.gamescreen_question_button_green_state);
		}
		showPoints();
	}

	private void showQuestion() {
		tvquestion
				.setText(GameSettings.levelQuestions[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1]
						.getQuestion());
		btnqstnumber.setText(GameSettings.currentQuestion + "");

	}

	private void showPoints() {
		tvpoints.setText(GameSettings.currentPoints + "");
	}

	private void reset() {
		showQuestion();

		// if answer is not correct
		if (!GameSettings.userCorrectAnswers[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1]) {
			// if has hints
			if (GameSettings.userHintedNumbersHintsShows[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1] > 0) {
				shownHints = GameSettings.userHintedNumbersHintsShows[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1];
				showAnswer(true, true);
			} else {
				shownHints = 0;
				showAnswer(false, false);
			}
		} else {
			String answer = GameSettings.levelQuestions[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1]
					.getAnswer();
			tvanswer.setText(answer);
		}
	}

	private void showAnswer(boolean hasHint, boolean isforshow) {
		String answer = GameSettings.levelQuestions[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1]
				.getAnswer();
		String temp = "";
		String currentHint = "";
		int hintIndex = -1;

		if (hasHint) {
			if (!isforshow) {
				currentHint = tvanswer.getText().toString();
				hintIndex = getIndex(
						GameSettings.levelQuestions[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1]
								.getHintOrder(), shownHints);

				if (hintIndex == -1) {
					Toast.makeText(getApplicationContext(),
							"No More Hints can be shown.", Toast.LENGTH_SHORT)
							.show();
				} else {

					if (hintIndex == 0) {
						currentHint = " "
								+ answer.charAt(0)
								+ currentHint
										.substring(2, currentHint.length());
					} else if (hintIndex == answer.length() - 1) {

						currentHint = tvanswer.getText().toString()
								.substring(0, (hintIndex + 1) * 2 - 1)
								+ answer.charAt(answer.length() - 1);
					} else {
						currentHint = currentHint.substring(0,
								(hintIndex + 1) * 2 - 1)
								+ answer.charAt(hintIndex)
								+ currentHint.substring((hintIndex + 1) * 2,
										currentHint.length());
					}
					// subtract penalty
					// mark question that used
					GameSettings.currentPoints -= Constants.HINTPENALTYPOINTS;
					GameSettings.userHintedNumbers[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1] = true;
					shownHints++;
					GameSettings.userHintedNumbersHintsShows[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1] = shownHints;
				}
				temp = currentHint;
			} else {
				shownHints = GameSettings.userHintedNumbersHintsShows[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1];

				for (int length = 0; length < answer.length(); length++) {
					temp += " _";
				}

				for (int index = 0; index < shownHints; index++) {
					hintIndex = getIndex(
							GameSettings.levelQuestions[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1]
									.getHintOrder(), index);

					if (hintIndex == 0) {
						temp = " " + answer.charAt(0)
								+ temp.substring(2, temp.length());
					} else if (hintIndex == answer.length() - 1) {

						temp = temp.substring(0, (hintIndex + 1) * 2 - 1)
								+ answer.charAt(answer.length() - 1);
					} else {
						temp = temp.substring(0, (hintIndex + 1) * 2 - 1)
								+ answer.charAt(hintIndex)
								+ temp.substring((hintIndex + 1) * 2,
										temp.length());
					}
				}
			}
		} else {
			for (int length = 0; length < answer.length(); length++) {
				temp += " _";
			}
		}

		tvanswer.setText(temp);
	}

	private int getIndex(String hintOrder, int hintCounter) {
		int index = -1;
		int tokenCounter = 0;
		String temp = "";

		StringTokenizer st = new StringTokenizer(hintOrder, ",");

		while (st.hasMoreTokens()) {
			temp = st.nextElement().toString();
			if (hintCounter == tokenCounter) {
				index = Integer.parseInt(temp);
			}
			tokenCounter++;
		}

		return index;
	}

	private void initImages() {
		for (int index = 0; index < Constants.MAXQUESTIONS; index++) {
			View tempView = ivImages[index];
			tempView.setX(GameSettings.levelSearchObjects[GameSettings.currentLevel - 1][index]
					.getTranslationX());
			tempView.setY(GameSettings.levelSearchObjects[GameSettings.currentLevel - 1][index]
					.getTranslationY());
			tempView.setVisibility(View.VISIBLE);
		}

	}

	@Override
	public void onBackPressed() {
		goToSelectLevel();
		finish();
		super.onBackPressed();
	}
}
