package calculator02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Calculatorクラス
 * @author miyauchi
 *
 */
public class Calculator {
	/**
	 *
	 * 実行メソッド
	 * @param コマンドライン引数
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("計算式を入力");

		//値を入力する。
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String formula = br.readLine();

		//try-catchで例外をキャッチしてメッセージを投げる
		try {
			System.out.println(parseAndCalc(formula));
		} catch (CalcException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * parseAndCalcメソッド
	 * Stringをintに変えて、計算して戻す。
	 * @param 入力された文字列としての計算式
	 */
	public static int parseAndCalc(String formula) throws CalcException {
		//判断基準となる数字のリスト
		List<Character> numbersList = new ArrayList<>();
		Collections.addAll(numbersList, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

		//文字列を1文字ずつ格納するリスト
		List<Character> chList = new ArrayList<>();

		//入力された文字列をchar型にしてリストに格納する
		for (int i = 0; i < formula.length(); i++) {
			chList.add(formula.charAt(i));
		}

		//判断基準となる演算子のリスト
		List<Character> opeList = new ArrayList<>();
		opeList.add('+');
		opeList.add('-');
		opeList.add('*');
		opeList.add('/');

		//数式を格納するリスト
		List<String> fomlList = new ArrayList<>();

		//数を項・演算子単位でまとめて、fomlListに格納するための変数
		StringBuilder num = new StringBuilder();

		//19のエラーを判断するためのリスト
		List<String> error19List = new ArrayList<>();
		Collections.addAll(error19List, "++", "+-", "--", "-+", "**", "*/", "//", "/*");

		//25のエラーを判断するためのリスト
		List<String> error25List = new ArrayList<>();
		Collections.addAll(error25List, "+*", "+/", "-*", "-/");

		//formulaにerror19Listの中身があった場合、例外をスロー
		for (int i = 0; i < error19List.size(); i++) {

			//入力値formulaにerror19Listの中身があった場合
			if (formula.contains(error19List.get(i))) {
				throw new CalcException("演算式が不正です。(19:加算減算、乗算割算連続)");
			}
		}

		//formulaにerror25Listの中身があった場合、例外をスロー
		for (int i = 0; i < error25List.size(); i++) {

			//入力値formulaにerror25Listの中身があった場合
			if (formula.contains(error25List.get(i))) {
				throw new CalcException("演算式が不正です。(25:加算減算の次に乗算割算)");
			}
		}

		//chListの中身をfomlListに格納
		for (int i = 0; i < chList.size(); i++) {
			char c = chList.get(i);

			//先頭に「*」「/」があった場合
			if ('*' == chList.get(0) || '/' == chList.get(0)) {
				throw new CalcException("演算式が不正です。(26:先頭乗算割算）");
			}

			//chListから取り出した中に演算子があった場合、数字の場合、その他の場合
			if (opeList.contains(c)) {

				//-, +, その他の場合
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
		//最後の数字をfomlListに格納
		fomlList.add(String.valueOf(num));

		//計算
		//掛け算・割り算・足し算
		for (int i = 0; i < fomlList.size(); i++) {
			String fo = fomlList.get(i);

			//掛け算の場合
			if ("*".equals(fo)) {
				long multi = 0;

				try {
					int left = Integer.parseInt(fomlList.get(i - 1));
					int right = Integer.parseInt(fomlList.get(i + 1));

					multi = Math.multiplyExact(left, right);
					checkOverflow(multi);

				} catch (NumberFormatException e) {
					throw new CalcException("演算式が不正です。(24:最後の文字不正）");
				} catch (ArithmeticException e) {
					throw new CalcException("オーバーフローです。");
				}

				fomlList.set(i, String.valueOf(multi));

				fomlList.remove(i - 1);
				fomlList.remove(i);
				--i;
			}

			//割り算の場合
			if ("/".equals(fo)) {
				int divide = 0;

				try {
					int left = Integer.parseInt(fomlList.get(i - 1));
					int right = Integer.parseInt(fomlList.get(i + 1));

					divide = left / right;
				} catch (NumberFormatException e) {
					throw new CalcException("演算式が不正です。(24:最後の文字不正）");
				} catch (ArithmeticException e) {
					throw new CalcException("0除算です。(18:0除算）");
				}

				fomlList.set(i, String.valueOf(divide));

				fomlList.remove(i - 1);
				fomlList.remove(i);
				--i;
			}

		}

		//計算結果を代入する変数result
		int result = 0;

		//足し算
		for (int i = 0; i < fomlList.size(); i++) {
			try {
				long sum = Long.parseLong(fomlList.get(i));
				checkOverflow(sum);
				result = Math.addExact(result, (int) sum);

			} catch (NumberFormatException e) {
				throw new CalcException("演算式が不正です。(24:最後の文字不正）");
			} catch (ArithmeticException e) {
				throw new CalcException("オーバーフローです。");
			}
		}

		//計算結果を戻す
		return result;

	}

	public static void checkOverflow(Long lo) throws CalcException {
		if (lo > Integer.MAX_VALUE || lo < Integer.MIN_VALUE) {
			throw new CalcException("オーバーフローです。");
		}
	}
}