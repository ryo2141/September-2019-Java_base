package seiza;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Sample {
	private static Constellation[] constellations = new Constellation[12];

	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");

		// 星座リスト初期化
		initConstellations();

		// 生年月日入力
		System.out.print("生年月日（yyyy/MM/dd）=");
		String birthday = scanner.next();
		scanner.close();
		Date dateBirthday = format.parse(birthday);

		// 星座表示
		for (Constellation constellation : constellations) {
			if (constellation.between(dateBirthday)) {
				System.out.println(constellation.getName());
				break;
			}
		}
	}

	private static void initConstellations() {
		int i = 0;
		constellations[i++] = new Constellation("Aquarius", "1/20", "2/18");
		constellations[i++] = new Constellation("Pisces", "2/19", "3/20");
		constellations[i++] = new Constellation("Aries", "3/21", "4/19");
		constellations[i++] = new Constellation("Taurus", "4/20", "5/20");
		constellations[i++] = new Constellation("Gemini", "5/21", "6/21");
		constellations[i++] = new Constellation("Cancer", "6/22", "7/22");
		constellations[i++] = new Constellation("Leo", "7/23", "8/22");
		constellations[i++] = new Constellation("Virgo", "8/23", "9/22");
		constellations[i++] = new Constellation("Libra", "9/23", "10/23");
		constellations[i++] = new Constellation("Scorpio", "10/24", "11/22");
		constellations[i++] = new Constellation("Sagittarius", "11/23", "12/21");
		constellations[i++] = new Constellation("Capricorn", "12/22", "1/19");
	}
}
