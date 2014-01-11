package com.game.bugattong.utilities;

import java.util.StringTokenizer;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.game.bugattong.settings.Constants;

public class SaveUtility {
	private static SharedPreferences gamePreferences = null;

	public SaveUtility(Activity act) {
		gamePreferences = act.getPreferences(act.MODE_PRIVATE);
	}

	private void saveString(String saveReference, String savedate) {
		Editor editor = gamePreferences.edit();
		editor.putString(saveReference, savedate);
		editor.commit();
	}

	private void saveInteger(int saveData, String saveReference) {
		Editor editor = gamePreferences.edit();
		editor.putInt(saveReference, saveData);
		editor.commit();
	}
	
	private void saveBoolean(boolean saveData, String saveReference){
		Editor editor = gamePreferences.edit();
		editor.putBoolean(saveReference, saveData);
		editor.commit();
	}

	public void saveUnlockedLevels(boolean[] levelLocked) {
		String savedata = "";
		for (int index = 0; index < levelLocked.length; index++) {
			if (levelLocked[index]) {
				savedata += "1|";
			} else {
				savedata += "0|";
			}
		}
		saveString(Constants.SAVEUNLOCKEDLEVELS, savedata);
	}

	public boolean[] getUnlockedLevels() {
		boolean[] savedata = new boolean[Constants.MAXLEVELS];
		String savestring = gamePreferences.getString(
				Constants.SAVEUNLOCKEDLEVELS, "");
		String temp = "";
		StringTokenizer st = new StringTokenizer(savestring, "|");

		int index = 0;
		while (st.hasMoreTokens() && index < Constants.MAXLEVELS) {
			temp = st.nextToken().toString();
			if (temp.equals("1")) {
				savedata[index] = true;
			} else {
				savedata[index] = false;
			}
			index++;
		}
		return savedata;
	}

	public void saveCurrentLevel(int currentLevel) {
		saveInteger(currentLevel, Constants.SAVECURRENTLEVEL);
	}

	public int getCurrentLevel() {
		return gamePreferences.getInt(Constants.SAVECURRENTLEVEL, 0);
	}

	public void saveCurrentPoints(int currentPoints) {
		saveInteger(currentPoints, Constants.SAVECURRENTPOINTS);
	}

	public int getCurrentPoints() {
		return gamePreferences.getInt(Constants.SAVECURRENTPOINTS, 0);
	}

	public void saveCurrentQuestion(int currentQuestion) {
		saveInteger(currentQuestion, Constants.SAVECURRENTQUESTION);
	}

	public int getCurrentQuestion() {
		return gamePreferences.getInt(Constants.SAVECURRENTQUESTION, 0);
	}

	public void saveUserHintedNumbers(boolean[][] userHintedNumbers) {
		String savedata = "";
		int level = 0;
		int question = 0;
		for (level = 0; level < Constants.MAXLEVELS; level++) {
			for (question = 0; question < Constants.MAXQUESTIONS; question++) {
				if (userHintedNumbers[level][question]) {
					savedata += "1|";
				} else {
					savedata += "0|";
				}
			}
			savedata += "_";
		}
		saveString(Constants.SAVEUSERHINTEDNUMBERS, savedata);
	}

	public boolean[][] getUserHintedNumbers() {
		boolean[][] savedata = new boolean[Constants.MAXLEVELS][Constants.MAXQUESTIONS];
		String savestring = gamePreferences.getString(
				Constants.SAVEUSERHINTEDNUMBERS, "");
		String temp = "";
		String temp2 = "";
		StringTokenizer st = new StringTokenizer(savestring, "_");
		int level = 0;
		int question = 0;

		while (st.hasMoreTokens()) {
			temp = st.nextToken().toString();
			question = 0;
			StringTokenizer st2 = new StringTokenizer(temp, "|");
			while (st2.hasMoreTokens()) {
				temp2 = st2.nextToken().toString();
				if (temp2.equals("1")) {
					savedata[level][question] = true;
				} else {
					savedata[level][question] = false;
				}
				question++;
			}
			level++;
		}
		return savedata;
	}

	public void saveUserCorrectAnswers(boolean[][] userCorrectAnswers) {
		String savedata = "";
		int level = 0;
		int question = 0;
		for (level = 0; level < Constants.MAXLEVELS; level++) {
			for (question = 0; question < Constants.MAXQUESTIONS; question++) {
				if (userCorrectAnswers[level][question]) {
					savedata += "1|";
				} else {
					savedata += "0|";
				}
			}
			savedata += "%";
		}
		saveString(Constants.SAVECORRECTANSWERS, savedata);
	}

	public boolean[][] getUserCorrectAnswers() {
		boolean[][] savedata = new boolean[Constants.MAXLEVELS][Constants.MAXQUESTIONS];
		String savestring = gamePreferences.getString(
				Constants.SAVECORRECTANSWERS, "");
		String temp = "";
		String temp2 = "";
		StringTokenizer st = new StringTokenizer(savestring, "%");

		int level = 0;
		int question = 0;
		while (st.hasMoreTokens() && level < Constants.MAXLEVELS) {
			temp = st.nextToken().toString();
			question = 0;
			StringTokenizer st2 = new StringTokenizer(temp, "|");
			while (st2.hasMoreTokens() && question < Constants.MAXQUESTIONS) {
				temp2 = st2.nextToken().toString();
				if (temp2.equals("1")) {
					savedata[level][question] = true;
				} else {
					savedata[level][question] = false;
				}
				question++;

			}
			level++;
		}
		return savedata;
	}

	public void saveUserHintedNumbersHintsShown(
			int[][] userHintedNumbersHintsShown) {

		String savedata = "";
		int level = 0;
		int question = 0;
		for (level = 0; level < Constants.MAXLEVELS; level++) {
			for (question = 0; question < Constants.MAXQUESTIONS; question++) {
				savedata += userHintedNumbersHintsShown[level][question] + "|";

			}
			savedata += "%";
		}
		saveString(Constants.SAVEUSERHINTEDNUMBERSHINTSSHOWS, savedata);
	}

	public int[][] getUserHintedNumbersHintsShown() {
		int[][] savedata = new int[Constants.MAXLEVELS][Constants.MAXQUESTIONS];
		String savestring = gamePreferences.getString(
				Constants.SAVEUSERHINTEDNUMBERSHINTSSHOWS, "");
		String temp = "";
		String temp2 = "";
		StringTokenizer st = new StringTokenizer(savestring, "%");

		int level = 0;
		int question = 0;
		while (st.hasMoreTokens() && level < Constants.MAXLEVELS) {
			temp = st.nextToken().toString();
			question = 0;
			StringTokenizer st2 = new StringTokenizer(temp, "|");
			while (st2.hasMoreTokens() && question < Constants.MAXQUESTIONS) {
				temp2 = st2.nextToken().toString();
				savedata[level][question] = Integer.parseInt(temp2);
				question++;
			}
			level++;
		}
		return savedata;
	}
	
	public void setInit(boolean value){
		saveBoolean(value, Constants.SAVEINIT);
	}
	
	public boolean isInit(){
		return gamePreferences.getBoolean(Constants.SAVEINIT, false);
	}
}