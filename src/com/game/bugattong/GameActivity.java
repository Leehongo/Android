package com.game.bugattong;

/*
 *	01072014 added MAXANSWERTOUNLOCK
 */

import java.util.StringTokenizer;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.game.bugattong.pregame.LoadingScreen;
import com.game.bugattong.pregame.MainScreen;
import com.game.bugattong.settings.Constants;
import com.game.bugattong.settings.FileGenerator;
import com.game.bugattong.settings.GameSettings;
import com.game.bugattong.settings.SharedValues;
import com.game.bugattong.utilities.SaveUtility;

public class GameActivity extends Activity implements OnClickListener {

	private SharedValues sharedValues;
	private SaveUtility saveUtility;
	private FileGenerator fileGenerator;

	private LinearLayout questionsmenu;
	private RelativeLayout gameArea;
	private Button btnqstnumber, btnhint, btnPause;
	private Button menuBtnResume, menuBtnLevel, menuBtnMain, menuBtnSounds;
	private Button btnDialogOk;
	private ImageView gamescreenChar;

	private TextView tvquestion, tvpoints, tvanswer;
	private Button[] btnquestions = new Button[Constants.MAXQUESTIONS];
	private ImageView[] ivImages = new ImageView[Constants.MAXQUESTIONS];

	private int shownHints = 0;
	public static boolean isSoundOn;

	private Dialog gameDialog;
	private SoundPool sounds = null;
	

	private final String SELECTEDCHAR = "/data/data/com.game.bugattong/files/character/selectedChar";
	private int correctSound;
	private int errorSound;
	private boolean isInit = false;
	private boolean isQuestionMenuVisible = false;

	private String selectedChar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gamescreen);
		saveUtility = new SaveUtility(this);
		sharedValues = new SharedValues(this);
		fileGenerator = new FileGenerator();
		
		init();
		initImages();

		if (!isInit) {
			isSoundOn = true;
			isInit = true;
		}

		isSoundOn = saveUtility.getSoundSettings();

		// load music
		sounds = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		sounds.setOnLoadCompleteListener(new OnLoadCompleteListener() {

			@Override
			public void onLoadComplete(SoundPool soundPool, int sampleId,
					int status) {
			}
		});

		correctSound = sounds.load(this, R.raw.normal, 1);
		errorSound = sounds.load(this, R.raw.error, 1);
	}

	private void init() {

		selectedChar = sharedValues.getSelectedChar().trim();

		gameArea = (RelativeLayout) findViewById(R.id.gamearea);
		questionsmenu = (LinearLayout) findViewById(R.id.questionmenu);
		btnqstnumber = (Button) findViewById(R.id.btnqstnumber);
		btnhint = (Button) findViewById(R.id.btnhint);
		btnPause = (Button) findViewById(R.id.game_screen_btn_pause);
		tvquestion = (TextView) findViewById(R.id.tvquestion);
		tvpoints = (TextView) findViewById(R.id.tvpoints);
		tvanswer = (TextView) findViewById(R.id.tvanswer);
		gamescreenChar = (ImageView) findViewById(R.id.gamescreen_char);
		btnqstnumber.setTextColor(getResources().getColor(R.color.white));

		if (selectedChar.equals("bug"))
			gamescreenChar.setImageResource(R.drawable.gamescreen_bug);
		else
			gamescreenChar.setImageResource(R.drawable.gamescreen_tong);

		GameSettings.CustomTextView(GameActivity.this, tvquestion);
		GameSettings.CustomTextView(GameActivity.this, tvpoints);
		GameSettings.CustomTextView(GameActivity.this, tvanswer);

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

		GameSettings.CustomTextView(GameActivity.this, btnqstnumber);
		btnqstnumber.setTextSize(20);

		// while(Constants.BTNQUESTIONCOUNTER < Constants.MAXQUESTIONS){
		// System.out.println(Constants.BTNQUESTIONCOUNTER);
		// GameSettings.CustomTextView(GameActivity.this,
		// btnquestions[Constants.BTNQUESTIONCOUNTER]);
		// btnquestions[Constants.BTNQUESTIONCOUNTER].setTextColor(getResources().getColor(R.color.white));
		// Constants.BTNQUESTIONCOUNTER++;
		//
		// }

		btnqstnumber.setOnClickListener(this);
		btnhint.setOnClickListener(this);
		btnPause.setOnClickListener(this);

		boolean setFirstAnswered = false;

		for (int questionIndex = 0; questionIndex < Constants.MAXQUESTIONS; questionIndex++) {
			if (GameSettings.userCorrectAnswers[GameSettings.currentLevel - 1][questionIndex]) {
				if (questionIndex == Constants.MAXQUESTIONS - 1) {
					btnquestions[questionIndex]
							.setBackgroundResource(R.drawable.gamescreen_question_button_yellow_state);
					btnquestions[questionIndex].setTextColor(getResources()
							.getColor(R.color.black));
				} else {
					btnquestions[questionIndex]
							.setBackgroundResource(R.drawable.gamescreen_question_button_green_state);
					btnquestions[questionIndex].setTextColor(getResources()
							.getColor(R.color.white));
				}

			} else {
				btnquestions[questionIndex]
						.setBackgroundResource(R.drawable.gamescreen_question_button_red_state);
				btnquestions[questionIndex].setTextColor(getResources()
						.getColor(R.color.white));
				if (!setFirstAnswered) {
					setFirstAnswered = true;
					GameSettings.currentQuestion = questionIndex + 1;
				}
			}

			GameSettings.CustomTextView(GameActivity.this,
					btnquestions[questionIndex]);
			btnquestions[questionIndex].setOnClickListener(this);
		}

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
		}

		gameArea.setOnClickListener(this);

		int levelObjectCounter = 0;
		while (levelObjectCounter < Constants.MAXQUESTIONS) {
			ivImages[levelObjectCounter]
					.setBackgroundResource(GameSettings.levelObjects[GameSettings.currentLevel - 1][levelObjectCounter]);
			levelObjectCounter++;
		}

		for (int question = 0; question < Constants.MAXQUESTIONS; question++) {
			if (GameSettings.userCorrectAnswers[GameSettings.currentLevel - 1][question])
				ivImages[question].setVisibility(View.GONE);
			else
				ivImages[question].setVisibility(View.VISIBLE);
			ivImages[question].setOnClickListener(this);
		}

		shownHints = 0;
		showQuestion();
		reset();
		showPoints();

		GameSettings.levelPlayed[GameSettings.currentLevel - 1] = true;
	}

	private void checkToUnlockLevel() {

		// check if all has been answered
		int correctCount = 0;
		int questionindex = 0;

		for (questionindex = 0; questionindex < Constants.MAXQUESTIONS; questionindex++) {
			if (GameSettings.userCorrectAnswers[GameSettings.currentLevel - 1][questionindex]) {
				correctCount++;
			}
		}

		// all questions have been answered
		if (correctCount == Constants.MAXQUESTIONS) {
			if (!GameSettings.levelAllQuestionsAnswered[GameSettings.currentLevel - 1]) {
				// Toast.makeText(getApplicationContext(),"All Questions have been answered",
				// Toast.LENGTH_SHORT).show();

				gameDialog = new Dialog(this);
				gameDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
				gameDialog
						.setContentView(R.layout.gamescreen_dialog_all_answered);

				TextView textDialogAllAnswered = (TextView) gameDialog
						.findViewById(R.id.gamescreen_all_answered_text_msg);
				btnDialogOk = (Button) gameDialog
						.findViewById(R.id.gamescreen_all_answered_dialog_btn_ok);

				textDialogAllAnswered
						.setText("All question has been answered.");
				GameSettings.CustomTextView(GameActivity.this,
						textDialogAllAnswered);

				btnDialogOk.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						startNewIntent(SelectLevel.class);
					}
				});
				gameDialog.show();

				GameSettings.levelAllQuestionsAnswered[GameSettings.currentLevel - 1] = true;
			}
		}

		// =============
		if (correctCount == Constants.MAXANSWERTOUNLOCK) {
			if (Constants.MAXLEVELS > GameSettings.currentLevel) {

				if (GameSettings.levelLocked[GameSettings.currentLevel]) {
					gameDialog = new Dialog(this);
					gameDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
					gameDialog
							.setContentView(R.layout.gamescreen__dialog_unlock_level);

					TextView txtViewNote = (TextView) gameDialog
							.findViewById(R.id.game_screen_unlock_level_dialog_txt_congrats_note);
					GameSettings.CustomTextView(GameActivity.this, txtViewNote);

					ImageView unlockLevelDialogImage = (ImageView) gameDialog
							.findViewById(R.id.game_screen_unlock_level_dialog_image);
					Button unlockLevelDialogBtnOk = (Button) gameDialog
							.findViewById(R.id.game_screen_unlock_level_dialog_btn_ok);

					unlockLevelDialogImage
							.setBackgroundResource(Constants.UNLOCKLEVELIMAGEDIALOG[GameSettings.currentLevel - 1]);
					unlockLevelDialogBtnOk
							.setOnClickListener(new OnClickListener() {

								@Override
								public void onClick(View v) {
									gameDialog.dismiss();
								}
							});

					gameDialog.show();
				}
				GameSettings.levelLocked[GameSettings.currentLevel] = false;

				if (GameSettings.currentLevel == Constants.MAXLEVELS) {
					GameSettings.bonusLevelLocked = false;
				}
			}

		}
		GameSettings.saveAll();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.btnqstnumber:
			if (questionsmenu.isShown()) {
				questionsmenu.setVisibility(View.GONE);
				btnPause.setVisibility(View.VISIBLE);
			} else {
				questionsmenu.setVisibility(View.VISIBLE);
				btnPause.setVisibility(View.INVISIBLE);
			}
			break;
		case R.id.btnhint:
			if (!GameSettings.userCorrectAnswers[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1]) {
				if (GameSettings.currentPoints >= Constants.HINTPENALTYPOINTS) {
					showAnswer(true, false);
					showPoints();
				} else if (GameSettings.currentPoints < Constants.HINTPENALTYPOINTS)
					Toast.makeText(getApplicationContext(),"Not Enough Points to show Hints",Toast.LENGTH_SHORT).show();
				else if (shownHints == GameSettings.levelQuestions[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1]
						.getAnswer().length() - 1)
					Toast.makeText(getApplicationContext(),"No More Hints can be shown", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(getApplicationContext(),"This Question has been answered.", Toast.LENGTH_SHORT).show();
			}
			break;

		case R.id.game_screen_btn_pause:
			gameDialog = new Dialog(this);
			gameDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			gameDialog.setContentView(R.layout.gamescreen_pause_menu);

			menuBtnResume = (Button) gameDialog
					.findViewById(R.id.game_screen_menu_btn_resume);
			menuBtnLevel = (Button) gameDialog
					.findViewById(R.id.game_screen_menu_btn_level);
			menuBtnMain = (Button) gameDialog
					.findViewById(R.id.game_screen_menu_btn_main);
			menuBtnSounds = (Button) gameDialog
					.findViewById(R.id.game_screen_menu_btn_sound);

			int msg = 0;
			if (!isSoundOn) {
				msg = R.drawable.button_sounds_off_state;
			} else {
				msg = R.drawable.button_sounds_on_state;
			}
			menuBtnSounds.setBackgroundResource(msg);
			menuBtnResume.setOnClickListener(menuOnClick);
			menuBtnLevel.setOnClickListener(menuOnClick);
			menuBtnMain.setOnClickListener(menuOnClick);
			menuBtnSounds.setOnClickListener(menuOnClick);
			gameDialog.show();
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
		case R.id.image01:
			setCorrectAnswer(1);
			checkToUnlockLevel();
			break;
		case R.id.image02:
			setCorrectAnswer(2);
			checkToUnlockLevel();
			break;
		case R.id.image03:
			setCorrectAnswer(3);
			checkToUnlockLevel();
			break;
		case R.id.image04:
			setCorrectAnswer(4);
			checkToUnlockLevel();
			break;
		case R.id.image05:
			setCorrectAnswer(5);
			checkToUnlockLevel();
			break;
		case R.id.image06:
			setCorrectAnswer(6);
			checkToUnlockLevel();
			break;
		case R.id.image07:
			setCorrectAnswer(7);
			checkToUnlockLevel();
			break;
		case R.id.image08:
			setCorrectAnswer(8);
			checkToUnlockLevel();
			break;
		case R.id.image09:
			setCorrectAnswer(9);
			checkToUnlockLevel();
			break;
		case R.id.image10:
			setCorrectAnswer(10);
			checkToUnlockLevel();
			break;
		case R.id.image11:
			setCorrectAnswer(11);
			checkToUnlockLevel();
			break;
		case R.id.image12:
			setCorrectAnswer(12);
			checkToUnlockLevel();
			break;
		case R.id.image13:
			setCorrectAnswer(13);
			checkToUnlockLevel();
			break;
		case R.id.image14:
			setCorrectAnswer(14);
			checkToUnlockLevel();
			break;
		case R.id.image15:
			setCorrectAnswer(15);
			checkToUnlockLevel();
			break;
		case R.id.gamearea:
			if (isSoundOn)
				playClickSound(true);
			questionsmenu.setVisibility(View.GONE);

			GameSettings.wrongClicks++;
			boolean isLevelComplete = true;
			for (int question = 0; question < Constants.MAXQUESTIONS; question++) {
				if (!GameSettings.userCorrectAnswers[GameSettings.currentLevel - 1][question]) {
					isLevelComplete = false;
					break;
				}
			}

			if (GameSettings.wrongClicks >= Constants.WRONGCLICKPENALTYCOUNT
					&& !GameSettings.userCorrectAnswers[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1]
					&& !isLevelComplete) {
				GameSettings.wrongClicks = 0;
				if (GameSettings.currentPoints >= Constants.WRONGCLICKPENALTYPOINTS) {
					Toast.makeText(getApplicationContext(),"You have clicked 5 wrong items. 15 Points was deducted.",1).show();
					GameSettings.currentPoints -= 15;
				} else {
					GameSettings.currentPoints = 0;
				}
				showPoints();
			}
			break;
		}
	}

	OnClickListener menuOnClick = new OnClickListener() {

		@Override
		public void onClick(View v) {

			switch (v.getId()) {

			case R.id.game_screen_menu_btn_resume:
				gameDialog.dismiss();
				break;

			case R.id.game_screen_menu_btn_level:
				gameDialog.dismiss();
				startNewIntent(SelectLevel.class);
				break;

			case R.id.game_screen_menu_btn_main:
				gameDialog.dismiss();
				startNewIntent(MainScreen.class);
				break;

			case R.id.game_screen_menu_btn_sound:
				int msg = 0;
				if (!isSoundOn) {
					msg = R.drawable.button_sounds_on_state;
					isSoundOn = true;
				} else {
					msg = R.drawable.button_sounds_off_state;
					isSoundOn = false;
				}
				saveUtility.saveSoundSettings(isSoundOn);
				menuBtnSounds.setBackgroundResource(msg);
				break;
			}
		}
	};

	private void playClickSound(boolean isError) {
		AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
		float actualVolume = (float) audioManager
				.getStreamVolume(AudioManager.STREAM_MUSIC);
		float maxVolume = (float) audioManager
				.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		float volume = actualVolume / maxVolume;

		if (isError) {
			sounds.play(errorSound, volume, volume, 1, 0, 1f);
		} else {
			sounds.play(correctSound, volume, volume, 1, 0, 1f);
		}
	}

	final Handler questionhandler = new Handler();

	private void setCorrectAnswer(int btnquestionIndex) {

		if (!questionsmenu.isShown()) {
			if (!GameSettings.userCorrectAnswers[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1]
					&& btnquestionIndex == GameSettings.currentQuestion) {
				if (isSoundOn)
					playClickSound(false);
				GameSettings.currentPoints += Constants.CORRECTPOINT;
				GameSettings.userCorrectAnswers[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1] = true;

				ivImages[GameSettings.currentQuestion - 1]
						.setVisibility(View.GONE);

				String answer = GameSettings.levelQuestions[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1]
						.getAnswer();
				tvanswer.setText(answer);

				// put delay

				// show next Question
				questionhandler.postDelayed(new Runnable() {
					@Override
					public void run() {
						if (GameSettings.currentQuestion <= Constants.MAXQUESTIONS) {
							int questionIndex = 0;
							boolean hasPreviousUnswered = false;
							boolean hasNextUnAnswered = false;
							int previousIndex = 0;
							int afterIndex = 0;

							for (questionIndex = 0; questionIndex < Constants.MAXQUESTIONS; questionIndex++) {
								if (!GameSettings.userCorrectAnswers[GameSettings.currentLevel - 1][questionIndex]) {
									if (!hasPreviousUnswered
											&& questionIndex < GameSettings.currentQuestion) {
										hasPreviousUnswered = true;
										previousIndex = questionIndex;
									} else if (!hasNextUnAnswered
											&& questionIndex > GameSettings.currentQuestion) {
										hasNextUnAnswered = true;
										afterIndex = questionIndex;
									} else if (!hasNextUnAnswered
											&& questionIndex > GameSettings.currentQuestion) {
										hasNextUnAnswered = true;
										afterIndex = questionIndex;
									} else if (!hasNextUnAnswered
											&& questionIndex == GameSettings.currentQuestion) {
										hasNextUnAnswered = true;
										afterIndex = questionIndex + 1;
									}
								}
							}

							if (hasNextUnAnswered) {
								GameSettings.currentQuestion = afterIndex;
								System.out.println("Chosen Next : "
										+ afterIndex);
							} else if (hasPreviousUnswered) {
								GameSettings.currentQuestion = previousIndex + 1;
								System.out.println("Chosen Previous : "
										+ previousIndex);
							}

							showQuestion();

							btnqstnumber
									.setBackgroundResource(R.drawable.game_select_question_btn_red_normal);
							btnqstnumber.setTextColor(getResources().getColor(
									R.color.white));

							showAnswer(false, false);
						}
					}
				}, 1000);

				if (btnquestionIndex == 15) {
					btnquestions[btnquestionIndex - 1]
							.setBackgroundResource(R.drawable.gamescreen_question_button_yellow_state);
					btnquestions[btnquestionIndex - 1]
							.setTextColor(getResources()
									.getColor(R.color.black));
				} else {
					btnquestions[btnquestionIndex - 1]
							.setBackgroundResource(R.drawable.gamescreen_question_button_green_state);
					btnquestions[btnquestionIndex - 1]
							.setTextColor(getResources()
									.getColor(R.color.white));
				}

				if (GameSettings.userCorrectAnswers[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1]) {
					if (GameSettings.currentQuestion == Constants.MAXQUESTIONS) {
						btnqstnumber
								.setBackgroundResource(R.drawable.game_select_question_btn_yellow_normal);
						btnqstnumber.setTextColor(getResources().getColor(
								R.color.black));
					} else {
						btnqstnumber
								.setBackgroundResource(R.drawable.game_select_question_btn_green_normal);
						btnqstnumber.setTextColor(getResources().getColor(
								R.color.white));
					}
				} else {
					btnqstnumber
							.setBackgroundResource(R.drawable.game_select_question_btn_red_normal);
					btnqstnumber.setTextColor(getResources().getColor(
							R.color.white));

				}
			} else {
				if (isSoundOn)
					playClickSound(true);

				GameSettings.wrongClicks++;

				if (GameSettings.wrongClicks == Constants.WRONGCLICKPENALTYCOUNT
						&& !GameSettings.userCorrectAnswers[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1]) {
					GameSettings.wrongClicks = 0;
					Toast.makeText(getApplicationContext(),"You have clicked 5 wrong items. 15 Points was deducted.",1).show();

					if (GameSettings.currentPoints >= Constants.WRONGCLICKPENALTYPOINTS) {
						GameSettings.currentPoints -= 15;
					} else {
						GameSettings.currentPoints = 0;
					}
				}

			}

			showPoints();
		}
	}

	private void showQuestion() {
		tvquestion
				.setText(GameSettings.levelQuestions[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1]
						.getQuestion());
		btnqstnumber.setText(GameSettings.currentQuestion + "");

	}

	private void showPoints() {
		tvpoints.setText(GameSettings.currentPoints + "");
			//TODO must show dialog before restart the game
		
		
		if(GameSettings.currentPoints == 0){
			
			gameDialog = new Dialog(this);
			gameDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			gameDialog.setContentView(R.layout.gamescreen_dialog_gameover);

			TextView txtViewNote = (TextView) gameDialog.findViewById(R.id.gamescreen_dialog_gameover_text_msg);
			GameSettings.CustomTextView(GameActivity.this, txtViewNote);

			Button unlockLevelDialogBtnOk = (Button) gameDialog.findViewById(R.id.gamescreen_dialog_gameover_dialog_btn_ok);

			unlockLevelDialogBtnOk.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							gameDialog.dismiss();
							sharedValues.clearData();
							saveUtility.clearData();
//							fileGenerator.removeFile(SELECTEDCHAR);
							startNewIntent(LoadingScreen.class);
							GameSettings.init(GameActivity.this, true);
							GameSettings.saveAll();
						}
					});

			gameDialog.show();
		}
	}

	private void reset() {
		showQuestion();

		// if answer is not correct
		if (!GameSettings.userCorrectAnswers[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1]) {
			// if has hints
			if (GameSettings.userHintedNumbersHintsShown[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1] > 0) {
				shownHints = GameSettings.userHintedNumbersHintsShown[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1];
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

		if (GameSettings.userCorrectAnswers[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1]) {
			if (GameSettings.currentQuestion == Constants.MAXQUESTIONS) {
				btnqstnumber
						.setBackgroundResource(R.drawable.game_select_question_btn_yellow_normal);
				btnqstnumber.setTextColor(getResources()
						.getColor(R.color.black));
			} else {
				btnqstnumber
						.setBackgroundResource(R.drawable.game_select_question_btn_green_normal);
				btnqstnumber.setTextColor(getResources()
						.getColor(R.color.white));
			}
		} else {
			btnqstnumber
					.setBackgroundResource(R.drawable.game_select_question_btn_red_normal);
			btnqstnumber.setTextColor(getResources().getColor(R.color.white));

		}

		// Start BOnus Stage
		// check if all questions have been unlocked in order to unlock bonus
		// stage
		boolean unlockBonus = true;

		// check all are unlocked
		for (int level = 0; level < Constants.MAXLEVELS; level++) {
			for (int question = 0; question < Constants.MAXQUESTIONS; question++) {
				if (!GameSettings.userCorrectAnswers[level][question]) {
					unlockBonus = false;
					break;
				}
			}
		}

		boolean completed = true;
		for (int question = 0; question < Constants.MAXQUESTIONS; question++) {
			if (!GameSettings.userCorrectAnswers[GameSettings.currentLevel - 1][question]) {
				completed = false;
				break;
			}
		}
		if (completed) {
			gameDialog = new Dialog(this);
			gameDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			gameDialog.setContentView(R.layout.gamescreen_dialog_all_answered);

			TextView textDialogAllAnswered = (TextView) gameDialog
					.findViewById(R.id.gamescreen_all_answered_text_msg);
			btnDialogOk = (Button) gameDialog
					.findViewById(R.id.gamescreen_all_answered_dialog_btn_ok);

			textDialogAllAnswered.setText("All question has been answered.");
			GameSettings.CustomTextView(GameActivity.this,
					textDialogAllAnswered);

			btnDialogOk.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					gameDialog.dismiss();
					// goToSelectLevel();
				}
			});
			gameDialog.show();

		}

		if (unlockBonus) {
			GameSettings.bonusLevelLocked = false;

			gameDialog = new Dialog(this);
			gameDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			gameDialog.setContentView(R.layout.gamescreen_dialog_all_answered);

			TextView textDialogAllAnswered = (TextView) gameDialog
					.findViewById(R.id.gamescreen_all_answered_text_msg);
			btnDialogOk = (Button) gameDialog
					.findViewById(R.id.gamescreen_all_answered_dialog_btn_ok);

			textDialogAllAnswered.setText("Mystery Level Unlocked!");
			GameSettings.CustomTextView(GameActivity.this,
					textDialogAllAnswered);

			btnDialogOk.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					startNewIntent(SelectLevel.class);
				}
			});
			gameDialog.show();
		}
		// End Bonus Stage
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
					GameSettings.userHintedNumbersHintsShown[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1] = shownHints;
				}
				temp = currentHint;

				SelectLevel.unlockBonus(this);
			} else {
				shownHints = GameSettings.userHintedNumbersHintsShown[GameSettings.currentLevel - 1][GameSettings.currentQuestion - 1];

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
		}

	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		startNewIntent(SelectLevel.class);
	}
	
	private void startNewIntent(Class s){
		startActivity(new Intent(GameActivity.this, s));
		finish();
	}
}
