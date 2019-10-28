package dentaku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dentaku02 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//入力パラメータを読み込む
		String input = br.readLine();
		String[] param = input.split(" ");
		int num1 = Integer.parseInt(param[0]);
		String type = param[1];
		int num2 = Integer.parseInt(param[2]);
		if (type.equals("+")) {
			System.out.println(num1 + num2);
		} else if (type.equals("-")) {
			System.out.println(num1 - num2);
		} else if (type.equals("*")) {
			System.out.println(num1 * num2);
		} else if (type.equals("/")) {
			System.out.println((num1 / num2) + " ... " + (num1 % num2));
		}

	}
}
