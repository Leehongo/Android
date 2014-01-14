package com.game.bugattong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.game.bugattong.pregame.MainScreen;
import com.game.bugattong.settings.Constants;
import com.game.bugattong.settings.GameSettings;

public class SelectLevel extends Activity {

	private Button btnLevelHardin, btnLevelSilidTulugan, btnLevelSala,
			btnLevelKagubatan, btnLevelAttic, btnLevelBonus;

	private ImageView imgLockLevel1, imgLockLevel2, imgLockLevel3,
			imgLockLevel4, imgLockLevel5, imgLockLevelBonus;

	private TextView[] answered = new TextView[5];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.select_level);
		super.onCreate(savedInstanceState);
		if (!GameSettings.hasInit) {
			GameSettings.init(this);
			GameSettings.hasInit = true;
			System.out.println("INIT!");
		}

		initUI();

		// check all are unlocked
		boolean unlockBonus = true;
		for (int level = 0; level < Constants.MAXLEVELS; level++) {
			for (int question = 0; question < Constants.MAXQUESTIONS; question++) {
				if (!GameSettings.userCorrectAnswers[level][question]) {
					unlockBonus = false;
					break;
				}
			}
		}
		if (unlockBonus) {
			if (GameSettings.bonusLevelLocked)
				Toast.makeText(getApplicationContext(), "BONUS STAGE UNLOCKED",
						Toast.LENGTH_SHORT).show();
			GameSettings.bonusLevelLocked = false;
			if (GameSettings.bonusLevelLocked)
				imgLockLevelBonus.setVisibility(View.VISIBLE);
			else
				imgLockLevelBonus.setVisibility(View.GONE);
		}
	}

	private void initUI() {

		btnLevelHardin = (Button) findViewById(R.id.btn_level_1_hardin);
		btnLevelSilidTulugan = (Button) findViewById(R.id.btn_level_2_silid_tulugan);
		btnLevelSala = (Button) findViewById(R.id.btn_level_3_sala);
		btnLevelKagubatan = (Button) findViewById(R.id.btn_level_4_kagubatan);
		btnLevelAttic = (Button) findViewById(R.id.btn_level_5_attic);

		btnLevelBonus = (Button) findViewById(R.id.btn_level_bonus);

		imgLockLevel1 = (ImageView) findViewById(R.id.btn_level_1_hardin_lock);
		imgLockLevel2 = (ImageView) findViewById(R.id.btn_level_2_silid_tulugan_lock);
		imgLockLevel3 = (ImageView) findViewById(R.id.btn_level_3_sala_lock);
		imgLockLevel4 = (ImageView) findViewById(R.id.btn_level_4_kagubatan_lock);
		imgLockLevel5 = (ImageView) findViewById(R.id.btn_level_5_attic_lock);
		imgLockLevelBonus = (ImageView) findViewById(R.id.btn_level_bonus_lock);

		answered[0] = (TextView) findViewById(R.id.level_1_answered);
		answered[1] = (TextView) findViewById(R.id.level_2_answered);
		answered[2] = (TextView) findViewById(R.id.level_3_answered);
		answered[3] = (TextView) findViewById(R.id.level_4_answered);
		answered[4] = (TextView) findViewById(R.id.level_5_answered);

		btnLevelHardin.setOnClickListener(ocl);
		btnLevelSilidTulugan.setOnClickListener(ocl);
		btnLevelSala.setOnClickListener(ocl);
		btnLevelKagubatan.setOnClickListener(ocl);
		btnLevelAttic.setOnClickListener(ocl);
		btnLevelBonus.setOnClickListener(ocl);

		if (GameSettings.levelLocked[0])
			imgLockLevel1.setVisibility(View.VISIBLE);
		else
			imgLockLevel1.setVisibility(View.GONE);

		if (GameSettings.levelLocked[1])
			imgLockLevel2.setVisibility(View.VISIBLE);
		else
			imgLockLevel2.setVisibility(View.GONE);

		if (GameSettings.levelLocked[2])
			imgLockLevel3.setVisibility(View.VISIBLE);
		else
			imgLockLevel3.setVisibility(View.GONE);

		if (GameSettings.levelLocked[3])
			imgLockLevel4.setVisibility(View.VISIBLE);
		else
			imgLockLevel4.setVisibility(View.GONE);

		if (GameSettings.levelLocked[4])
			imgLockLevel5.setVisibility(View.VISIBLE);
		else
			imgLockLevel5.setVisibility(View.GONE);

		if (GameSettings.bonusLevelLocked)
			imgLockLevelBonus.setVisibility(View.VISIBLE);
		else
			imgLockLevelBonus.setVisibility(View.GONE);

		// answered
		int correct = 0;
		for (int level = 0; level < Constants.MAXLEVELS; level++) {
			correct = 0;
			for (int question = 0; question < Constants.MAXQUESTIONS; question++) {
				if (GameSettings.userCorrectAnswers[level][question])
					correct++;
			}
			answered[level].setText(correct + " out of 15 ");
		}
	}

	OnClickListener ocl = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {

			case R.id.btn_level_1_hardin:
				GameSettings.currentLevel = 1;
				GameSettings.currentQuestion = 1;
				startlevel("level1");
				break;
			case R.id.btn_level_2_silid_tulugan:
				if (!GameSettings.levelLocked[1]) {
					GameSettings.currentLevel = 2;
					GameSettings.currentQuestion = 1;
					startlevel("level2");
				}
				break;
			case R.id.btn_level_3_sala:
				if (!GameSettings.levelLocked[2]) {
					GameSettings.currentLevel = 3;
					GameSettings.currentQuestion = 1;
					startlevel("level3");
				}
				break;
			case R.id.btn_level_4_kagubatan:
				if (!GameSettings.levelLocked[3]) {
					GameSettings.currentLevel = 4;
					GameSettings.currentQuestion = 1;
					startlevel("level4");
				}
				break;
			case R.id.btn_level_5_attic:
				if (!GameSettings.levelLocked[4]) {
					GameSettings.currentLevel = 5;
					GameSettings.currentQuestion = 1;
					startlevel("level5");
				}
				break;

			case R.id.btn_level_bonus:
				if (!GameSettings.bonusLevelLocked) {
					startBonus();
				} else {
					Toast.makeText(getApplicationContext(),
							"Please answer all questions first.",
							Toast.LENGTH_SHORT).show();
				}

				break;
			}

		}
	};

	private void startBonus() {

		Intent intent = new Intent(SelectLevel.this, BonusActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
		finish();
	}

	private void startlevel(String str) {
		Intent intent;

		if (GameSettings.levelPlayed[GameSettings.currentLevel - 1])
			intent = new Intent(SelectLevel.this, GameActivity.class);
		else
			intent = new Intent(SelectLevel.this, StoryView.class);

		intent.putExtra("getNextPage", str);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
		finish();
	}

	public void onBackPressed() {

		startActivity(new Intent(SelectLevel.this, MainScreen.class));
		finish();

	};

}
