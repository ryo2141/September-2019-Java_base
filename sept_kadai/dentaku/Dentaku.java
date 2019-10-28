package dentaku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dentaku {
	public static void main(String[] args) throws IOException {

		int num = 0;
		String enzan = "";
		String value = "";
		String msg = "数値";

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("現在の値:" + num);
			System.out.println("演算子:" + enzan);
			System.out.println("入力された値:" + value);
			System.out.print(msg + "を入力してください >>");

			String str = br.readLine();
			System.out.println("");
			if ("q".equals(str)) {
				break;
			}

			try {
				if ("数値".equals(msg)) {
					num = Integer.parseInt(str);
					msg = "演算子";
				} else if ("演算子".equals(msg)) {
					enzan = parseEnzan(str);
					msg = "数値または演算子";
				} else {
					if (is_enzan(str)) {
						enzan = parseEnzan(str);
					} else {
						num = Integer.parseInt(str);
					}
					msg = "数値又は演算子";
				}
			} catch (Exception ex) {
				System.out.println("# ---- エラー：" + msg + "ではありません。\n");
			}
		}

	}

	static boolean is_enzan(String str) {
		if ((str.length() != 1) || ("+-*/".indexOf(str) == -1)) {
			return false;
		}
		return true;
	}

	static String parseEnzan(String str) throws IllegalArgumentException {
		if (is_enzan(str) == false) {
			throw new IllegalArgumentException("演算子ではありません。");
		}
		return str;
	}

}
