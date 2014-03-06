package com.game.bugattong.pregame;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.game.bugattong.R;
import com.game.bugattong.settings.Constants;
import com.game.bugattong.settings.FileGenerator;
import com.game.bugattong.settings.ScreenSize;
import com.game.bugattong.settings.SharedValues;
import com.game.bugattong.utilities.SaveUtility;

public class LoadingScreen extends Activity {
	
	private CountDownTimer timer;
	private FileGenerator fileGenerator;
	private File filePath;
	private SharedValues sharedValues;
	private SaveUtility saveUtility;
	
	private final String[] DIRECTORIES = {"/data/data/com.game.bugattong/files/",
			"/data/data/com.game.bugattong/files/character/"};
//	private final String SELECTEDCHAR = "/data/data/com.game.bugattong/files/character/selectedChar";
	
	String existingSelectedChar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loading_screen);
		
		fileGenerator = new FileGenerator();
		sharedValues = new SharedValues(LoadingScreen.this);
		saveUtility = new SaveUtility(LoadingScreen.this);

		Constants.isSoundOn = saveUtility.getSoundSettings();
		System.out.println("loading: sounds " + Constants.isSoundOn);
		
		sizeIdentifier();
		startCountDown();
	}
	
	private void startCountDown(){
			
		timer = new CountDownTimer(3000,1000) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				
				for (String str : DIRECTORIES) { // create directory 
					filePath = new File(str);
					if (!filePath.exists())
					filePath.mkdir();
				}
			}
			
			@Override
			public void onFinish() {

				filePath = new File(Constants.SELECTEDCHAR);
				if(filePath.exists()){
					existingSelectedChar = fileGenerator.readFile(Constants.SELECTEDCHAR).trim();
					sharedValues.setSelectedChar(existingSelectedChar);
					
					startActivity(new Intent(LoadingScreen.this, MainScreen.class));
				}else{
					startActivity(new Intent(LoadingScreen.this, SelectCharacter.class));
					
				}
				finish();
				
			}
		}.start();
	}
	
	private void sizeIdentifier(){
		
		switch ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)) {
		
		case Configuration.SCREENLAYOUT_SIZE_SMALL:
			System.out.println("small");
			Constants.SCREENSIZE = ScreenSize.SMALL;
			break;
		case Configuration.SCREENLAYOUT_SIZE_NORMAL:
			System.out.println("normal");
			Constants.SCREENSIZE = ScreenSize.NORMAL;
			break;
		
		case Configuration.SCREENLAYOUT_SIZE_LARGE:
			System.out.println("large");
			Constants.SCREENSIZE = ScreenSize.LARGE;
			break;
			
			case Configuration.SCREENLAYOUT_SIZE_XLARGE:
				System.out.println("x-large");
				Constants.SCREENSIZE = ScreenSize.XLARGE;
				break;
 
		}
	}

 

}
