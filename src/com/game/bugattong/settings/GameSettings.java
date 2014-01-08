package com.game.bugattong.settings;

import com.game.bugattong.model.LevelQuestion;
import com.game.bugattong.model.SearchObject;
	
public class GameSettings {
	public static LevelQuestion[][] levelQuestions = new LevelQuestion[Constants.MAXLEVELS][Constants.MAXQUESTIONS];
	public static SearchObject[][] levelSearchObjects = new SearchObject[Constants.MAXLEVELS][Constants.MAXQUESTIONS];
	public static boolean[][] userHintedNumbers = new boolean[Constants.MAXLEVELS][Constants.MAXQUESTIONS];
	public static int[][] userHintedNumbersHintsShows = new int[Constants.MAXLEVELS][Constants.MAXQUESTIONS];
	public static boolean[][] userCorrectAnswers = new boolean[Constants.MAXLEVELS][Constants.MAXQUESTIONS];
	public static int currentLevel = 0;
	public static int currentQuestion = 0;
	public static int currentPoints = 0;
	public static boolean hasInit = false;
	public static boolean[] levelLocked = new boolean[5];

	public static void init() {

		for (int level = 0; level < Constants.MAXLEVELS; level++) {
			for (int question = 0; question < Constants.MAXQUESTIONS; question++) {
				userCorrectAnswers[level][question] = false;
			}
		}

		levelLocked[0] = false;
		levelLocked[1] = true;
		levelLocked[2] = true;
		levelLocked[3] = true;
		levelLocked[4] = true;

		currentPoints = 100;

		levelQuestions[0][0] = new LevelQuestion(
				"Takbo roon, takbo rito, \n hindi makaalis sa tayong ito.",
				"DUYAN", "4,1,0,3,2");
		levelQuestions[0][1] = new LevelQuestion(
				"Heto na si Lulong, \n bubulong bulong", "BUBUYOG",
				"6,1,4,0,2,3,5");
		levelQuestions[0][2] = new LevelQuestion(
				"Napapagod kung tumitigil,\n kung tumatakbo�y gumigiliw.",
				"BISIKLETA", "6,8,4,3,7,1,0,2,5");
		levelQuestions[0][3] = new LevelQuestion(
				"Isang senyora nakaupo sa tasa.", "KASOY", "0,2,1,4,3");
		levelQuestions[0][4] = new LevelQuestion(
				"Mataas ang paupo, \n kesa patayo.", "ASO", "0,2,1");
		levelQuestions[0][5] = new LevelQuestion(
				"Ang ina�y gumagapang pa, \n ang anak ay umuupo na.",
				"KALABASA", "0,2,5,4,3,1,7,6");
		levelQuestions[0][6] = new LevelQuestion(
				"Manok kong pula, \n inutusan ko ng umaga, \n nang umuwi�y gabi na.",
				"ARAW", "3,1,0,2");
		levelQuestions[0][7] = new LevelQuestion(
				"Bulaklak muna ang dapat gawin, \n bago mo ito kainin.",
				"SAGING", "3,5,1,4,2,0");
		levelQuestions[0][8] = new LevelQuestion(
				"Nang sumipot sa maliwanag,\n kulubot na ang balat.",
				"AMPALAYA", "0,2,5,4,3,1,7,6");
		levelQuestions[0][9] = new LevelQuestion(
				"Hindi pari, hindi hari, \n nagdadamit ng sari-sari",
				"PARUPARO", "0,2,5,4,3,1,7,6");
		levelQuestions[0][10] = new LevelQuestion(
				"Pusong bibitin-bitin, \n mabango parang hasmin, \n masarap kainin.",
				"MANGGA", "3,5,1,3,2,0");
		levelQuestions[0][11] = new LevelQuestion(
				"Ang mukha\'y parang tao, \n magaling lumukso.", "UNGGOY",
				"3,5,1,4,2,0");
		levelQuestions[0][12] = new LevelQuestion(
				"Aso kong si pula, sumampa sa sanga, \n nagpakita ng ganda.",
				"GUMAMELA", "0,2,5,4,3,1,7,6");
		levelQuestions[0][13] = new LevelQuestion(
				"Ang puno\'y buku-buko, \n ang sanga\'y baril, \n ang bunga ay bote, \n ang laman ay diyamante.",
				"PAPAYA", "3,5,1,4,2,0");
		levelQuestions[0][14] = new LevelQuestion(
				"Dumaing paa\'y walang kamay,\n may pamigkis sa baywang, \n ang ulo\'y parang tagayan, \n alagad ng kalinisan.",
				"WALIS-TINGTING", "10,1,0,6,4,7,12,1,3,9,5,13,8,2,11", true);

		// Question Level 2
		levelQuestions[1][0] = new LevelQuestion(
				"Alipin ng hari, \n hindi makalakad, \n kung hindi itali.",
				"SAPATOS", "6,1,4,0,2,3,5");
		levelQuestions[1][1] = new LevelQuestion(
				"Wala sa langit,wala sa lupa, \n kung lumakad ay patihaya.",
				"BANGKA", "3,5,1,4,2,0");
		levelQuestions[1][2] = new LevelQuestion(
				"Kung araw ay patung-patong, \n kung gabi\'y dugtong-dugtong.",
				"UNAN", "3,1,0,2");
		levelQuestions[1][3] = new LevelQuestion(
				"Hindi tao, hindi ibon, \n bumabalik kung itapon.", "YOYO",
				"3,1,0,2");
		levelQuestions[1][4] = new LevelQuestion(
				"Bumili ako ng alipin, \n mas mataas pa sa akin.", "SUMBRERO",
				"0,2,5,4,3,1,7,6");
		levelQuestions[1][5] = new LevelQuestion(
				"Ipinalilok ko at ipinalubid, \n naghigpitan ang kapit.",
				"SINTURON", "0,2,5,4,3,1,7,6");
		levelQuestions[1][6] = new LevelQuestion(
				"Dugtong-dugtong, magkakarugtong,\n tanikalang umuugong.",
				"TREN", "3,1,0,2");
		levelQuestions[1][7] = new LevelQuestion(
				"Nakalantay kung gabi,\n kung araw ay nakatabi.", "BANIG",
				"4,1,0,3,2");
		levelQuestions[1][8] = new LevelQuestion(
				"isang butil ng palay, buong bahay ay nakakalatan.", "ILAW",
				"4,1,0,3,2");
		levelQuestions[1][9] = new LevelQuestion(
				"Isa ang pasukan,\n tatlo ang labasan.", "KAMISETA",
				"0,2,5,4,3,1,7,6");
		levelQuestions[1][10] = new LevelQuestion(
				"Nang hawak ay patay, \n nang ihagis ay nabuhay.", "TRUMPO",
				"3,5,1,4,2,0");
		levelQuestions[1][11] = new LevelQuestion(
				"Isang biyas ng kawayan, \n maraming lamang kayamanan.",
				"ALKANSIYA", "0,2,4,8,3,5,7,1,6");
		levelQuestions[1][12] = new LevelQuestion(
				"Isang tingting na matigas, \n nang ikiskis namulaklak.",
				"POSPORO", "6,1,4,0,2,3,5");
		levelQuestions[1][13] = new LevelQuestion(
				"Hinila ko ang tadyang, \n lumapad ang tiyan.", "PAYONG",
				"3,5,1,4,2,0");
		levelQuestions[1][14] = new LevelQuestion(
				"Saranggolang naglalayag sa kalangitan, \n Napapalayo pa nito ang paglalakbay",
				"PISI", "3,1,0,2", true);

		// Question Level 3
		levelQuestions[2][0] = new LevelQuestion(
				"Sa buhatan ay may silbi, \n sa igiban ay walang sinabi.",
				"BASKET", "3,5,1,4,2,0");
		levelQuestions[2][1] = new LevelQuestion(
				"Hindi halaman, maraming dahon, \n ang ibinubunga ay dunong.",
				"AKLAT", "4,1,0,3,2");
		levelQuestions[2][2] = new LevelQuestion(
				"Ngayon lang nangyayari,\n nakikita na ng marami, \n kahit sila\'y wala rine.",
				"TELEBISYON", "9,1,6,0,3,5,2,1,7,4");
		levelQuestions[2][3] = new LevelQuestion(
				"May katawa�y walang bituka, \n may puwit walang paa, \n nakakagat tuwina.",
				"BASO", "3,1,0,2");
		levelQuestions[2][4] = new LevelQuestion(
				"Dalawang katawan, \n tagusan ang tadyang.", "HAGDANAN",
				"0,2,5,4,3,1,7,6");
		levelQuestions[2][5] = new LevelQuestion(
				"Dalawang ibong marikit,\n nagtitimbangan ng siit.", "HIKAW",
				"4,1,0,3,2");
		levelQuestions[2][6] = new LevelQuestion(
				"Munting tumataginting,\n kung saan nanggagaling.", "TELEPONO",
				"0,2,5,4,3,1,7,6");
		levelQuestions[2][7] = new LevelQuestion(
				"Bugtong kong sapin sapin,\n Nakasabit, nakabitin, \n Araw araw kung bilangin, \n Isang taon kung tapusin.",
				"KALENDARYO", "9,1,6,0,3,5,2,1,7,4");
		levelQuestions[2][8] = new LevelQuestion(
				"Hiyas akong mabilog, \n sa daliri isinusuot.", "SINGSING",
				"0,2,5,4,3,1,7,6");
		levelQuestions[2][9] = new LevelQuestion(
				"Walang hininga ay may buhay, \n walang paa ay may kamay, \n mabilog na parang buwan, \n ang mukha\'y may bilang.",
				"ORASAN", "3,5,1,4,2,0");
		levelQuestions[2][10] = new LevelQuestion(
				"Binatak ko ang isa, \n pawis ang kasama.", "PANYO",
				"4,1,0,3,2");
		levelQuestions[2][11] = new LevelQuestion(
				"Walang paa, lumalakad, \n walang bibig, nangungusap, \n walang hindi hinaharap, \n may dala-dalang sulat.",
				"SOBRE", "4,1,0,3,2");
		levelQuestions[2][12] = new LevelQuestion(
				"Tumutugtuog, umaawit,\n walang pagod ang pagpihit.", "RADYO",
				"4,1,0,3,2");
		levelQuestions[2][13] = new LevelQuestion(
				"Sapagkat lahat na ay nakahihipo; \n walang kasindumi\'t walang kasimbaho, \n bakit mahal nati\'t ipinakatatago.",
				"SALAPI", "3,5,1,4,2,0");
		levelQuestions[2][14] = new LevelQuestion(
				"Tangan-tangan sa umaga,\n galaw ng bansa ay nakikita.",
				"DYARYO", "3,5,1,4,2,0", true);

		// Question Level 4
		levelQuestions[3][0] = new LevelQuestion(
				"Heto na si bayaw, \n dala-dala\'y ilaw.", "ALITAPTAP",
				"0,2,4,8,3,5,7,1,6");
		levelQuestions[3][1] = new LevelQuestion(
				"May ulo\'y walang buhok, \n may tiyan walang pusod.",
				"PALAKA", "3,5,1,4,2,0");
		levelQuestions[3][2] = new LevelQuestion(
				"Bahay ni Kahuli,\n haligi\'y bali-bali, \n ang bubong ay kawali.",
				"ALIMANGO", "0,2,5,4,3,1,7,6");
		levelQuestions[3][3] = new LevelQuestion(
				"Sa araw nahimhimbing, \n at sa gabi ay gising na gising.",
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
				"Buhay na hindi kumikibo, \n patay na hindi bumabaho.", "BATO",
				"3,1,0,2");
		levelQuestions[3][8] = new LevelQuestion(
				"Isang hayop na maliit, dumudumi ng sinulid.", "GAGAMBA",
				"6,1,4,0,2,3,5");
		levelQuestions[3][9] = new LevelQuestion(
				"Isang dalagang may korona, kahit saan ay may mata.", "PINYA",
				"4,1,0,3,2");
		levelQuestions[3][10] = new LevelQuestion(
				"Nang sanggol pa ay palalo, \n mataas na langit ang itinuturo; \n nang lumaki at lumago, \n sa sariling puno ay yumuko.",
				"KAWAYAN", "6,1,4,0,2,3,5");
		levelQuestions[3][11] = new LevelQuestion(
				"Itinanim sa kagabihan, \n inani sa kaumagahan.", "BITUIN",
				"3,5,1,4,2,0");
		levelQuestions[3][12] = new LevelQuestion(
				"Isang pamalo-palo, libot na libot ng ginto.", "MAIS",
				"3,1,0,2");
		levelQuestions[3][13] = new LevelQuestion(
				"Balat berde, buto itim, \n laman pula, turingan mo kung sino siya.",
				"PAKWAN", "3,5,1,4,2,0");
		levelQuestions[3][14] = new LevelQuestion(
				"Sandata ng mga matalino, \n papel lamang ang hasaan.",
				"LAPIS", "4,1,0,3,2", true);

		// Question Level 5
		levelQuestions[4][0] = new LevelQuestion(
				"Dumaan ang hari, nagkagatan ang mga pari.", "SIPER",
				"4,1,0,3,2");
		levelQuestions[4][1] = new LevelQuestion(
				"May katawan walang mukha, \n walang mata\'y lumuluha.",
				"KANDILA", "6,1,4,0,2,3,5");
		levelQuestions[4][2] = new LevelQuestion(
				"Nagsaing si Kurutong, \n kumulo\'y walang gatong.", "SABON",
				"4,1,0,3,2");
		levelQuestions[4][3] = new LevelQuestion(
				"Sa maling kalabit, \n may buhay na kapalit.", "BARIL",
				"4,1,0,3,2");
		levelQuestions[4][4] = new LevelQuestion(
				"Hindi tao, hindi hayop, \n kung uminom ay salup-salop.",
				"BATYA", "4,1,0,3,2");
		levelQuestions[4][5] = new LevelQuestion(
				"Ang ulo\'y nalalaga, \n ang katawa\'y pagala-gala.", "SANDOK",
				"3,5,1,4,2,0");
		levelQuestions[4][6] = new LevelQuestion(
				"Hinila ko ang baging, \n sumigaw ang matsing.", "KAMPANA",
				"6,1,4,0,2,3,5");
		levelQuestions[4][7] = new LevelQuestion(
				"Kadena\'y isinabit, \n sa batok nakakawit.", "KUWINTAS",
				"0,2,5,4,3,1,7,6");
		levelQuestions[4][8] = new LevelQuestion(
				"Itulak at hilahin, \n sigurado ang kain.", "LAGARI",
				"3,5,1,4,2,0");
		levelQuestions[4][9] = new LevelQuestion(
				"Instrumentong pangharana, \n higis nito ay katawan ng dalaga.",
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
		levelSearchObjects[0][0] = new SearchObject(10, 20);
		levelSearchObjects[0][1] = new SearchObject(70, 20);
		levelSearchObjects[0][2] = new SearchObject(130, 20);
		levelSearchObjects[0][3] = new SearchObject(190, 20);
		levelSearchObjects[0][4] = new SearchObject(250, 20);
		levelSearchObjects[0][5] = new SearchObject(310, 20);
		levelSearchObjects[0][6] = new SearchObject(370, 20);
		levelSearchObjects[0][7] = new SearchObject(410, 20);
		levelSearchObjects[0][8] = new SearchObject(10, 80);
		levelSearchObjects[0][9] = new SearchObject(70, 80);
		levelSearchObjects[0][10] = new SearchObject(130, 80);
		levelSearchObjects[0][11] = new SearchObject(190, 80);
		levelSearchObjects[0][12] = new SearchObject(250, 80);
		levelSearchObjects[0][13] = new SearchObject(310, 80);
		levelSearchObjects[0][14] = new SearchObject(370, 80);

		levelSearchObjects[1][0] = new SearchObject(310, 80);
		levelSearchObjects[1][1] = new SearchObject(370, 80);
		levelSearchObjects[1][2] = new SearchObject(130, 80);
		levelSearchObjects[1][3] = new SearchObject(190, 20);
		levelSearchObjects[1][4] = new SearchObject(190, 80); 
		levelSearchObjects[1][5] = new SearchObject(310, 20);
		levelSearchObjects[1][6] = new SearchObject(370, 20);
		levelSearchObjects[1][7] = new SearchObject(70, 80); 
		levelSearchObjects[1][8] = new SearchObject(10, 80);
		levelSearchObjects[1][9] = new SearchObject(410, 20); 
		levelSearchObjects[1][10] = new SearchObject(130, 20);
		levelSearchObjects[1][11] = new SearchObject(250,20);
		levelSearchObjects[1][12] = new SearchObject(250, 80);
		levelSearchObjects[1][13] = new SearchObject(10, 20);
		levelSearchObjects[1][14] = new SearchObject(70, 20);

		levelSearchObjects[2][0] = new SearchObject(10, 20);
		levelSearchObjects[2][1] = new SearchObject(70, 20);
		levelSearchObjects[2][2] = new SearchObject(130, 20);
		levelSearchObjects[2][3] = new SearchObject(190, 20);
		levelSearchObjects[2][4] = new SearchObject(250, 20);
		levelSearchObjects[2][5] = new SearchObject(310, 20);
		levelSearchObjects[2][6] = new SearchObject(370, 20);
		levelSearchObjects[2][7] = new SearchObject(410, 20);
		levelSearchObjects[2][8] = new SearchObject(10, 80);
		levelSearchObjects[2][9] = new SearchObject(70, 80);
		levelSearchObjects[2][10] = new SearchObject(130, 80);
		levelSearchObjects[2][11] = new SearchObject(190, 80);
		levelSearchObjects[2][12] = new SearchObject(250, 80);
		levelSearchObjects[2][13] = new SearchObject(310, 80);
		levelSearchObjects[2][14] = new SearchObject(370, 80);

		levelSearchObjects[3][0] = new SearchObject(10, 20);
		levelSearchObjects[3][1] = new SearchObject(70, 20);
		levelSearchObjects[3][2] = new SearchObject(130, 20);
		levelSearchObjects[3][3] = new SearchObject(190, 20);
		levelSearchObjects[3][4] = new SearchObject(250, 20);
		levelSearchObjects[3][5] = new SearchObject(310, 20);
		levelSearchObjects[3][6] = new SearchObject(370, 20);
		levelSearchObjects[3][7] = new SearchObject(410, 20);
		levelSearchObjects[3][8] = new SearchObject(10, 80);
		levelSearchObjects[3][9] = new SearchObject(70, 80);
		levelSearchObjects[3][10] = new SearchObject(130, 80);
		levelSearchObjects[3][11] = new SearchObject(190, 80);
		levelSearchObjects[3][12] = new SearchObject(250, 80);
		levelSearchObjects[3][13] = new SearchObject(310, 80);
		levelSearchObjects[3][14] = new SearchObject(370, 80);

		levelSearchObjects[4][0] = new SearchObject(10, 20);
		levelSearchObjects[4][1] = new SearchObject(70, 20);
		levelSearchObjects[4][2] = new SearchObject(130, 20);
		levelSearchObjects[4][3] = new SearchObject(190, 20);
		levelSearchObjects[4][4] = new SearchObject(250, 20);
		levelSearchObjects[4][5] = new SearchObject(310, 20);
		levelSearchObjects[4][6] = new SearchObject(370, 20);
		levelSearchObjects[4][7] = new SearchObject(410, 20);
		levelSearchObjects[4][8] = new SearchObject(10, 80);
		levelSearchObjects[4][9] = new SearchObject(70, 80);
		levelSearchObjects[4][10] = new SearchObject(130, 80);
		levelSearchObjects[4][11] = new SearchObject(190, 80);
		levelSearchObjects[4][12] = new SearchObject(250, 80);
		levelSearchObjects[4][13] = new SearchObject(310, 80);
		levelSearchObjects[4][14] = new SearchObject(370, 80);
	}
}
