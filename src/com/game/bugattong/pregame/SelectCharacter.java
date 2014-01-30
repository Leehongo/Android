package com.game.bugattong.pregame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.game.bugattong.R;
import com.game.bugattong.settings.FileGenerator;
import com.game.bugattong.settings.SharedValues;

public class SelectCharacter extends Activity {

	private ImageView imgViewBug, imgViewTong;
	private SharedValues sharedValues;
	private FileGenerator fileGenerator;
	

	private final String SELECTEDCHAR = "/data/data/com.game.bugattong/files/character/selectedChar";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		setContentView(R.layout.loading_select_character);
		super.onCreate(savedInstanceState);
		initUI();
		
		sharedValues = new SharedValues(getApplicationContext());
		fileGenerator = new FileGenerator();
	}

	private void initUI() {

		imgViewBug = (ImageView) findViewById(R.id.select_char_img_bug);
		imgViewTong = (ImageView) findViewById(R.id.select_char_img_tong);

	}

	@Override
	protected void onStart() {
		imgViewBug.setOnClickListener(ocl);
		imgViewTong.setOnClickListener(ocl);

		super.onStart();
	}
	
	android.view.View.OnClickListener ocl = new View.OnClickListener() {
		
		@Override
			public void onClick(View v) {
	
				switch (v.getId()) {
	
				case R.id.select_char_img_bug:
					fileGenerator.writeFile(SELECTEDCHAR, "bug");
					sharedValues.setSelectedChar("bug");
					sharedValues.setCharacterTop(R.drawable.bug_top1);
					sharedValues.setGameScreenCharacter(R.drawable.gamescreen_bug1);
					sharedValues.setCharacterBottom(R.drawable.bug_bottom1);
					startActivity(new Intent(SelectCharacter.this, MainScreen.class));
					finish();
					break;
	
				case R.id.select_char_img_tong:
					fileGenerator.writeFile(SELECTEDCHAR, "tong");
					sharedValues.setSelectedChar("tong");
					sharedValues.setCharacterTop(R.drawable.tong_top1);
					sharedValues.setGameScreenCharacter(R.drawable.gamescreen_tong1);
					sharedValues.setCharacterBottom(R.drawable.tong_bottom1);
					startActivity(new Intent(SelectCharacter.this, MainScreen.class));
					finish();
					break;
	
				default:
					break;
				}
		}
	};


}
