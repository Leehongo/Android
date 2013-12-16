package com.game.bugattong.settings;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.game.bugattong.R;

public class SharedValues {
	
	private Context mContext;

	private SharedPreferences sharedPreferences;
	int prefMode = Activity.MODE_PRIVATE;

	public SharedValues(Context context) {
		this.mContext = context;
		sharedPreferences = mContext.getSharedPreferences("MY_PREFS", prefMode);
	}

	public void setSelectedChar(String myChar){
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString("getSelectedChar", myChar).commit();
	}

	
	public String getSelectedChar(){
		return sharedPreferences.getString("getSelectedChar", "");
	}

}
