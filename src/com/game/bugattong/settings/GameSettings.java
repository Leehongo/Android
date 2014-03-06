package com.game.bugattong.settings;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.game.bugattong.GameActivity;
import com.game.bugattong.R;
import com.game.bugattong.model.LevelQuestion;
import com.game.bugattong.model.SearchObject;
import com.game.bugattong.utilities.SaveUtility;

public class GameSettings {
	public static LevelQuestion[][] levelQuestions = new LevelQuestion[Constants.MAXLEVELS][Constants.MAXQUESTIONS];
	public static SearchObject[][] levelSearchObjects = new SearchObject[Constants.MAXLEVELS][Constants.MAXQUESTIONS];
	public static boolean[][] userHintedNumbers = new boolean[Constants.MAXLEVELS][Constants.MAXQUESTIONS];
	public static int[][] userHintedNumbersHintsShown = new int[Constants.MAXLEVELS][Constants.MAXQUESTIONS];
	public static boolean[][] userCorrectAnswers = new boolean[Constants.MAXLEVELS][Constants.MAXQUESTIONS];
	public static int currentLevel = 0;
	public static int currentQuestion = 0;
	public static int currentPoints = 0;
	public static boolean hasInit = false;
	public static boolean[] levelLocked = new boolean[Constants.MAXLEVELS];
	public static boolean[] levelPlayed = new boolean[Constants.MAXLEVELS];
	public static boolean[] levelAllQuestionsAnswered = new boolean[Constants.MAXLEVELS];
	public static boolean bonusLevelLocked = true;
	public static int wrongClicks = 0;
	private static SaveUtility savegame;
	public static boolean hasAnsweredBonus = false;
	public static Integer[][] levelObjects = new Integer[Constants.MAXLEVELS][Constants.MAXQUESTIONS];


	public static void init(Activity act, boolean reset) {
		savegame = new SaveUtility(act);

		// load data
		if (!savegame.isInit() || reset) {
			for (int level = 0; level < Constants.MAXLEVELS; level++) {
				for (int question = 0; question < Constants.MAXQUESTIONS; question++) {
					userCorrectAnswers[level][question] = false;	// // test true
					userHintedNumbers[level][question] = false;
					userHintedNumbersHintsShown[level][question] = 0;
				}
				levelPlayed[level] = false;	// test true
				levelAllQuestionsAnswered[level] = false;// test true
			}

			levelLocked[0] = false;
			levelLocked[1] = true;// test false
			levelLocked[2] = true;// test false
			levelLocked[3] = true;// test false
			levelLocked[4] = true;// test false
			wrongClicks = 0;
			bonusLevelLocked = true;
			currentPoints = 100;
			hasAnsweredBonus = false;
			savegame.setInit(true);
			saveAll();

		} else {
			userHintedNumbers = savegame.getUserHintedNumbers();
			userCorrectAnswers = savegame.getUserCorrectAnswers();
			userHintedNumbersHintsShown = savegame.getUserHintedNumbersHintsShown();
			currentLevel = savegame.getCurrentLevel();
			levelLocked = savegame.getUnlockedLevels();
			currentQuestion = savegame.getCurrentQuestion();
			currentPoints = savegame.getCurrentPoints();
			bonusLevelLocked = savegame.getBonusLevel();
			levelPlayed = savegame.getPlayedLevel();
			levelAllQuestionsAnswered = savegame.getLevelAllQuestionsAnswered();
			hasAnsweredBonus = savegame.isBonusLevelAnswered();
		}

		levelQuestions[0][0] = new LevelQuestion(			//HARDIN
				"Takbo roon, takbo rito, hindi makaalis sa tayong ito.",
				"DUYAN", "4,1,0,3,2");
		levelQuestions[0][1] = new LevelQuestion(
				"Heto na si Lulong, bubulong bulong", "BUBUYOG",
				"6,1,4,0,2,3,5");
		levelQuestions[0][2] = new LevelQuestion(
				"Napapagod kung tumitigil, kung tumatakbo\'y gumigiliw.",
				"BISIKLETA", "6,8,4,3,7,1,0,2,5");
		levelQuestions[0][3] = new LevelQuestion(
				"Isang senyora nakaupo sa tasa.", "KASOY", "0,2,1,4,3");
		levelQuestions[0][4] = new LevelQuestion(
				"Mataas ang paupo, kesa patayo.", "ASO", "0,2,1");
		levelQuestions[0][5] = new LevelQuestion(
				"Ang ina\'y gumagapang pa, ang anak ay umuupo na.", "KALABASA",
				"0,2,5,4,3,1,7,6");
		levelQuestions[0][6] = new LevelQuestion(
				"Manok kong pula, inutusan ko ng umaga, nang umuwi\'y gabi na.",
				"ARAW", "3,1,0,2");
		levelQuestions[0][7] = new LevelQuestion(
				"Bulaklak muna ang dapat gawin, bago mo ito kainin.", "SAGING",
				"3,5,1,4,2,0");
		levelQuestions[0][8] = new LevelQuestion(
				"Nang sumipot sa maliwanag, kulubot na ang balat.", "AMPALAYA",
				"0,2,5,4,3,1,7,6");
		levelQuestions[0][9] = new LevelQuestion(
				"Hindi pari, hindi hari, nagdadamit ng sari-sari", "PARUPARO",
				"0,2,5,4,3,1,7,6");
		levelQuestions[0][10] = new LevelQuestion(
				"Pusong bibitin-bitin, mabango parang hasmin, \n masarap kainin.",
				"MANGGA", "3,5,1,3,2,0");
		levelQuestions[0][11] = new LevelQuestion(
				"Ang mukha\'y parang tao, magaling lumukso.", "UNGGOY",
				"3,5,1,4,2,0");
		levelQuestions[0][12] = new LevelQuestion(
				"Aso kong si pula, sumampa sa sanga, nagpakita ng ganda.",
				"GUMAMELA", "0,2,5,4,3,1,7,6");
		levelQuestions[0][13] = new LevelQuestion(
				"Ang puno\'y buku-buko,  ang sanga\'y baril, \n ang bunga ay bote, ang laman ay diyamante.",
				"PAPAYA", "3,5,1,4,2,0");
		levelQuestions[0][14] = new LevelQuestion(
				"Dumaing paa\'y walang kamay, may pamigkis sa baywang,\n ang ulo\'y parang tagayan, alagad ng kalinisan.",
				"WALIS-TINGTING", "10,1,0,6,4,7,12,1,3,9,5,13,8,2,11", true);

		// Question Level 2			- TULUGAN
		levelQuestions[1][0] = new LevelQuestion(
				"Alipin ng hari, hindi makalakad, kung hindi itali.",
				"SAPATOS", "6,1,4,0,2,3,5");
		levelQuestions[1][1] = new LevelQuestion(
				"Wala sa langit,wala sa lupa, kung lumakad ay patihaya.",
				"BANGKA", "3,5,1,4,2,0");
		levelQuestions[1][2] = new LevelQuestion(
				"Kung araw ay patung-patong, kung gabi\'y dugtong-dugtong.",
				"UNAN", "3,1,0,2");
		levelQuestions[1][3] = new LevelQuestion(
				"Hindi tao, hindi ibon, bumabalik kung itapon.", "YOYO",
				"3,1,0,2");
		levelQuestions[1][4] = new LevelQuestion(
				"Bumili ako ng alipin, mas mataas pa sa akin.", "SUMBRERO",
				"0,2,5,4,3,1,7,6");
		levelQuestions[1][5] = new LevelQuestion(
				"Ipinalilok ko at ipinalubid, naghigpitan ang kapit.",
				"SINTURON", "0,2,5,4,3,1,7,6");
		levelQuestions[1][6] = new LevelQuestion(
				"Dugtong-dugtong, magkakarugtong, tanikalang umuugong.",
				"TREN", "3,1,0,2");
		levelQuestions[1][7] = new LevelQuestion(
				"Nakalantay kung gabi, kung araw ay nakatabi.", "BANIG",
				"4,1,0,3,2");
		levelQuestions[1][8] = new LevelQuestion(
				"isang butil ng palay, buong bahay ay nakakalatan.", "ILAW",
				"4,1,0,3,2");
		levelQuestions[1][9] = new LevelQuestion(
				"Isa ang pasukan, tatlo ang labasan.", "KAMISETA",
				"0,2,5,4,3,1,7,6");
		levelQuestions[1][10] = new LevelQuestion(
				"Nang hawak ay patay, nang ihagis ay nabuhay.", "TRUMPO",
				"3,5,1,4,2,0");
		levelQuestions[1][11] = new LevelQuestion(
				"Isang biyas ng kawayan, maraming lamang kayamanan.",
				"ALKANSIYA", "0,2,4,8,3,5,7,1,6");
		levelQuestions[1][12] = new LevelQuestion(
				"Isang tingting na matigas, nang ikiskis namulaklak.",
				"POSPORO", "6,1,4,0,2,3,5");
		levelQuestions[1][13] = new LevelQuestion(
				"Hinila ko ang tadyang, lumapad ang tiyan.", "PAYONG",
				"3,5,1,4,2,0");
		levelQuestions[1][14] = new LevelQuestion(
				"Saranggolang naglalayag sa kalangitan,\n Napapalayo pa nito ang paglalakbay",
				"PISI", "3,1,0,2", true);

		// Question Level 3		-SALA
		levelQuestions[2][0] = new LevelQuestion(
				"Sa buhatan ay may silbi, sa igiban ay walang sinabi.",
				"BASKET", "3,5,1,4,2,0");
		levelQuestions[2][1] = new LevelQuestion(
				"Hindi halaman, maraming dahon, ang ibinubunga ay dunong.",
				"AKLAT", "4,1,0,3,2");
		levelQuestions[2][2] = new LevelQuestion(
				"Ngayon lang nangyayari, nakikita na ng marami, \n kahit sila\'y wala rine.",
				"TELEBISYON", "9,1,6,0,3,5,2,1,7,4");
		levelQuestions[2][3] = new LevelQuestion(
				"May katawa\'y walang bituka, may puwit walang paa, \n nakakagat tuwina.",
				"BASO", "3,1,0,2");
		levelQuestions[2][4] = new LevelQuestion(
				"Dalawang katawan, tagusan ang tadyang.", "HAGDANAN",
				"0,2,5,4,3,1,7,6");
		levelQuestions[2][5] = new LevelQuestion(
				"Dalawang ibong marikit, nagtitimbangan ng siit.", "HIKAW",
				"4,1,0,3,2");
		levelQuestions[2][6] = new LevelQuestion(
				"Munting tumataginting, kung saan nanggagaling.", "TELEPONO",
				"0,2,5,4,3,1,7,6");
		levelQuestions[2][7] = new LevelQuestion(
				"Bugtong kong sapin sapin, Nakasabit, nakabitin, \n Araw araw kung bilangin, Isang taon kung tapusin.",
				"KALENDARYO", "9,1,6,0,3,5,2,1,7,4");
		levelQuestions[2][8] = new LevelQuestion(
				"Hiyas akong mabilog, sa daliri isinusuot.", "SINGSING",
				"0,2,5,4,3,1,7,6");
		levelQuestions[2][9] = new LevelQuestion(
				"Walang hininga ay may buhay,  walang paa ay may kamay, \n mabilog na parang buwan, ang mukha\'y may bilang.",
				"ORASAN", "3,5,1,4,2,0");
		levelQuestions[2][10] = new LevelQuestion(
				"Binatak ko ang isa, pawis ang kasama.", "PANYO", "4,1,0,3,2");
		levelQuestions[2][11] = new LevelQuestion(
				"Walang paa, lumalakad, walang bibig, nangungusap, \n walang hindi hinaharap, may dala-dalang sulat.",
				"SOBRE", "4,1,0,3,2");
		levelQuestions[2][12] = new LevelQuestion(
				"Tumutugtuog, umaawit, walang pagod ang pagpihit.", "RADYO",
				"4,1,0,3,2");
		levelQuestions[2][13] = new LevelQuestion(
				"Sapagkat lahat na ay nakahihipo, walang kasindumi\'t walang kasimbaho, \n bakit mahal nati\'t ipinakatatago.",
				"SALAPI", "3,5,1,4,2,0");
		levelQuestions[2][14] = new LevelQuestion(
				"Tangan-tangan sa umaga, galaw ng bansa ay nakikita.",
				"DYARYO", "3,5,1,4,2,0", true);

		// Question Level 4			-KAGUBTAN
		levelQuestions[3][0] = new LevelQuestion(
				"Heto na si bayaw, dala-dala\'y ilaw.", "ALITAPTAP",
				"0,2,4,8,3,5,7,1,6");
		levelQuestions[3][1] = new LevelQuestion(
				"May ulo\'y walang buhok, may tiyan walang pusod.", "PALAKA",
				"3,5,1,4,2,0");
		levelQuestions[3][2] = new LevelQuestion(
				"Bahay ni Kahuli, haligi\'y bali-bali, ang bubong ay kawali.",
				"ALIMANGO", "0,2,5,4,3,1,7,6");
		levelQuestions[3][3] = new LevelQuestion(
				"Sa araw nahimhimbing, at sa gabi ay gising na gising.",
				"PANIKI", "3,5,1,4,2,0");
		levelQuestions[3][4] = new LevelQuestion(
				"Yumuko man ang reyna, di malalaglag ang korona.", "BAYABAS",
				"6,1,4,0,2,3,5");
		levelQuestions[3][5] = new LevelQuestion(
				"Langit sa itaas, langit sa ibaba, tubig sa gitna.", "NIYOG",
				"4,1,0,3,2");
		levelQuestions[3][6] = new LevelQuestion(
				"Baston ng kapitan, hindi mahawakan.", "AHAS", "3,1,0,2");
		levelQuestions[3][7] = new LevelQuestion(
				"Buhay na hindi kumikibo, patay na hindi bumabaho.", "BATO",
				"3,1,0,2");
		levelQuestions[3][8] = new LevelQuestion(
				"Isang hayop na maliit, dumudumi ng sinulid.", "GAGAMBA",
				"6,1,4,0,2,3,5");
		levelQuestions[3][9] = new LevelQuestion(
				"Isang dalagang may korona, kahit saan ay may mata.", "PINYA",
				"4,1,0,3,2");
		levelQuestions[3][10] = new LevelQuestion(
				"Nang sanggol pa ay palalo, mataas na langit ang itinuturo; \n nang lumaki at lumago, sa sariling puno ay yumuko.",
				"KAWAYAN", "6,1,4,0,2,3,5");
		levelQuestions[3][11] = new LevelQuestion(
				"Itinanim sa kagabihan, inani sa kaumagahan.", "BITUIN",
				"3,5,1,4,2,0");
		levelQuestions[3][12] = new LevelQuestion(
				"Isang pamalo-palo, libot na libot ng ginto.", "MAIS",
				"3,1,0,2");
		levelQuestions[3][13] = new LevelQuestion(
				"Balat berde, buto itim, laman pula, turingan mo kung sino siya.",
				"PAKWAN", "3,5,1,4,2,0");
		levelQuestions[3][14] = new LevelQuestion(
				"Sandata ng mga matalino, papel lamang ang hasaan.", "LAPIS",
				"4,1,0,3,2", true);

		// Question Level 5			- ATTIC
		levelQuestions[4][0] = new LevelQuestion(
				"Dumaan ang hari, nagkagatan ang mga pari.", "SIPER",
				"4,1,0,3,2");
		levelQuestions[4][1] = new LevelQuestion(
				"May katawan walang mukha, walang mata\'y lumuluha.",
				"KANDILA", "6,1,4,0,2,3,5");
		levelQuestions[4][2] = new LevelQuestion(
				"Nagsaing si Kurutong, kumulo\'y walang gatong.", "SABON",
				"4,1,0,3,2");
		levelQuestions[4][3] = new LevelQuestion(
				"Sa maling kalabit, may buhay na kapalit.", "BARIL",
				"4,1,0,3,2");
		levelQuestions[4][4] = new LevelQuestion(
				"Hindi tao, hindi hayop, kung uminom ay salup-salop.", "BATYA",
				"4,1,0,3,2");
		levelQuestions[4][5] = new LevelQuestion(
				"Ang ulo\'y nalalaga, ang katawa\'y pagala-gala.", "SANDOK",
				"3,5,1,4,2,0");
		levelQuestions[4][6] = new LevelQuestion(
				"Hinila ko ang baging, sumigaw ang matsing.", "KAMPANA",
				"6,1,4,0,2,3,5");
		levelQuestions[4][7] = new LevelQuestion(
				"Kadena\'y isinabit, sa batok nakakawit.", "KUWINTAS",
				"0,2,5,4,3,1,7,6");
		levelQuestions[4][8] = new LevelQuestion(
				"Itulak at hilahin, sigurado ang kain.", "LAGARI",
				"3,5,1,4,2,0");
		levelQuestions[4][9] = new LevelQuestion(
				"Instrumentong pangharana, higis nito ay katawan ng dalaga.",
				"GITARA", "3,5,1,4,2,0");
		levelQuestions[4][10] = new LevelQuestion(
				"Nagtago si Pedro, nakalitaw ang ulo.", "PAKO", "3,1,0,2");
		levelQuestions[4][11] = new LevelQuestion(
				"Isang maliit na impyerno, nagpapalabas ng magandang istilo.",
				"PLANTSA", "6,1,4,0,2,3,5");
		levelQuestions[4][12] = new LevelQuestion(
				"Isang tingting na matigas, nang ikiskis namumulaklak.",
				"POSPORO", "6,1,4,0,2,3,5");
		levelQuestions[4][13] = new LevelQuestion(
				"Aling mabuting retrato ang kuhang-kuha ang mukha mo?",
				"SALAMIN", "6,1,4,0,2,3,5");
		levelQuestions[4][14] = new LevelQuestion(
				"Dalawang magkaibigan, may talim ang tiyan; \n matagal ng nagkakagatan di pa nagkakasakitan.",
				"GUNTING", "6,1,4,0,2,3,5", true);

		
		switch (Constants.SCREENSIZE) {
		case SMALL:
			break;
		case NORMAL:
			setNormalImages();
			break;
		case LARGE:
			setLargeImages();
			break;
		case XLARGE:
			break;
 
		}
	}

	public static void setNormalImages(){
		System.out.println("NORMAL");
		
		// set image locations 
		setSizeLocation(0, 0, 0, 0, R.drawable.hardin_1_duyan, 300, 300); 	//HARDIN
		setSizeLocation(0, 1, 170, 05, R.drawable.hardin_2_bubuyog, 300, 300);
		setSizeLocation(0, 2, 230, 90, R.drawable.hardin_3_bisikleta, 300, 300);
		setSizeLocation(0, 3, 18, 15, R.drawable.hardin_4_kasoy, 300, 300);
		setSizeLocation(0, 4, 430, 90, R.drawable.hardin_5_aso, 300, 300);
		setSizeLocation(0, 5, 420, 250, R.drawable.hardin_6_kalabasa, 300, 300);
		setSizeLocation(0, 6, 90, 05, R.drawable.hardin_7_araw, 300, 300);
		setSizeLocation(0, 7, 500, 30, R.drawable.hardin_8_saging, 300, 300);
		setSizeLocation(0, 8, 315, 11, R.drawable.hardin_9_ampalaya, 300, 300);
		setSizeLocation(0, 9, 521, 90, R.drawable.hardin_10_paruparo, 300, 300);
		setSizeLocation(0, 10, 160, 180, R.drawable.hardin_11_mangga, 300, 300);
		setSizeLocation(0, 11, 620, 10, R.drawable.hardin_12_unggoy, 300, 300);
		setSizeLocation(0, 12, 140, 280, R.drawable.hardin_13_gumamela, 300, 300);
		setSizeLocation(0, 13, 492, 280, R.drawable.hardin_14_papaya, 300, 300);
		setSizeLocation(0, 14, 660, 110, R.drawable.hardin_15_walistingting, 300, 300);

		setSizeLocation(1, 0, 75, 15, R.drawable.tulugan_1_sapatos, 300, 300); 	//TULUGAN
		setSizeLocation(1, 1, 369, 210, R.drawable.tulugan_2_bangka, 300, 300);
		setSizeLocation(1, 2, 210, 60, R.drawable.tulugan_3_unan, 300, 300);
		setSizeLocation(1, 3, 627, 119, R.drawable.tulugan_4_yoyo, 300, 300);
		setSizeLocation(1, 4, 518, 23, R.drawable.tulugan_5_sumbrero, 300, 300);
		setSizeLocation(1, 5, 657, 180, R.drawable.tulugan_6_sinturon, 300, 300);
		setSizeLocation(1, 6, 252, 29, R.drawable.tulugan_7_tren, 300, 300);
		setSizeLocation(1, 7, 400, 10, R.drawable.tulugan_8_banig, 300, 300);
		setSizeLocation(1, 8, 350, 120, R.drawable.tulugan_9_ilaw, 300, 300);
		setSizeLocation(1, 9, 434, 137, R.drawable.tulugan_10_kamiseta, 300, 300);
		setSizeLocation(1, 10, 232, 173, R.drawable.tulugan_11_trumpo, 300, 300);
		setSizeLocation(1, 11, 194, 89, R.drawable.tulugan_12_alkansya, 300, 300);
		setSizeLocation(1, 12, 151, 30, R.drawable.tulugan_13_posporo, 300, 300);
		setSizeLocation(1, 13, 18, 24, R.drawable.tulugan_14_payong, 300, 300);
		setSizeLocation(1, 14, 500, 200, R.drawable.tulugan_15_pisi, 300, 300);

		setSizeLocation(2, 0, 158, 306, R.drawable.sala_1_basket, 300, 300);	// SALA
		setSizeLocation(2, 1, 350, 10, R.drawable.sala_2_aklat, 300, 300);	
		setSizeLocation(2, 2, 450, 177, R.drawable.sala_3_telebisyon, 300, 300);	
		setSizeLocation(2, 3, 158, 80, R.drawable.sala_4_baso, 300, 300);
		setSizeLocation(2, 4, 580, 167, R.drawable.sala_5_hagdan, 300, 300);
		setSizeLocation(2, 5, 130, 05, R.drawable.sala_6_hikaw, 300, 300);
		setSizeLocation(2, 6, 160, 179, R.drawable.sala_7_telepono, 300, 300);
		setSizeLocation(2, 7, 252, 181, R.drawable.sala_8_kalendaryo, 300, 300);
		setSizeLocation(2, 8, 268, 76, R.drawable.sala_9_singsing, 300, 300);
		setSizeLocation(2, 9, 28, 01, R.drawable.sala_10_orasan, 300, 300);
		setSizeLocation(2, 10, 616, 42, R.drawable.sala_11_panyo, 300, 300);
		setSizeLocation(2, 11, 303, 306, R.drawable.sala_12_sobre, 300, 300);
		setSizeLocation(2, 12, 428, 210, R.drawable.sala_13_radyo, 300, 300);
		setSizeLocation(2, 13, 630, 10, R.drawable.sala_14_salapi, 300, 300);
		setSizeLocation(2, 14, 519, 45, R.drawable.sala_15_dyaryo, 300, 300);

		setSizeLocation(3, 0, 1, 1, R.drawable.kagubatan_1_alitaptap, 300, 300);  //KAGUBATAN
		setSizeLocation(3, 1, 200, 164, R.drawable.kagubatan_2_palaka, 300, 300);
		setSizeLocation(3, 2, 530, 330, R.drawable.kagubatan_3_alimango, 300, 300);
		setSizeLocation(3, 3, 120, 20, R.drawable.kagubatan_4_paniki, 300, 300);
		setSizeLocation(3, 4, 220, 252, R.drawable.kagubatan_5_bayabas, 300, 300);
		setSizeLocation(3, 5, 390, 250, R.drawable.kagubatan_6_niyog, 300, 300);
		setSizeLocation(3, 6, 200, 306, R.drawable.kagubatan_7_ahas, 300, 300);
		setSizeLocation(3, 7, 610, 320, R.drawable.kagubatan_8_bato, 300, 300);
		setSizeLocation(3, 8, 410, 170, R.drawable.kagubatan_9_gagamba, 300, 300);
		setSizeLocation(3, 9, 580, 180, R.drawable.kagubatan_10_pinya, 300, 300);
		setSizeLocation(3, 10, 652, 01, R.drawable.kagubatan_11_kawayan, 300, 300);
		setSizeLocation(3, 11, 60, 20, R.drawable.kagubatan_12_bituin, 300, 300);
		setSizeLocation(3, 12, 550, 102, R.drawable.kagubatan_13_mais, 300, 300);
		setSizeLocation(3, 13, 410, 102, R.drawable.kagubatan_14_pakwan, 300, 300);
		setSizeLocation(3, 14, 320, 304, R.drawable.kagubatan_15_lapis, 300, 300);

		setSizeLocation(4, 0, 640, 111, R.drawable.attic_1_siper, 300, 300); //ATTIC
		setSizeLocation(4, 1, 630, 10, R.drawable.attic_2_kandila, 300, 300); 
		setSizeLocation(4, 2, 620, 100, R.drawable.attic_3_sabon, 300, 300);
		setSizeLocation(4, 3, 290, 204, R.drawable.attic_4_baril, 300, 300);
		setSizeLocation(4, 4, 50, 12, R.drawable.attic_5_batya, 300, 300);
		setSizeLocation(4, 5, 210, 10, R.drawable.attic_6_sandok, 300, 300);
		setSizeLocation(4, 6, 501, 20, R.drawable.attic_7_kampana, 300, 300);
		setSizeLocation(4, 7, 290, 313, R.drawable.attic_8_kwintas, 300, 300);
		setSizeLocation(4, 8, 10, 10, R.drawable.attic_9_lagari, 300, 300);
		setSizeLocation(4, 9, 470, 160, R.drawable.attic_10_gitara, 300, 300);
		setSizeLocation(4, 10, 330, 70, R.drawable.attic_11_pako, 300, 300);
		setSizeLocation(4, 11, 430, 207, R.drawable.attic_12_plantsa, 300, 300);
		setSizeLocation(4, 12, 450, 80, R.drawable.attic_13_posporo, 300, 300);
		setSizeLocation(4, 13, 540, 132, R.drawable.attic_14_salamin, 300, 300);
		setSizeLocation(4, 14, 420, 10, R.drawable.attic_15_gunting, 300, 300);
	}
	
	public static void setLargeImages(){

		System.out.println("LARGE");
		
		// set image locations 
		setSizeLocation(0, 0, 0, 0, R.drawable.hardin_1_duyan, 300, 300); 	//HARDIN
		setSizeLocation(0, 1, 170, 05, R.drawable.hardin_2_bubuyog, 300, 300);
		setSizeLocation(0, 2, 230, 90, R.drawable.hardin_3_bisikleta, 300, 300);
		setSizeLocation(0, 3, 18, 15, R.drawable.hardin_4_kasoy, 300, 300);
		setSizeLocation(0, 4, 430, 90, R.drawable.hardin_5_aso, 300, 300);
		setSizeLocation(0, 5, 420, 150, R.drawable.hardin_6_kalabasa, 300, 300);
		setSizeLocation(0, 6, 90, 05, R.drawable.hardin_7_araw, 300, 300);
		setSizeLocation(0, 7, 500, 30, R.drawable.hardin_8_saging, 300, 300);
		setSizeLocation(0, 8, 435, 11, R.drawable.hardin_9_ampalaya, 300, 300);
		setSizeLocation(0, 9, 521, 90, R.drawable.hardin_10_paruparo, 300, 300);
		setSizeLocation(0, 10, 580, 180, R.drawable.hardin_11_mangga, 300, 300);
		setSizeLocation(0, 11, 620, 10, R.drawable.hardin_12_unggoy, 300, 300);
		setSizeLocation(0, 12, 140, 170, R.drawable.hardin_13_gumamela, 300, 300);
		setSizeLocation(0, 13, 492, 150, R.drawable.hardin_14_papaya, 300, 300);
		setSizeLocation(0, 14, 660, 110, R.drawable.hardin_15_walistingting, 300, 300);

		setSizeLocation(1, 0, 45, 15, R.drawable.tulugan_1_sapatos, 300, 300); 	//TULUGAN
		setSizeLocation(1, 1, 369, 180, R.drawable.tulugan_2_bangka, 300, 300);
		setSizeLocation(1, 2, 210, 60, R.drawable.tulugan_3_unan, 300, 300);
		setSizeLocation(1, 3, 558, 119, R.drawable.tulugan_4_yoyo, 300, 300);
		setSizeLocation(1, 4, 518, 23, R.drawable.tulugan_5_sumbrero, 300, 300);
		setSizeLocation(1, 5, 617, 180, R.drawable.tulugan_6_sinturon, 300, 300);
		setSizeLocation(1, 6, 252, 29, R.drawable.tulugan_7_tren, 300, 300);
		setSizeLocation(1, 7, 400, 10, R.drawable.tulugan_8_banig, 300, 300);
		setSizeLocation(1, 8, 380, 120, R.drawable.tulugan_9_ilaw, 300, 300);
		setSizeLocation(1, 9, 434, 137, R.drawable.tulugan_10_kamiseta, 300, 300);
		setSizeLocation(1, 10, 232, 173, R.drawable.tulugan_11_trumpo, 300, 300);
		setSizeLocation(1, 11, 194, 89, R.drawable.tulugan_12_alkansya, 300, 300);
		setSizeLocation(1, 12, 151, 30, R.drawable.tulugan_13_posporo, 300, 300);
		setSizeLocation(1, 13, 18, 24, R.drawable.tulugan_14_payong, 300, 300);
		setSizeLocation(1, 14, 500, 140, R.drawable.tulugan_15_pisi, 300, 300);

		setSizeLocation(2, 0, 564, 110, R.drawable.sala_1_basket, 300, 300);	// SALA
		setSizeLocation(2, 1, 350, 10, R.drawable.sala_2_aklat, 300, 300);	
		setSizeLocation(2, 2, 400, 147, R.drawable.sala_3_telebisyon, 300, 300);	
		setSizeLocation(2, 3, 238, 80, R.drawable.sala_4_baso, 300, 300);
		setSizeLocation(2, 4, 580, 167, R.drawable.sala_5_hagdan, 300, 300);
		setSizeLocation(2, 5, 415, 15, R.drawable.sala_6_hikaw, 300, 300);
		setSizeLocation(2, 6, 371, 179, R.drawable.sala_7_telepono, 300, 300);
		setSizeLocation(2, 7, 252, 181, R.drawable.sala_8_kalendaryo, 300, 300);
		setSizeLocation(2, 8, 268, 76, R.drawable.sala_9_singsing, 300, 300);
		setSizeLocation(2, 9, 28, 01, R.drawable.sala_10_orasan, 300, 300);
		setSizeLocation(2, 10, 596, 42, R.drawable.sala_11_panyo, 300, 300);
		setSizeLocation(2, 11, 303, 206, R.drawable.sala_12_sobre, 300, 300);
		setSizeLocation(2, 12, 428, 210, R.drawable.sala_13_radyo, 300, 300);
		setSizeLocation(2, 13, 500, 10, R.drawable.sala_14_salapi, 300, 300);
		setSizeLocation(2, 14, 519, 45, R.drawable.sala_15_dyaryo, 300, 300);

		setSizeLocation(3, 0, 350, 165, R.drawable.kagubatan_1_alitaptap, 300, 300);  //KAGUBATAN
		setSizeLocation(3, 1, 200, 164, R.drawable.kagubatan_2_palaka, 300, 300);
		setSizeLocation(3, 2, 530, 220, R.drawable.kagubatan_3_alimango, 300, 300);
		setSizeLocation(3, 3, 190, 20, R.drawable.kagubatan_4_paniki, 300, 300);
		setSizeLocation(3, 4, 450, 202, R.drawable.kagubatan_5_bayabas, 300, 300);
		setSizeLocation(3, 5, 390, 200, R.drawable.kagubatan_6_niyog, 300, 300);
		setSizeLocation(3, 6, 200, 206, R.drawable.kagubatan_7_ahas, 300, 300);
		setSizeLocation(3, 7, 310, 20, R.drawable.kagubatan_8_bato, 300, 300);
		setSizeLocation(3, 8, 410, 140, R.drawable.kagubatan_9_gagamba, 300, 300);
		setSizeLocation(3, 9, 580, 180, R.drawable.kagubatan_10_pinya, 300, 300);
		setSizeLocation(3, 10, 452, 01, R.drawable.kagubatan_11_kawayan, 300, 300);
		setSizeLocation(3, 11, 280, 200, R.drawable.kagubatan_12_bituin, 300, 300);
		setSizeLocation(3, 12, 550, 102, R.drawable.kagubatan_13_mais, 300, 300);
		setSizeLocation(3, 13, 410, 102, R.drawable.kagubatan_14_pakwan, 300, 300);
		setSizeLocation(3, 14, 320, 254, R.drawable.kagubatan_15_lapis, 300, 300);

		setSizeLocation(4, 0, 580, 111, R.drawable.attic_1_siper, 300, 300); //ATTIC
		setSizeLocation(4, 1, 570, 10, R.drawable.attic_2_kandila, 300, 300); 
		setSizeLocation(4, 2, 620, 100, R.drawable.attic_3_sabon, 300, 300);
		setSizeLocation(4, 3, 290, 204, R.drawable.attic_4_baril, 300, 300);
		setSizeLocation(4, 4, 350, 12, R.drawable.attic_5_batya, 300, 300);
		setSizeLocation(4, 5, 210, 10, R.drawable.attic_6_sandok, 300, 300);
		setSizeLocation(4, 6, 501, 20, R.drawable.attic_7_kampana, 300, 300);
		setSizeLocation(4, 7, 290, 213, R.drawable.attic_8_kwintas, 300, 300);
		setSizeLocation(4, 8, 10, 10, R.drawable.attic_9_lagari, 300, 300);
		setSizeLocation(4, 9, 470, 160, R.drawable.attic_10_gitara, 300, 300);
		setSizeLocation(4, 10, 330, 217, R.drawable.attic_11_pako, 300, 300);
		setSizeLocation(4, 11, 430, 207, R.drawable.attic_12_plantsa, 300, 300);
		setSizeLocation(4, 12, 450, 48, R.drawable.attic_13_posporo, 300, 300);
		setSizeLocation(4, 13, 540, 132, R.drawable.attic_14_salamin, 300, 300);
		setSizeLocation(4, 14, 420, 10, R.drawable.attic_15_gunting, 300, 300);
	}
	
	
	private static void setSizeLocation(int itemX, int itemY, int locX, int locY, int objectImage,int hSize, int wSize){
		
		levelSearchObjects[itemX][itemY] = new SearchObject(locX, locY);
		levelObjects[itemX][itemY] = new Integer(objectImage);
	}
	
	
	public static void saveAll() {
		savegame.saveCurrentPoints(100);
		savegame.saveCurrentLevel(currentLevel);
		savegame.saveCurrentQuestion(currentQuestion);
		savegame.saveUnlockedLevels(levelLocked);
		savegame.saveUserCorrectAnswers(userCorrectAnswers);
		savegame.saveUserHintedNumbers(userHintedNumbers);
		savegame.saveUserHintedNumbersHintsShown(userHintedNumbersHintsShown);
		savegame.saveBonusLevel(bonusLevelLocked);
		savegame.saveLevelAllQuestionsAnswered(levelAllQuestionsAnswered);
		savegame.savePlayedLevel(levelPlayed);
		savegame.saveBonusLevelAnswered(hasAnsweredBonus);
	}

	public static void CustomTextView(Context context, View textView) {
		Typeface font = Typeface.createFromAsset(context.getAssets(),"BADABB__.TTF");
		((TextView) textView).setTypeface(font);

	}
}
