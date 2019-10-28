package dentaku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 電卓クラス 課題2 四則演算
 * @author miyauchi
 *
 */
public class Dentaku04 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("計算式を入力してください。数値と演算子の間は空白を。例：2 + 3 ");
		String input = br.readLine();
		String[] param = input.split(" ");
		String type = null;
		Integer sum = 0;
		for (int idx = 0; idx < param.length; idx++) {
			if (param[idx].equals("+") || param[idx].equals("-")) {
				type = param[idx];
			} else {
				Integer num = Integer.parseInt(param[idx]);
				if (type != null) {
					if (type.equals("+")) {
						sum = sum + num;
					} else if (type.equals("-")) {
						sum = sum - num;
					}
				} else {
					sum = num;
				}
			}
		}
		System.out.println(sum);
	}
}

/*
 *
 * if (param[idx].equals("*") || param[idx].equals("/")) {
				type = param[idx];
				Integer num1 = Integer.parseInt(param[idx - 1]);
				Integer num2 = Integer.parseInt(param[idx + 1]);
				if (type.equals("*")) {
					sum = num1 * num2;
				} else if (type.equals("/")) {
					sum = num1 / num2;
				}

			}
			*/
