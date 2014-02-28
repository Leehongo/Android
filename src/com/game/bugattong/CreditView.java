package com.game.bugattong;

import com.game.bugattong.pregame.LoadingScreen;
import com.game.bugattong.settings.Constants;
import com.game.bugattong.settings.FileGenerator;
import com.game.bugattong.settings.GameSettings;
import com.game.bugattong.settings.SharedValues;
import com.game.bugattong.utilities.SaveUtility;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CreditView extends Activity {

	private SharedValues sharedValues;
	private SaveUtility saveUtility;
	private FileGenerator fileGenerator;
	private Button btnOk;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.credit_view);

		sharedValues = new SharedValues(CreditView.this);
		saveUtility = new SaveUtility(CreditView.this);
		fileGenerator = new FileGenerator();

		btnOk = (Button) findViewById(R.id.credit_btn_ok);
		btnOk.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				sharedValues.clearData();
				saveUtility.clearData();
				fileGenerator.removeFile(Constants.SELECTEDCHAR);
				GameSettings.init(CreditView.this, true);
				GameSettings.saveAll();

				startActivity(new Intent(CreditView.this, LoadingScreen.class));
				System.gc();
				Runtime.getRuntime().gc();
				finish();

			}
		});

	}

}
