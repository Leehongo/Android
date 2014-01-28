package com.game.bugattong.settings;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

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

		// set image locations
		levelSearchObjects[0][0] = new SearchObject(250, 10);		//HARDIN
		levelSearchObjects[0][1] = new SearchObject(170, 05);
		levelSearchObjects[0][2] = new SearchObject(230, 90);
		levelSearchObjects[0][3] = new SearchObject(18, 15);
		levelSearchObjects[0][4] = new SearchObject(430, 90);
		levelSearchObjects[0][5] = new SearchObject(420, 150);
		levelSearchObjects[0][6] = new SearchObject(90, 05);
		levelSearchObjects[0][7] = new SearchObject(500, 30);
		levelSearchObjects[0][8] = new SearchObject(435, 11);
		levelSearchObjects[0][9] = new SearchObject(521, 90);
		levelSearchObjects[0][10] = new SearchObject(580, 180);
		levelSearchObjects[0][11] = new SearchObject(620, 10);
		levelSearchObjects[0][12] = new SearchObject(140, 170);
		levelSearchObjects[0][13] = new SearchObject(492, 150);
		levelSearchObjects[0][14] = new SearchObject(660, 110);

		levelSearchObjects[1][0] = new SearchObject(45, 15);	//TULUGAN
		levelSearchObjects[1][1] = new SearchObject(369, 180);
		levelSearchObjects[1][2] = new SearchObject(210, 60);
		levelSearchObjects[1][3] = new SearchObject(558, 119);
		levelSearchObjects[1][4] = new SearchObject(518, 23);
		levelSearchObjects[1][5] = new SearchObject(617, 180);
		levelSearchObjects[1][6] = new SearchObject(252, 29);
		levelSearchObjects[1][7] = new SearchObject(400, 10);
		levelSearchObjects[1][8] = new SearchObject(380, 120);
		levelSearchObjects[1][9] = new SearchObject(434, 137);
		levelSearchObjects[1][10] = new SearchObject(232, 173);
		levelSearchObjects[1][11] = new SearchObject(194, 89);
		levelSearchObjects[1][12] = new SearchObject(151, 30);
		levelSearchObjects[1][13] = new SearchObject(18, 24);
		levelSearchObjects[1][14] = new SearchObject(500, 140);

		levelSearchObjects[2][0] = new SearchObject(564, 110);	// SALA
		levelSearchObjects[2][1] = new SearchObject(350, 10);
		levelSearchObjects[2][2] = new SearchObject(400, 147);
		levelSearchObjects[2][3] = new SearchObject(238, 80);
		levelSearchObjects[2][4] = new SearchObject(580, 167);
		levelSearchObjects[2][5] = new SearchObject(415, 15);
		levelSearchObjects[2][6] = new SearchObject(371, 179);
		levelSearchObjects[2][7] = new SearchObject(252, 181);
		levelSearchObjects[2][8] = new SearchObject(268, 76);
		levelSearchObjects[2][9] = new SearchObject(28, 01);
		levelSearchObjects[2][10] = new SearchObject(246, 42);
		levelSearchObjects[2][11] = new SearchObject(303, 206);
		levelSearchObjects[2][12] = new SearchObject(428, 210);
		levelSearchObjects[2][13] = new SearchObject(500, 10);
		levelSearchObjects[2][14] = new SearchObject(519, 45);

		levelSearchObjects[3][0] = new SearchObject(350, 165);	//KAGUBATAN
		levelSearchObjects[3][1] = new SearchObject(200, 164);
		levelSearchObjects[3][2] = new SearchObject(530, 220);
		levelSearchObjects[3][3] = new SearchObject(190, 20);
		levelSearchObjects[3][4] = new SearchObject(450, 202);
		levelSearchObjects[3][5] = new SearchObject(390, 200);
		levelSearchObjects[3][6] = new SearchObject(200, 206);
		levelSearchObjects[3][7] = new SearchObject(310, 20);
		levelSearchObjects[3][8] = new SearchObject(410, 140);
		levelSearchObjects[3][9] = new SearchObject(580, 180);
		levelSearchObjects[3][10] = new SearchObject(452, 01);
		levelSearchObjects[3][11] = new SearchObject(280, 200);
		levelSearchObjects[3][12] = new SearchObject(550, 102);
		levelSearchObjects[3][13] = new SearchObject(410, 102);
		levelSearchObjects[3][14] = new SearchObject(320, 254);

		levelSearchObjects[4][0] = new SearchObject(580, 111);	//ATTIC
		levelSearchObjects[4][1] = new SearchObject(570, 10);
		levelSearchObjects[4][2] = new SearchObject(620, 100);
		levelSearchObjects[4][3] = new SearchObject(290,204);
		levelSearchObjects[4][4] = new SearchObject(350, 12);
		levelSearchObjects[4][5] = new SearchObject(210, 10);
		levelSearchObjects[4][6] = new SearchObject(501, 20); //
		levelSearchObjects[4][7] = new SearchObject(290, 123);
		levelSearchObjects[4][8] = new SearchObject(10, 10);
		levelSearchObjects[4][9] = new SearchObject(470, 160);
		levelSearchObjects[4][10] = new SearchObject(330, 217);
		levelSearchObjects[4][11] = new SearchObject(430, 207);
		levelSearchObjects[4][12] = new SearchObject(450, 48);
		levelSearchObjects[4][13] = new SearchObject(540, 132);
		levelSearchObjects[4][14] = new SearchObject(420, 10);//
		
		
		levelObjects[0][0] = new Integer(R.drawable.hardin_1_duyan);
		levelObjects[0][1] = new Integer(R.drawable.hardin_2_bubuyog);
		levelObjects[0][2] = new Integer(R.drawable.hardin_3_bisikleta);
		levelObjects[0][3] = new Integer(R.drawable.hardin_4_kasoy);
		levelObjects[0][4] = new Integer(R.drawable.hardin_5_aso);
		levelObjects[0][5] = new Integer(R.drawable.hardin_6_kalabasa);
		levelObjects[0][6] = new Integer(R.drawable.hardin_7_araw);
		levelObjects[0][7] = new Integer(R.drawable.hardin_8_saging);
		levelObjects[0][8] = new Integer(R.drawable.hardin_9_ampalaya);
		levelObjects[0][9] = new Integer(R.drawable.hardin_10_paruparo);
		levelObjects[0][10] = new Integer(R.drawable.hardin_11_mangga);
		levelObjects[0][11] = new Integer(R.drawable.hardin_12_unggoy);
		levelObjects[0][12] = new Integer(R.drawable.hardin_13_gumamela);
		levelObjects[0][13] = new Integer(R.drawable.hardin_14_papaya);
		levelObjects[0][14] = new Integer(R.drawable.hardin_15_walistingting);
		
		levelObjects[1][0] = new Integer(R.drawable.tulugan_1_sapatos);
		levelObjects[1][1] = new Integer(R.drawable.tulugan_2_bangka);
		levelObjects[1][2] = new Integer(R.drawable.tulugan_3_unan);
		levelObjects[1][3] = new Integer(R.drawable.tulugan_4_yoyo);
		levelObjects[1][4] = new Integer(R.drawable.tulugan_5_sumbrero);
		levelObjects[1][5] = new Integer(R.drawable.tulugan_6_sinturon);
		levelObjects[1][6] = new Integer(R.drawable.tulugan_7_tren);
		levelObjects[1][7] = new Integer(R.drawable.tulugan_8_banig);
		levelObjects[1][8] = new Integer(R.drawable.tulugan_9_ilaw);
		levelObjects[1][9] = new Integer(R.drawable.tulugan_10_kamiseta);
		levelObjects[1][10] = new Integer(R.drawable.tulugan_11_trumpo);
		levelObjects[1][11] = new Integer(R.drawable.tulugan_12_alkansya);
		levelObjects[1][12] = new Integer(R.drawable.tulugan_13_posporo);
		levelObjects[1][13] = new Integer(R.drawable.tulugan_14_payong);
		levelObjects[1][14] = new Integer(R.drawable.tulugan_15_pisi);
		
		levelObjects[2][0] = new Integer(R.drawable.sala_1_basket);
		levelObjects[2][1] = new Integer(R.drawable.sala_2_aklat);
		levelObjects[2][2] = new Integer(R.drawable.sala_3_telebisyon);
		levelObjects[2][3] = new Integer(R.drawable.sala_4_baso);
		levelObjects[2][4] = new Integer(R.drawable.sala_5_hagdan);
		levelObjects[2][5] = new Integer(R.drawable.sala_6_hikaw);
		levelObjects[2][6] = new Integer(R.drawable.sala_7_telepono);
		levelObjects[2][7] = new Integer(R.drawable.sala_8_kalendaryo);
		levelObjects[2][8] = new Integer(R.drawable.sala_9_singsing);
		levelObjects[2][9] = new Integer(R.drawable.sala_10_orasan);
		levelObjects[2][10] = new Integer(R.drawable.sala_11_panyo);
		levelObjects[2][11] = new Integer(R.drawable.sala_12_sobre);
		levelObjects[2][12] = new Integer(R.drawable.sala_13_radyo);
		levelObjects[2][13] = new Integer(R.drawable.sala_14_salapi);
		levelObjects[2][14] = new Integer(R.drawable.sala_15_dyaryo);

		levelObjects[3][0] = new Integer(R.drawable.kagubatan_1_alitaptap);
		levelObjects[3][1] = new Integer(R.drawable.kagubatan_2_palaka);
		levelObjects[3][2] = new Integer(R.drawable.kagubatan_3_alimango);
		levelObjects[3][3] = new Integer(R.drawable.kagubatan_4_paniki);
		levelObjects[3][4] = new Integer(R.drawable.kagubatan_5_bayabas);
		levelObjects[3][5] = new Integer(R.drawable.kagubatan_6_niyog);
		levelObjects[3][6] = new Integer(R.drawable.kagubatan_7_ahas);
		levelObjects[3][7] = new Integer(R.drawable.kagubatan_8_bato);
		levelObjects[3][8] = new Integer(R.drawable.kagubatan_9_gagamba);
		levelObjects[3][9] = new Integer(R.drawable.kagubatan_10_pinya);
		levelObjects[3][10] = new Integer(R.drawable.kagubatan_11_kawayan);
		levelObjects[3][11] = new Integer(R.drawable.kagubatan_12_bituin);
		levelObjects[3][12] = new Integer(R.drawable.kagubatan_13_mais);
		levelObjects[3][13] = new Integer(R.drawable.kagubatan_14_pakwan);
		levelObjects[3][14] = new Integer(R.drawable.kagubatan_15_lapis);

		levelObjects[4][0] = new Integer(R.drawable.attic_1_siper);
		levelObjects[4][1] = new Integer(R.drawable.attic_2_kandila);
		levelObjects[4][2] = new Integer(R.drawable.attic_3_sabon);
		levelObjects[4][3] = new Integer(R.drawable.attic_4_baril);
		levelObjects[4][4] = new Integer(R.drawable.attic_5_batya);
		levelObjects[4][5] = new Integer(R.drawable.attic_6_sandok);
		levelObjects[4][6] = new Integer(R.drawable.attic_7_kampana);
		levelObjects[4][7] = new Integer(R.drawable.attic_8_kwintas);
		levelObjects[4][8] = new Integer(R.drawable.attic_9_lagari);
		levelObjects[4][9] = new Integer(R.drawable.attic_10_gitara);
		levelObjects[4][10] = new Integer(R.drawable.attic_11_pako);
		levelObjects[4][11] = new Integer(R.drawable.attic_12_plantsa);
		levelObjects[4][12] = new Integer(R.drawable.attic_13_posporo);
		levelObjects[4][13] = new Integer(R.drawable.attic_14_salamin);
		levelObjects[4][14] = new Integer(R.drawable.attic_15_gunting);
		
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
		Typeface font = Typeface.createFromAsset(context.getAssets(),
				"BADABB__.TTF");
		((TextView) textView).setTypeface(font);

	}
}
