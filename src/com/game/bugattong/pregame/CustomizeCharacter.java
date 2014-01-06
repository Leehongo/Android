package com.game.bugattong.pregame;

import com.game.bugattong.R;
import com.game.bugattong.R.color;
import com.game.bugattong.R.id;
import com.game.bugattong.R.layout;
import com.game.bugattong.settings.SharedValues;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class CustomizeCharacter extends Activity {

	private ImageView selectedChar, topDressSelected, bottomDressSelected;
	private ImageView topDress1, topDress2, topDress3;
	private ImageView bottomDress1, bottomDress2, bottomDress3;
	private Button btnSave, btnCancel;
	
	private String selectedCharName;
	
	private SharedValues sharedValues;
	
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.customize_character);
		super.onCreate(savedInstanceState);
		sharedValues = new SharedValues(getApplicationContext());
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
		
		selectedCharName = sharedValues.getSelectedChar();
		
		//===========SET OF CLOTHES
		//TODO insert here condition if boy or girl
		
		if (selectedCharName.equals("bug")) {
			selectedChar.setImageResource(R.drawable.char_bug_nude);
			
			topDressSelected.setImageResource(R.drawable.bug_top1); // default
			topDress1.setImageResource(R.drawable.bug_top1);
			topDress2.setImageResource(R.drawable.bug_top2);
			topDress3.setImageResource(R.drawable.bug_top3); 
			
			bottomDressSelected.setImageResource(R.drawable.bug_bottom1); // default
			bottomDress1.setImageResource(R.drawable.bug_bottom1);
			bottomDress2.setImageResource(R.drawable.bug_bottom2);
			bottomDress3.setImageResource(R.drawable.bug_bottom3); 
		} else {
			selectedChar.setImageResource(R.drawable.char_tong_nude);
			
			topDressSelected.setImageResource(R.drawable.tong_top1); // default
			topDress1.setImageResource(R.drawable.tong_top1);
			topDress2.setImageResource(R.drawable.tong_top2);
			topDress3.setImageResource(R.drawable.tong_top3); 
			
			bottomDressSelected.setImageResource(R.drawable.tong_bottom1); // default
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
				topDressSelected.setImageResource(R.drawable.tong_top1);
				break;
			case R.id.select_dress_top_2:
				topDressSelected.setImageResource(R.drawable.tong_top2);
				break;
			case R.id.select_dress_top_3:
				topDressSelected.setImageResource(R.drawable.tong_top3);
				break; 
				
				//BOTTOM 
				
			case R.id.select_dress_bottom_1:
				bottomDressSelected.setImageResource(R.drawable.tong_bottom1);
				break;
			case R.id.select_dress_bottom_2:
				bottomDressSelected.setImageResource(R.drawable.tong_bottom2);
				break;
			case R.id.select_dress_bottom_3:
				bottomDressSelected.setImageResource(R.drawable.tong_bottom3);
				break; 

			case R.id.btn_save:
				//TODO insert here save the new looks
				startActivity(new Intent(CustomizeCharacter.this, MainScreen.class));
				finish();
				break;
				

			case R.id.btn_cancel:
				startActivity(new Intent(CustomizeCharacter.this, MainScreen.class));
				finish();
				break;
			}

		}
	};
	
	OnClickListener bugOnCLick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {

			//TOP 
			case R.id.select_dress_top_1:			 
				topDressSelected.setImageResource(R.drawable.bug_top1);
				break;
			case R.id.select_dress_top_2:
				topDressSelected.setImageResource(R.drawable.bug_top2);
				break;
			case R.id.select_dress_top_3:
				topDressSelected.setImageResource(R.drawable.bug_top3);
				break; 
				
				//BOTTOM 
				
			case R.id.select_dress_bottom_1:
				bottomDressSelected.setImageResource(R.drawable.bug_bottom1);
				break;
			case R.id.select_dress_bottom_2:
				bottomDressSelected.setImageResource(R.drawable.bug_bottom2);
				break;
			case R.id.select_dress_bottom_3:
				bottomDressSelected.setImageResource(R.drawable.bug_bottom3);
				break; 

			case R.id.btn_save:
				//TODO insert here save the new looks
				startActivity(new Intent(CustomizeCharacter.this, MainScreen.class));
				finish();
				break;
				
			case R.id.btn_cancel:
				startActivity(new Intent(CustomizeCharacter.this, MainScreen.class));
				finish();
				break;
			}
		}
	};
	
	OnClickListener onCLick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {


			case R.id.btn_save:
				//TODO insert here save the new looks
				startActivity(new Intent(CustomizeCharacter.this, MainScreen.class));
				finish();
				break;
				
			case R.id.btn_cancel:
				startActivity(new Intent(CustomizeCharacter.this, MainScreen.class));
				finish();
				break;
			}

		}
	};
	
	
	
	
	public void onBackPressed() {

		startActivity(new Intent(CustomizeCharacter.this, MainScreen.class));
		finish();
		
	};

}
