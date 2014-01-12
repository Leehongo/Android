package com.game.bugattong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.game.bugattong.pregame.MainScreen;

public class StoryView extends Activity {

	Button btnOk;
	TextView txtTitle, txtStory;
	String nextPage;
	
	
	String strInitial = "initial";
	String strLevel1 = "level1";
	String strLevel2 = "level2";
	String strLevel3 = "level3";
	String strLevel4 = "level4";
	String strLevel5 = "level5";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		setContentView(R.layout.story_view);
		super.onCreate(savedInstanceState);
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			nextPage = extras.getString("getNextPage");
		}
		
		initUI();

		btnOk.setOnClickListener(ocl);

	}
 
	private void initUI() {
		btnOk = (Button) findViewById(R.id.btn_ok);
		txtTitle = (TextView) findViewById(R.id.layout_title);
		txtStory = (TextView) findViewById(R.id.layout_story_text);
		
		if (nextPage.equals(strInitial)) {
			txtTitle.setText(getResources().getString(R.string.story_initial_title));
			txtStory.setText(getResources().getString(R.string.story_initial));
			
		}else if(nextPage.equals(strLevel1)) {
			txtTitle.setText(getResources().getString(R.string.story_level1_title));
			txtStory.setText(getResources().getString(R.string.story_level1));
			
		}else if(nextPage.equals(strLevel2)) {
			txtTitle.setText(getResources().getString(R.string.story_level2_title));
			txtStory.setText(getResources().getString(R.string.story_level2));
			
		}else if(nextPage.equals(strLevel3)) {
			txtTitle.setText(getResources().getString(R.string.story_level3_title));
			txtStory.setText(getResources().getString(R.string.story_level3));
			
		}else if(nextPage.equals(strLevel4)) {
			txtTitle.setText(getResources().getString(R.string.story_level4_title));
			txtStory.setText(getResources().getString(R.string.story_level4));
			
		}else if(nextPage.equals(strLevel5)) {
			txtTitle.setText(getResources().getString(R.string.story_level5_title));
			txtStory.setText(getResources().getString(R.string.story_level5));
			
		}
	}

	OnClickListener ocl = new OnClickListener() {

		@Override
		public void onClick(View v) {

			if (nextPage.equals(strInitial)) {
				startNewIntent(SelectLevel.class);
			}else{

				startNewIntent(GameActivity.class);
			}
		}
	};

	public void onBackPressed() {
		startNewIntent(MainScreen.class);

	};
	
	private void startNewIntent(Class s){
		
		startActivity(new Intent(StoryView.this, s));
		finish();
	}

}
