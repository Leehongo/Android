package com.game.bugattong.pregame;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.game.bugattong.R;
import com.game.bugattong.StoryView;
import com.game.bugattong.settings.FileGenerator;
import com.game.bugattong.settings.SharedValues;

public class MainScreen extends Activity{
	
	private LinearLayout layoutMainScreen;
	private Button btnRestart,btnSound,btnHelp,btnCustomize, btnExit;
	private TextView txtTouchToStart;

	private final String SELECTEDCHAR = "/data/data/com.game.bugattong/files/character/selectedChar";
	boolean isSoundOn = true;
	private FileGenerator fileGenerator;
	private SharedValues sharedValues;
	

	private Dialog dialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.main_screen);
		super.onCreate(savedInstanceState);
		
		sharedValues = new SharedValues(MainScreen.this);
		fileGenerator = new FileGenerator();
		initUI();
	}
	
	private void initUI(){
		layoutMainScreen = (LinearLayout) findViewById(R.id.main_screen_layout_main);
		btnRestart = (Button) findViewById(R.id.main_screen_btn_restart);
		btnSound = (Button) findViewById(R.id.main_screen_btn_sound);
		btnHelp = (Button) findViewById(R.id.main_screen_btn_help);
		btnCustomize = (Button) findViewById(R.id.main_screen_btn_customize);
		btnExit = (Button) findViewById(R.id.main_screen_btn_exit);
		txtTouchToStart = (TextView) findViewById(R.id.mainscreen_txt_touch_to_continue);
		
		Typeface font = Typeface.createFromAsset(getAssets(), "BADABB__.TTF");  
		txtTouchToStart.setTypeface(font);  
	}
	
	@Override
	protected void onStart() {
		layoutMainScreen.setOnClickListener(ocl);
		btnRestart.setOnClickListener(ocl);
		btnSound.setOnClickListener(ocl);
		btnHelp.setOnClickListener(ocl);
		btnCustomize.setOnClickListener(ocl);
		btnExit.setOnClickListener(ocl);
		
		
		super.onStart();
	}
	
	View.OnClickListener ocl = new View.OnClickListener() {

		@Override
		public void onClick(View v) {

			switch (v.getId()) {

			case R.id.main_screen_layout_main:
				
				//TODO if already has session, proceed to SelectLevelClass..
//				startIntent(StoryView.class);
				
				Intent intent = new Intent(MainScreen.this, StoryView.class);
				intent.putExtra("getNextPage", "initial");
				startActivity(intent);
				finish();
				break;
				
			case R.id.main_screen_btn_restart:
				sharedValues.clearData();
				fileGenerator.removeFile(SELECTEDCHAR);
				startIntent(LoadingScreen.class);
				break;
				

			case R.id.main_screen_btn_sound:
				int msg = (isSoundOn == true)? R.drawable.game_menu_btn_sounds_off: R.drawable.game_menu_btn_sounds_on;
				btnSound.setBackgroundResource(msg);
				isSoundOn = !isSoundOn;
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
	};
	
	private void alertDialog(){
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
	
	private void startIntent(Class c){
		startActivity(new Intent(MainScreen.this, c));
		finish();
	}
	
	@Override
	public void onBackPressed() {
		finish();
		super.onBackPressed();
	}
}
