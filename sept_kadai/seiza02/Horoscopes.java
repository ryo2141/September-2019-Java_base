package seiza02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Horoscopesクラス
 * @author miyauchi
 *
 */
public class Horoscopes {

	/**
	 * 実行メソッド
	 * @param args コマンドライン引数
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("生まれた月日を入力してください。(MMdd)");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		String constellation = null;

		//本日の日付が存在する場合
		if (DateUtils.dateCheck(str)) {
			constellation = seizaMap.get(getConstellationCode(str));
			System.out.println("あなたの星座は" + constellation + "です。");

			Ranking ranking = new Ranking();
			List<Numbers> rankingList = ranking.getRanking();
			System.out.println();

			//星座コード、ラッキーナンバーを対応させて表示させるループ
			int rank = 0;
			for (int i = 0; i < rankingList.size(); i++) {
				System.out.println(
						rankingList.get(i).getConstellationCode() + ","
								+ rankingList.get(i).getConstellaLuckyNumber());

				//星座コードが一致した場合
				if (rankingList.get(i).getConstellationCode().equals(getConstellationCode(str))) {

					//ランキング順位を出す
					rank = i + 1;
				}
			}

			System.out.println("本日の" + constellation + "の運勢は" + rank + "位です。");
			System.out.println("ラッキーアイテムは" + getLuckyItem() + "です。");

		} else {
			System.out.println("入力値が不正です。");
		}
	}

	/** 星座マップ */
	public static final Map<String, String> seizaMap = new HashMap<>();

	static {

		seizaMap.put("01", "牡羊座");
		seizaMap.put("02", "牡牛座");
		seizaMap.put("03", "双子座");
		seizaMap.put("04", "蟹座");
		seizaMap.put("05", "獅子座");
		seizaMap.put("06", "乙女座");
		seizaMap.put("07", "天秤座");
		seizaMap.put("08", "蠍座");
		seizaMap.put("09", "射手座");
		seizaMap.put("10", "山羊座");
		seizaMap.put("11", "水瓶座");
		seizaMap.put("12", "魚座");

	}

	/** 星座ナンバーマップ */
	public static final Map<String, String> codeMap = new HashMap<>();

	static {

		codeMap.put("01", "321");
		codeMap.put("02", "421");
		codeMap.put("03", "521");
		codeMap.put("04", "622");
		codeMap.put("05", "724");
		codeMap.put("06", "824");
		codeMap.put("07", "924");
		codeMap.put("08", "1024");
		codeMap.put("09", "1123");
		codeMap.put("10", "1223");
		codeMap.put("11", "121");
		codeMap.put("12", "220");
	}

	/**
	 * 星座コード取得メソッド
	 * @param MMdd
	 * @return
	 */
	private static String getConstellationCode(String MMdd) {
		String constellation = null;

		int birthday = Integer.parseInt(MMdd);

		//生月日がそれぞれの条件の場合
		if (321 <= birthday && birthday <= 420) {
			constellation = "01";

		} else if (421 <= birthday && birthday <= 520) {
			constellation = "02";

		} else if (521 <= birthday && birthday <= 621) {
			constellation = "03";

		} else if (622 <= birthday && birthday <= 723) {
			constellation = "04";

		} else if (724 <= birthday && birthday <= 823) {
			constellation = "05";

		} else if (824 <= birthday && birthday <= 923) {
			constellation = "06";

		} else if (924 <= birthday && birthday <= 1023) {
			constellation = "07";

		} else if (1024 <= birthday && birthday <= 1122) {
			constellation = "08";

		} else if (1123 <= birthday && birthday <= 1222) {
			constellation = "09";

		} else if (1223 <= birthday && birthday <= 1231 || 101 <= birthday && birthday <= 120) {
			constellation = "10";

		} else if (121 <= birthday && birthday <= 219) {
			constellation = "11";

		} else if (220 <= birthday && birthday <= 320) {
			constellation = "12";
		}

		return constellation;
	}

	/**
	 * ラッキーアイテム取得メソッド
	 * @return
	 */
	public static String getLuckyItem() {
		List<String> item = new ArrayList<>();
		item.add("赤ペン");
		item.add("ラムネ");
		item.add("ピンクのスマホケース");
		item.add("PS4");
		item.add("コンタクトレンズ");
		item.add("CDプレイヤー");
		item.add("水筒");
		item.add("めがね");
		item.add("ポケットティッシュ");
		item.add("赤い彗星");
		item.add("黒い三連星");
		item.add("fujitsuのパソコン");
		item.add("緑のお茶碗");
		item.add("青いペン");
		item.add("青のワイシャツ");
		item.add("スタバのタンブラー");
		item.add("セットアップ");
		item.add("革靴");
		item.add("懸垂マシーン");
		item.add("ヴィトンのバッグ");
		item.add("ワイヤレスイヤホン");
		item.add("50円玉");
		item.add("写真たて");
		item.add("茶色のスリッパ");
		item.add("デジタル腕時計");
		item.add("タクシー");
		item.add("ホワイトボード");
		item.add("トイレの芳香剤");
		item.add("石油ストーブ");
		item.add("サーキュレーター");
		item.add("天然のマグロ");

		Random random = new Random();
		return item.get(random.nextInt(32));
	}
}
