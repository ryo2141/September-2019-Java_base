package seiza;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {
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

	public static String getCurrentDate() {

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(calendar.getTime());
	}
}
