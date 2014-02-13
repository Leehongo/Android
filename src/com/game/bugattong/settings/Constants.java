package com.game.bugattong.settings;

import com.game.bugattong.R;


/*
 *	01072014 added MAXANSWERTOUNLOCK
 */

public class Constants {
	public static final int CORRECTPOINT = 10;
	public static final int HINTPENALTYPOINTS = 20;
	public static final int WRONGCLICKPENALTYPOINTS = 15;
	public static final int WRONGCLICKPENALTYCOUNT= 5;
	public static final int STARTINGPOINTS = 100;
	public static final int MAXLEVELS = 5;
	public static final int MAXQUESTIONS = 15;
	public static final int MAXANSWERTOUNLOCK = 10;
	
	public static final String SAVEUSERHINTEDNUMBERS = "shownhints";
	public static final String SAVEUSERHINTEDNUMBERSHINTSSHOWS = "numderofshownhints";
	public static final String SAVECORRECTANSWERS = "correctanswers";
	public static final String SAVECURRENTLEVEL = "currentlevel";
	public static final String SAVECURRENTPOINTS = "currentpoints";
	public static final String SAVEUNLOCKEDLEVELS = "levellocked";
	public static final String SAVECURRENTQUESTION = "currentquestion";
	
	public static final String SAVESOUND = "soundstate";
	public static final String SAVEINIT = "hasBeenSaved";
	public static final String SAVEBONUSLEVEL ="bonuslevel";
	public static final String SAVEBONUSLEVELANSWERED ="hasAnsweredBonus";
	
	public static final String PLAYEDLEVEL ="levelPlayed";
	public static final String ANSWEREDALLQUESTIONINLEVEL ="levelAllQuestionsAnswered";

	public static boolean isSoundOn;
	
	public static int BTNQUESTIONCOUNTER = 0;
	
	public static int UNLOCKLEVELIMAGEDIALOG[] = {R.drawable.lvl_btn_silid_tulugan,R.drawable.lvl_btn_sala
			,R.drawable.lvl_btn_kagubatan,R.drawable.lvl_btn_attic};
	
	public static int LEVEL1OBJECTS[] = {R.drawable.hardin_1_duyan,R.drawable.hardin_2_bubuyog,R.drawable.hardin_3_bisikleta,R.drawable.hardin_4_kasoy,R.drawable.hardin_5_aso
		,R.drawable.hardin_6_kalabasa,R.drawable.hardin_7_araw,R.drawable.hardin_8_saging,R.drawable.hardin_9_ampalaya,R.drawable.hardin_10_paruparo
		,R.drawable.hardin_11_mangga,R.drawable.hardin_12_unggoy,R.drawable.hardin_13_gumamela,R.drawable.hardin_14_papaya,R.drawable.hardin_15_walistingting };	
	
	public static int LEVEL2OBJECTS[] = {R.drawable.tulugan_1_sapatos,R.drawable.tulugan_2_bangka,R.drawable.tulugan_3_unan,R.drawable.tulugan_4_yoyo,R.drawable.tulugan_5_sumbrero
		,R.drawable.tulugan_6_sinturon,R.drawable.tulugan_7_tren,R.drawable.tulugan_8_banig,R.drawable.tulugan_9_ilaw,R.drawable.tulugan_10_kamiseta
		,R.drawable.tulugan_11_trumpo,R.drawable.tulugan_12_alkansya,R.drawable.tulugan_13_posporo,R.drawable.tulugan_14_payong,R.drawable.tulugan_15_pisi };

	public static int LEVEL3OBJECTS[] = {R.drawable.sala_1_basket,R.drawable.sala_2_aklat,R.drawable.sala_3_telebisyon,R.drawable.sala_4_baso,R.drawable.sala_5_hagdan
		,R.drawable.sala_6_hikaw,R.drawable.sala_7_telepono,R.drawable.sala_8_kalendaryo,R.drawable.sala_9_singsing,R.drawable.sala_10_orasan
		,R.drawable.sala_11_panyo,R.drawable.sala_12_sobre,R.drawable.sala_13_radyo,R.drawable.sala_14_salapi,R.drawable.sala_15_dyaryo };

	public static int LEVEL4OBJECTS[] = {R.drawable.kagubatan_1_alitaptap,R.drawable.kagubatan_2_palaka,R.drawable.kagubatan_3_alimango,R.drawable.kagubatan_4_paniki,R.drawable.kagubatan_5_bayabas
		,R.drawable.kagubatan_6_niyog,R.drawable.kagubatan_7_ahas,R.drawable.kagubatan_8_bato,R.drawable.kagubatan_9_gagamba,R.drawable.kagubatan_10_pinya
		,R.drawable.kagubatan_11_kawayan,R.drawable.kagubatan_12_bituin,R.drawable.kagubatan_13_mais,R.drawable.kagubatan_14_pakwan,R.drawable.kagubatan_15_lapis };

	public static int LEVEL5OBJECTS[] = {R.drawable.attic_1_siper,R.drawable.attic_2_kandila,R.drawable.attic_3_sabon,R.drawable.attic_4_baril,R.drawable.attic_5_batya
		,R.drawable.attic_6_sandok,R.drawable.attic_7_kampana,R.drawable.attic_8_kwintas,R.drawable.attic_9_lagari,R.drawable.attic_10_gitara
		,R.drawable.attic_11_pako,R.drawable.attic_12_plantsa,R.drawable.attic_13_posporo,R.drawable.attic_14_salamin,R.drawable.attic_15_gunting };
	
	public static int HELPIMAGES[] = {R.drawable.help1,R.drawable.help2};
	
}
