package com.game.bugattong.pregame;

import com.game.bugattong.R;
import com.game.bugattong.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class LoadingScreen extends Activity {
	
	private CountDownTimer timer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loading_screen);
	}

	
	
	@Override
	protected void onStart() {
		
		timer = new CountDownTimer(3000,1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onFinish() {
				
				//TODO if has session, proceed to MainScreen class
				startActivity(new Intent(LoadingScreen.this, SelectCharacter.class));
				finish();
				
			}
		}.start();

		
		
		
		super.onStart();
	}

}
