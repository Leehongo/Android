package com.game.bugattong.settings;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.game.bugattong.R;

public class SharedValues {
	
	private Context mContext;

	private SharedPreferences sharedPreferences;
	int prefMode = Activity.MODE_PRIVATE;

	public SharedValues(Context context) {
		this.mContext = context;
		sharedPreferences = mContext.getSharedPreferences("MY_PREFS", prefMode);
	}

	public void clearData() {
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.clear();
		editor.commit();
	}
	
	public void setSelectedChar(String myChar){
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString("getSelectedChar", myChar).commit();
	}
	
	public void setCharacterTop(int top){
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putInt("getCharacterTop", top).commit();
	}
	public void setCharacterBottom(int bottom){
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putInt("getCharacterBottom", bottom).commit();
	}

	public String getSelectedChar(){
		return sharedPreferences.getString("getSelectedChar", "");
	}
	
	public int getCharacterTop(){
		return sharedPreferences.getInt("getCharacterTop", 0);
	}
	public int getCharacterBottom(){
		return sharedPreferences.getInt("getCharacterBottom", 0);
	}
	
	

}
