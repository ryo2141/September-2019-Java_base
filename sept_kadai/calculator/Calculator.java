package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Calculatorクラス
 * @author miyauchi
 *
 */
public class Calculator {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("計算式を入力してください。数値と演算子の間は空白をあけずに。例：2+3 ");
		String formula = br.readLine();

		try {
			System.out.println(parseAndCalc(formula));
		} catch (CalcException e) {
			System.out.println(e.getMessage());
		}
	}

	public static int parseAndCalc(String formula) throws CalcException {

		List<Character> numbersList = new ArrayList<>();
		Collections.addAll(numbersList, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

		List<Character> chList = new ArrayList<>();
		for (int i = 0; i < formula.length(); i++) {
			chList.add(formula.charAt(i));
		}

		List<Character> opeList = new ArrayList<>();
		opeList.add('+');
		opeList.add('-');
		opeList.add('*');
		opeList.add('/');

		List<String> error19List = new ArrayList<>();
		error19List.addAll(Arrays.asList("++", "+-", "--", "-+", "**", "*/", "/*", "//"));

		List<String> error25List = new ArrayList<>();
		error25List.addAll(Arrays.asList("+*", "+/", "-*", "-/"));

		//全体で式になるリスト。Stringにしないと掛け算・割り算が厳しくなる
		List<String> fomlList = new ArrayList<>();

		//いわゆる項になる部分をループ内で格納して、fomlListに入れる。
		StringBuilder num = new StringBuilder();

		for (int i = 0; i < error19List.size(); i++) {
			if (formula.contains(error19List.get(i))) {
				throw new CalcException("演算式が不正です。(19:加算減算、乗算割算連続)");
			}
		}

		for (int i = 0; i < error25List.size(); i++) {
			if (formula.contains(error25List.get(i))) {
				throw new CalcException("演算式が不正です。(25:加算減算の次に乗算割算)");
			}
		}

		for (int i = 0; i < chList.size(); i++) {
			char c = chList.get(i);

			if ('*' == (chList.get(0)) || '/' == (chList.get(0))) {
				throw new CalcException("演算式が不正です。(26:先頭乗算割算）");
			}

			if (opeList.contains(c)) {

				if (c == '-') {
					if (num.length() != 0) {
						fomlList.add(num.toString());
					}
					num = new StringBuilder();
					num.append(chList.get(i).toString());
				} else if (c == '+') {
					if (num.length() != 0) {
						fomlList.add(num.toString());
					}
					num = new StringBuilder();
				} else {
					fomlList.add(num.toString());
					fomlList.add(chList.get(i).toString());
					num = new StringBuilder();
				}
			} else if (numbersList.contains(c)) {
				num.append(chList.get(i).toString());
			} else {
				throw new CalcException("演算式に不正な文字が含まれています。(21～23)");
			}
		}
		fomlList.add(String.valueOf(num));

		//ここから計算
		//掛け算・割り算

		for (int i = 0; i < fomlList.size(); i++) {
			String fo = fomlList.get(i);

			//掛け算
			if ("*".equals(fo)) {
				int left = Integer.parseInt(fomlList.get(i - 1));
				int right = Integer.parseInt(fomlList.get(i + 1));
				int multi = 0;

				try {
					multi = left * right;
				} catch (ArithmeticException e) {
					throw new CalcException("オーバーフローです。");
				}
				//上の答えをリストの中の(i)の位置に入れる(置き換える)
				fomlList.set(i, String.valueOf(multi));
				//left, rightの値をリスト内から削除
				fomlList.remove(i - 1);
				fomlList.remove(i);
				--i;
			}

			//割り算
			if ("/".equals(fo)) {
				int left = Integer.parseInt(fomlList.get(i - 1));
				int right = Integer.parseInt(fomlList.get(i + 1));
				int divide = 0;

				try {
					divide = left / right;
				} catch (ArithmeticException e) {
					throw new CalcException("0除算です。(18:0除算）");
				}
				//上の答えをリストの中の(i)の位置に入れる(置き換える)
				fomlList.set(i, String.valueOf(divide));
				//left, rightの値をリスト内から削除
				fomlList.remove(i - 1);
				fomlList.remove(i);//ひとつ消したらインデックス番号が前倒しになるため。
				--i;
			}
		}

		//足し算
		int answer = 0;

		//fomlList内を順に加算
		for (int i = 0; i < fomlList.size(); i++) {
			try {
				int num1 = Integer.parseInt(fomlList.get(i));
				answer += num1;
			} catch (NumberFormatException e) {
				throw new CalcException("演算式が不正です。(24:最後の文字不正）");
			} catch (ArithmeticException e) {
				throw new CalcException("オーバーフローです");
			}
		}

		return answer;
	}

}