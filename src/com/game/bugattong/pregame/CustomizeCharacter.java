package com.game.bugattong.pregame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.game.bugattong.R;
import com.game.bugattong.settings.FileGenerator;
import com.game.bugattong.settings.SharedValues;

public class CustomizeCharacter extends Activity {

	private ImageView selectedChar, topDressSelected, bottomDressSelected;
	private ImageView topDress1, topDress2, topDress3;
	private ImageView bottomDress1, bottomDress2, bottomDress3;
	private Button btnSave, btnCancel;
	
	private String selectedCharName;
	private int selectedTop, selectedBottom;
	private int selectedGameScreen;
	
	private SharedValues sharedValues;
	private FileGenerator fileGenerator;
	
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.customize_character);
		super.onCreate(savedInstanceState);
		sharedValues = new SharedValues(getApplicationContext());
		fileGenerator = new FileGenerator();
		
		initUI();
		actions();
	}

	private void initUI() {
		selectedChar = (ImageView) findViewById(R.id.selected_char);
		topDressSelected = (ImageView) findViewById(R.id.char_dress_top);
		bottomDressSelected = (ImageView) findViewById(R.id.char_dress_bottom);

		topDress1 = (ImageView) findViewById(R.id.select_dress_top_1);
		topDress2 = (ImageView) findViewById(R.id.select_dress_top_2);
		topDress3 = (ImageView) findViewById(R.id.select_dress_top_3); 

		bottomDress1 = (ImageView) findViewById(R.id.select_dress_bottom_1);
		bottomDress2 = (ImageView) findViewById(R.id.select_dress_bottom_2);
		bottomDress3 = (ImageView) findViewById(R.id.select_dress_bottom_3);
		
		btnSave = (Button) findViewById(R.id.btn_save);
		btnCancel = (Button) findViewById(R.id.btn_cancel);
		
		selectedCharName = sharedValues.getSelectedChar().trim();
		selectedTop = sharedValues.getCharacterTop();
		selectedBottom = sharedValues.getCharacterBottom();
		
		System.out.println("suztomize" + selectedCharName + ":" + selectedTop + ":" + selectedBottom);
		
		//===========SET OF CLOTHES
		//TODO insert here condition if boy or girl
		
		if (selectedCharName.equals("bug")) {
			selectedChar.setImageResource(R.drawable.char_bug_nude);
			topDressSelected.setImageResource(selectedTop); // default
			bottomDressSelected.setImageResource(selectedBottom); // default
			
			topDress1.setImageResource(R.drawable.bug_top1);
			topDress2.setImageResource(R.drawable.bug_top2);
			topDress3.setImageResource(R.drawable.bug_top3); 
			bottomDress1.setImageResource(R.drawable.bug_bottom1);
			bottomDress2.setImageResource(R.drawable.bug_bottom2);
			bottomDress3.setImageResource(R.drawable.bug_bottom3); 
		} else {
			selectedChar.setImageResource(R.drawable.char_tong_nude);
			topDressSelected.setImageResource(selectedTop); // default
			bottomDressSelected.setImageResource(selectedBottom); // default
			
			topDress1.setImageResource(R.drawable.tong_top1);
			topDress2.setImageResource(R.drawable.tong_top2);
			topDress3.setImageResource(R.drawable.tong_top3); 
			bottomDress1.setImageResource(R.drawable.tong_bottom1);
			bottomDress2.setImageResource(R.drawable.tong_bottom2);
			bottomDress3.setImageResource(R.drawable.tong_bottom3); 
		}
		
	}

	private void actions() {
		
		if (selectedCharName.equals("bug")) {
			topDress1.setOnClickListener(bugOnCLick);
			topDress2.setOnClickListener(bugOnCLick);
			topDress3.setOnClickListener(bugOnCLick); 
	
			bottomDress1.setOnClickListener(bugOnCLick);
			bottomDress2.setOnClickListener(bugOnCLick);
			bottomDress3.setOnClickListener(bugOnCLick); 
			
		}else{
			topDress1.setOnClickListener(tongOnCLick);
			topDress2.setOnClickListener(tongOnCLick);
			topDress3.setOnClickListener(tongOnCLick); 
	
			bottomDress1.setOnClickListener(tongOnCLick);
			bottomDress2.setOnClickListener(tongOnCLick);
			bottomDress3.setOnClickListener(tongOnCLick); 
		}
		
		btnSave.setOnClickListener(onCLick);
		btnCancel.setOnClickListener(onCLick);

	}

	OnClickListener tongOnCLick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {

			//TOP 
			case R.id.select_dress_top_1:			 
				setTop(R.drawable.tong_top1,R.drawable.gamescreen_tong1); break;
			case R.id.select_dress_top_2:
				setTop(R.drawable.tong_top2,R.drawable.gamescreen_tong2); break;
			case R.id.select_dress_top_3:
				setTop(R.drawable.tong_top3,R.drawable.gamescreen_tong3); break; 
				//BOTTOM 
				
			case R.id.select_dress_bottom_1:
				setBottom(R.drawable.tong_bottom1); break;
			case R.id.select_dress_bottom_2:
				setBottom(R.drawable.tong_bottom2); break;
			case R.id.select_dress_bottom_3:
				setBottom(R.drawable.tong_bottom3); break; 

			}

		}
	};
	
	OnClickListener bugOnCLick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {

			//TOP 
			case R.id.select_dress_top_1:			 
				setTop(R.drawable.bug_top1,R.drawable.gamescreen_bug1); break;
			case R.id.select_dress_top_2:
				setTop(R.drawable.bug_top2,R.drawable.gamescreen_bug2); break;
			case R.id.select_dress_top_3:
				setTop(R.drawable.bug_top3,R.drawable.gamescreen_bug3); break;
				
				//BOTTOM 
				
			case R.id.select_dress_bottom_1:
				setBottom(R.drawable.bug_bottom1); break;
			case R.id.select_dress_bottom_2:
				setBottom(R.drawable.bug_bottom2); break;
			case R.id.select_dress_bottom_3:
				setBottom(R.drawable.bug_bottom3); break;

			}
		}
	};
	
	OnClickListener onCLick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {

			case R.id.btn_save:
				//TODO insert here save the new looks
				sharedValues.setCharacterTop(selectedTop);
				sharedValues.setGameScreenCharacter(selectedGameScreen);
				sharedValues.setCharacterBottom(selectedBottom);
//				startActivity(new Intent(CustomizeCharacter.this, MainScreen.class));
//				finish();
				break;
				
			case R.id.btn_cancel:
//				startActivity(new Intent(CustomizeCharacter.this, MainScreen.class));
//				finish();
				break;
			}
			
			startIntentClass();

		}
	};
	
	private void setTop(int top, int gameScreenTop){
		topDressSelected.setImageResource(top);
		selectedTop = top;
		selectedGameScreen = gameScreenTop;
	}
	
	private void setBottom(int bottom){
		bottomDressSelected.setImageResource(bottom);
		selectedBottom = bottom;
	}
	
	
	public void onBackPressed() {
		startIntentClass();
		
	};
	
	private void startIntentClass(){
		startActivity(new Intent(CustomizeCharacter.this, MainScreen.class));
		System.gc();
	    Runtime.getRuntime().gc();  
		finish();
	}

}
