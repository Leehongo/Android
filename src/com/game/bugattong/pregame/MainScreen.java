package com.game.bugattong.pregame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.game.bugattong.R;
import com.game.bugattong.StoryView;
import com.game.bugattong.settings.FileGenerator;

public class MainScreen extends Activity{

	private Button btnStartContinue,btnRestart,btnSound,btnHelp,btnCustomize, btnExit;

	private final String SELECTEDCHAR = "/data/data/com.game.bugattong/files/character/selectedChar";
	boolean isSoundOn = true;
	private FileGenerator fileGenerator;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.main_screen);
		super.onCreate(savedInstanceState);
		
		fileGenerator = new FileGenerator();
		initUI();
	}
	
	private void initUI(){
		btnStartContinue = (Button) findViewById(R.id.main_screen_btn_start_continue);
		btnRestart = (Button) findViewById(R.id.main_screen_btn_restart);
		btnSound = (Button) findViewById(R.id.main_screen_btn_sound);
		btnHelp = (Button) findViewById(R.id.main_screen_btn_help);
		btnCustomize = (Button) findViewById(R.id.main_screen_btn_customize);
		btnExit = (Button) findViewById(R.id.main_screen_btn_exit);
	}
	
	@Override
	protected void onStart() {
		btnStartContinue.setOnClickListener(ocl);
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

			case R.id.main_screen_btn_start_continue:
				
				//TODO if already has session, proceed to SelectLevelClass..
//				startIntent(StoryView.class);
				
				Intent intent = new Intent(MainScreen.this, StoryView.class);
				intent.putExtra("getNextPage", "initial");
				startActivity(intent);
				finish();
				break;
				
			case R.id.main_screen_btn_restart:
				fileGenerator.removeFile(SELECTEDCHAR);
				startIntent(LoadingScreen.class);
				break;
				

			case R.id.main_screen_btn_sound:
				String msg = (isSoundOn == true)? "Sound: OFF": "Sound: ON";
				btnSound.setText(msg);
				isSoundOn = !isSoundOn;
				break;

			case R.id.main_screen_btn_help:
				break;

			case R.id.main_screen_btn_customize:
				startIntent(CustomizeCharacter.class);
				break;

			case R.id.main_screen_btn_exit:
				finish();
				break;

			default:
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
