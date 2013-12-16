package com.game.bugattong.pregame;

import com.game.bugattong.StoryView;
import com.game.bugattong.R;
import com.game.bugattong.R.id;
import com.game.bugattong.R.layout;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreen extends Activity{

	Button btnStartContinue,btnSound,btnHelp,btnCustomize, btnExit;
	
	boolean isSoundOn = true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		setContentView(R.layout.main_screen);
		super.onCreate(savedInstanceState);
		
		initUI();
	}
	
	private void initUI(){
		btnStartContinue = (Button) findViewById(R.id.main_screen_btn_start_continue);
		btnSound = (Button) findViewById(R.id.main_screen_btn_sound);
		btnHelp = (Button) findViewById(R.id.main_screen_btn_help);
		btnCustomize = (Button) findViewById(R.id.main_screen_btn_customize);
		btnExit = (Button) findViewById(R.id.main_screen_btn_exit);
	}
	
	
	@Override
	protected void onStart() {
		btnStartContinue.setOnClickListener((android.view.View.OnClickListener) ocl);
		btnSound.setOnClickListener((android.view.View.OnClickListener) ocl);
		btnHelp.setOnClickListener((android.view.View.OnClickListener) ocl);
		btnCustomize.setOnClickListener((android.view.View.OnClickListener) ocl);
		btnExit.setOnClickListener((android.view.View.OnClickListener) ocl);
		
		
		super.onStart();
	}
	
	View.OnClickListener ocl = new View.OnClickListener() {

		@Override
		public void onClick(View v) {

			switch (v.getId()) {

			case R.id.main_screen_btn_start_continue:
				
				//TODO if already has session, proceed to SelectLevelClass..
//				startIntent(StoryView.class);
				
				Intent intent = new Intent(getApplicationContext(), StoryView.class);
				intent.putExtra("getNextPage", "initial");
				startActivity(intent);
				finish();
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
