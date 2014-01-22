package com.game.bugattong.pregame;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.game.bugattong.GameActivity;
import com.game.bugattong.R;
import com.game.bugattong.StoryView;
import com.game.bugattong.settings.FileGenerator;
import com.game.bugattong.settings.GameSettings;
import com.game.bugattong.settings.SharedValues;
import com.game.bugattong.utilities.SaveUtility;

public class MainScreen extends Activity implements OnClickListener {

	private RelativeLayout layoutMainScreen;
	private Button btnRestart, btnSound, btnHelp, btnCustomize, btnExit;
	private ImageView txtTouchToStart;

	private final String SELECTEDCHAR = "/data/data/com.game.bugattong/files/character/selectedChar";
	private FileGenerator fileGenerator;
	private SharedValues sharedValues;
	private SaveUtility saveUtility;

	private Dialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.main_screen);
		super.onCreate(savedInstanceState);

		sharedValues = new SharedValues(MainScreen.this);
		saveUtility = new SaveUtility(MainScreen.this);
		fileGenerator = new FileGenerator();
		initUI();
	}

	private void initUI() {
		layoutMainScreen = (RelativeLayout) findViewById(R.id.main_screen_layout_main);
		btnRestart = (Button) findViewById(R.id.main_screen_btn_restart);
		btnSound = (Button) findViewById(R.id.main_screen_btn_sound);
		btnHelp = (Button) findViewById(R.id.main_screen_btn_help);
		btnCustomize = (Button) findViewById(R.id.main_screen_btn_customize);
		btnExit = (Button) findViewById(R.id.main_screen_btn_exit);
		txtTouchToStart = (ImageView) findViewById(R.id.mainscreen_txt_touch_to_continue);

		// Typeface font = Typeface.createFromAsset(getAssets(),
		// "BADABB__.TTF");
		// txtTouchToStart.setTypeface(font);
		// GameSettings.CustomTextView(MainScreen.this, txtTouchToStart);
	}

	@Override
	protected void onStart() {
		layoutMainScreen.setOnClickListener(this);
		btnRestart.setOnClickListener(this);
		btnSound.setOnClickListener(this);
		btnHelp.setOnClickListener(this);
		btnCustomize.setOnClickListener(this);
		btnExit.setOnClickListener(this);

		super.onStart();
	}

	private void alertDialog() {
		dialog = new Dialog(this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.main_exit_menu);

		Button btnYes, btnNo;

		btnYes = (Button) dialog.findViewById(R.id.exit_menu_yes);
		btnNo = (Button) dialog.findViewById(R.id.exit_menu_no);

		btnYes.setOnClickListener(exitMenuOnClick);
		btnNo.setOnClickListener(exitMenuOnClick);

		dialog.show();
	}

	OnClickListener exitMenuOnClick = new OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.exit_menu_yes:
				dialog.dismiss();
				finish();
				break;

			case R.id.exit_menu_no:
				dialog.dismiss();
				break;
			}
		}
	};

	private void startIntent(Class c) {
		startActivity(new Intent(MainScreen.this, c));
		finish();
	}

	@Override
	public void onBackPressed() {
		finish();
		super.onBackPressed();
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.main_screen_layout_main:

			// TODO if already has session, proceed to SelectLevelClass..
			// startIntent(StoryView.class);
			Intent intent;

			// if(GameSettings.levelPlayed[GameSettings.currentLevel-1]){ //may
			// error
			// intent = new Intent(MainScreen.this, GameActivity.class);
			// }else{
			intent = new Intent(MainScreen.this, StoryView.class);
			// }

			intent.putExtra("getNextPage", "initial");
			startActivity(intent);
			finish();
			break;

		case R.id.main_screen_btn_restart:
			sharedValues.clearData();
			saveUtility.clearData();
			fileGenerator.removeFile(SELECTEDCHAR);
			startIntent(LoadingScreen.class);
			GameSettings.init(this, true);
			GameSettings.saveAll();
			break;

		case R.id.main_screen_btn_sound:
			int msg = (GameActivity.isSoundOn == true) ? R.drawable.button_sounds_off_state
					: R.drawable.button_sounds_on_state;
			btnSound.setBackgroundResource(msg);
			GameActivity.isSoundOn = !GameActivity.isSoundOn;
			saveUtility.saveSoundSettings(GameActivity.isSoundOn);
			break;

		case R.id.main_screen_btn_help:
			break;

		case R.id.main_screen_btn_customize:
			startIntent(CustomizeCharacter.class);
			break;

		case R.id.main_screen_btn_exit:
			alertDialog();
			break;

		default:
			break;
		}
	}

}
