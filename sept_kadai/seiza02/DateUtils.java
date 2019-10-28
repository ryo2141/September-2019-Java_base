package seiza02;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * DateUtilsクラス
 * @author miyauchi
 *
 */
public class DateUtils {
	/**
	 * 日付整合性チェックメソッド
	 * @param MMdd 月日
	 * @return 入力値が存在する月日ならtrue, そうでないならfalse
	 * @throws ParseException
	 */
	public static boolean dateCheck(String MMdd) throws ParseException {

		String date = MMdd;

		DateFormat df = new SimpleDateFormat("MMdd");

		df.setLenient(false);

		try {
			df.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	/**
	 * 本日の日付を取得するメソッド
	 * @return
	 */
	public static String getCurrentDate() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(calendar.getTime());
	}

	/**
	 * 本日日付ナンバー取得メソッド
	 * @return
	 */
	public static Integer todayNumber() {

		String strDate = getCurrentDate();

		int total = 0;

		//日付の数字を分解して足していくループ処理
		for (int i = 0; i < strDate.length(); i++) {
			total += Character.getNumericValue(strDate.charAt(i));
		}

		return total;
	}

}
