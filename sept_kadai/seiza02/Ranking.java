package seiza02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Rankingクラス
 * @author miyauchi
 *
 */
public class Ranking {

	/**
	 * ランキング取得メソッド
	 * @return	ソートしたランキングを戻す
	 */
	public List<Numbers> getRanking() {
		List<Numbers> ranking = new ArrayList<>();

		//CODE_MAPからKeyとValueを取得し、ラッキーナンバーを計算してリストに格納するループ
		for (Map.Entry<String, String> map : Horoscopes.codeMap.entrySet()) {
			Numbers numbers = new Numbers();

			numbers.setConstellationNumber(map.getKey());

			int todaysNumber = DateUtils.todayNumber();
			double luckyNumber = Double.parseDouble(map.getValue()) / todaysNumber;

			numbers.setConstellaLuckyNumber(String.format("%.6f", luckyNumber));
			ranking.add(numbers);
		}

		//ソートする
		Collections.sort(ranking, new RankingComparator());
		return ranking;
	}

}
//
//以下RankingComparatorクラスなしで実装する場合
////１．Comparatorをラムダ式で実装
//		Comparator<Numbers> con = (Numbers o1, Numbers o2) -> {
//			String[] arrayO1 = o1.getConstellaLuckyNumber().split(Pattern.quote("."));
//			String[] arrayO2 = o2.getConstellaLuckyNumber().split(Pattern.quote("."));
//
//			int shousu01 = Integer.parseInt(arrayO1[1]);
//			int shousu02 = Integer.parseInt(arrayO2[1]);
//
//			int seisu01 = Integer.parseInt(arrayO1[0]);
//			int seisu02 = Integer.parseInt(arrayO2[0]);
//
//			//小数部分が同じ場合
//			if (shousu01 == shousu02) {
//				return seisu02 - seisu01;
//			} else {
//				return shousu02 - shousu01;
//			}
//
//		};
//		ranking.stream().sorted(con);
//
//２．ラムダ式でソートする
//Collections.sort(ranking, (Numbers o1, Numbers o2) -> {
//	String[] arrayO1 = o1.getConstellaLuckyNumber().split(Pattern.quote("."));
//	String[] arrayO2 = o2.getConstellaLuckyNumber().split(Pattern.quote("."));
//
//	int shousu01 = Integer.parseInt(arrayO1[1]);
//	int shousu02 = Integer.parseInt(arrayO2[1]);
//
//	int seisu01 = Integer.parseInt(arrayO1[0]);
//	int seisu02 = Integer.parseInt(arrayO2[0]);
//
//	//小数部分が同じ場合
//	if (shousu01 == shousu02) {
//		return seisu02 - seisu01;
//	} else {
//		return shousu02 - shousu01;
//	}
//
//});