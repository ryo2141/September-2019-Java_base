package seiza02;

import java.util.Comparator;
import java.util.regex.Pattern;

/**
 * RankingComparatorクラス
 * @author miyauchi
 *
 */
public class RankingComparator implements Comparator<Numbers> {

	/**
	 * 比較メソッド
	 * @param o1, o2 昇順・降順を判定する
	 * @return
	 *
	 */
	@Override
	public int compare(Numbers o1, Numbers o2) {
		String[] arrayO1 = o1.getConstellaLuckyNumber().split(Pattern.quote("."));
		String[] arrayO2 = o2.getConstellaLuckyNumber().split(Pattern.quote("."));

		int shousu01 = Integer.parseInt(arrayO1[1]);
		int shousu02 = Integer.parseInt(arrayO2[1]);

		int seisu01 = Integer.parseInt(arrayO1[0]);
		int seisu02 = Integer.parseInt(arrayO2[0]);

		//小数部分が同じ場合
		if (shousu01 == shousu02) {
			return seisu02 - seisu01;
		}

		return shousu02 - shousu01;
	}

}
