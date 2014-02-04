package com.game.bugattong;

import com.game.bugattong.pregame.MainScreen;
import com.game.bugattong.settings.Constants;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class HelpMenu extends Activity {

	private ImageView imgViewImages;
	private Button btnNext, btnPrev;
	
	private int counter = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.help_view);
		super.onCreate(savedInstanceState);
		initUI();
	}

	private void initUI() {
		imgViewImages = (ImageView) findViewById(R.id.help_view_img);
		btnNext = (Button) findViewById(R.id.help_view_next);
		btnPrev = (Button) findViewById(R.id.help_view_prev);

		btnNext.setOnClickListener(ocl);
		btnPrev.setOnClickListener(ocl);

		imgViewImages.setBackgroundResource(Constants.HELPIMAGES[counter]);
	}

	OnClickListener ocl = new OnClickListener() {

		@Override
		public void onClick(View v) {

		 switch (v.getId()) {
			case R.id.help_view_next:
				
				if(counter < Constants.HELPIMAGES.length -1){
					btnPrev.setVisibility(View.VISIBLE);
					counter++;
					imgViewImages.setBackgroundResource(Constants.HELPIMAGES[counter]);
				}else{
					startIntentClass(MainScreen.class);
				}

				break;
			case R.id.help_view_prev:
				if(counter > 0){
					counter--;
					imgViewImages.setBackgroundResource(Constants.HELPIMAGES[counter]);
					
					if (counter == 0) 
						btnPrev.setVisibility(View.GONE);
				} 

				break;

			}

		}
		
	};
	
	public void onBackPressed() {
		super.onBackPressed();
		startIntentClass(MainScreen.class);
	}
	
	private void startIntentClass(Class intentClass){
		startActivity(new Intent(HelpMenu.this, intentClass));
		finish();
	}

}
