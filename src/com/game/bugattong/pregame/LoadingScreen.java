package com.game.bugattong.pregame;

import java.io.File;

import com.game.bugattong.R;
import com.game.bugattong.R.layout;
import com.game.bugattong.settings.FileGenerator;
import com.game.bugattong.settings.SharedValues;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class LoadingScreen extends Activity {
	
	private CountDownTimer timer;
	private FileGenerator fileGenerator;
	private File filePath;
	private SharedValues sharedValues;
	
	private final String[] DIRECTORIES = {"/data/data/com.game.bugattong/files/",
			"/data/data/com.game.bugattong/files/character/"};
	private final String SELECTEDCHAR = "/data/data/com.game.bugattong/files/character/selectedChar";
	
	String existingSelectedChar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loading_screen);
		
		fileGenerator = new FileGenerator();
		sharedValues = new SharedValues(LoadingScreen.this);
		
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

				filePath = new File(SELECTEDCHAR);
				if(filePath.exists()){
					existingSelectedChar = fileGenerator.readFile(SELECTEDCHAR).trim();
					sharedValues.setSelectedChar(existingSelectedChar);
					System.out.println("MY CHAR IS SHRED: " + sharedValues.getSelectedChar());
					startActivity(new Intent(LoadingScreen.this, MainScreen.class));
				}else{
					System.out.println("walang char");
					startActivity(new Intent(LoadingScreen.this, SelectCharacter.class));
					
				}
				
				finish();
				
			}
		}.start();
	}

 

}
