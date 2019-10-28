package calculate;

/**
 * 電卓 LEVEL1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 計算機クラス.
 *
 * @author K.Yonemaru
 */
public class Calculator {

	/** 初期値：char型 */
	private static final char INIT_CHAR = '\u0000';

	/** char型演算子：＋ */
	private static final char CHAR_OPERATOR_ADD = '+';

	/** char型演算子：－ */
	private static final char CHAR_OPERATOR_SUBTRACT = '-';

	/** char型演算子：× */
	private static final char CHAR_OPERATOR_MULTIPLY = '*';

	/** char型演算子：÷ */
	private static final char CHAR_OPERATOR_DIVISION = '/';

	/** String型演算子：＋ */
	private static final String STRING_OPERATOR_ADD = "+";

	/** String型演算子：－ */
	private static final String STRING_OPERATOR_SUBTRACT = "-";

	/** String型演算子：× */
	private static final String STRING_OPERATOR_MULTIPLY = "*";

	/** String型演算子：÷ */
	private static final String STRING_OPERATOR_DIVISION = "/";

	/**
	 * 計算処理実行メイン処理.
	 *
	 * @param args コマンドライン引数
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		System.out.println("計算式を入力してください");

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input = bf.readLine();

		// 入力値がNULLまたは未入力の場合
		if (input == null || "".equals(input.trim())) {
			System.out.println("計算式を入力していないため、処理を終了します");
			return;
		}

		try {
			// 式を解析
			List<String> formulateList = parseInput(input);
			// 解析した式を計算
			calculate(formulateList);
		} catch (CalculatorException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 入力された式を分解し、リストに詰めて返却します.
	 *
	 * @param input 入力値
	 * @return 分解した式リスト
	 * @throws CalculatorException 不正な入力が含まれていた場合にスロー
	 */
	private static List<String> parseInput(String input) throws CalculatorException {

		// 分解した計算式リスト
		List<String> formulateList = new ArrayList<String>();
		// 式の要素
		StringBuilder formulateSb = new StringBuilder();

		// 入力値の文字列文繰返し
		for (int i = 0; i < input.length(); i++) {

			// 直前の文字
			char bfrCh = INIT_CHAR;
			// 現在の文字
			char ch = input.charAt(i);
			// 直後の文字
			char aftCh = INIT_CHAR;

			// 最初の文字でない場合
			if (i > 0) {
				bfrCh = input.charAt(i - 1);
			}

			// 最後の文字でない場合
			if (i < (input.length() - 1)) {
				aftCh = input.charAt(i + 1);
			}

			// 不正な文字列チェック
			checkCharactor(ch, bfrCh, aftCh, i, input.length());

			// 式の要素に現在の文字を設定
			formulateSb.append(String.valueOf(ch));

			// 現在が乗算割算減算または、次が四則演算子、または最後の位置文字
			// または、（現在が加算減算かつ前の記号が乗算割算でない）場合
			if (isMultiplyOrDivision(ch) || isArithmetic(aftCh) || aftCh == INIT_CHAR
					|| (isAddOrSubtract(ch) && !isMultiplyOrDivision(bfrCh))) {
				formulateList.add(formulateSb.toString());
				formulateSb.setLength(0);
			}
		}

		//        // 解析結果を出力
		//        System.out.print("解析結果 ： ");
		//        for (String formulate : formulateList) {
		//            System.out.print(formulate + " | ");
		//        }
		System.out.println();

		return formulateList;
	}

	/**
	 * 分解された式の計算を実行します.
	 *
	 * @param formulateList 分解した式リスト
	 * @throws CalculatorException 不正な入力が含まれていた場合にスロー
	 */
	private static void calculate(List<String> formulateList) throws CalculatorException {

		// 結果
		int result = 0;
		// 途中結果
		int tmpResult = 0;
		// 演算子
		String operator = null;

		// 分解された式のリスト文ループ
		for (int i = 0; i < formulateList.size(); i++) {

			String formulate = formulateList.get(i);

			// 加算減算場合
			if (STRING_OPERATOR_ADD.equals(formulate) || STRING_OPERATOR_SUBTRACT.equals(formulate)) {
				continue;
			} else if (isMultiplyOrDivision(formulate.charAt(0))) {
				// 乗算割算の場合
				operator = formulate;
			} else {
				// 演算子が指定されている場合
				if (operator != null) {
					switch (operator) {
					case STRING_OPERATOR_MULTIPLY:
						tmpResult = checkOverFlowMultiply(tmpResult, convertFromStringToInt(formulate));
						break;
					case STRING_OPERATOR_DIVISION:
						tmpResult /= convertFromStringToInt(formulate);
						break;
					default:
						break;
					}
					// 乗算割算後の値で分解式を置き換え
					formulateList.remove(i);
					formulateList.remove(i - 1);
					formulateList.set(i - 2, String.valueOf(tmpResult));
					i = i - 2;
					operator = null;
					continue;
				}

				// 演算子が指定されていない場合
				tmpResult = convertFromStringToInt(formulate);
			}
		}

		// 分解された式のリスト文ループ
		for (String formulate : formulateList) {

			// 加算減算場合
			if (STRING_OPERATOR_ADD.equals(formulate) || STRING_OPERATOR_SUBTRACT.equals(formulate)) {
				operator = formulate;
			} else {
				// 演算子が指定されている場合
				if (operator != null) {
					switch (operator) {
					case STRING_OPERATOR_ADD:
						result = checkOverFlowAdd(result, convertFromStringToInt(formulate));
						break;
					case STRING_OPERATOR_SUBTRACT:
						result = checkOverFlowSubtract(result, convertFromStringToInt(formulate));
						break;
					default:
						break;
					}
					operator = null;
					continue;
				}

				// 演算子が指定されていない場合
				result = convertFromStringToInt(formulate);
			}
		}

		System.out.println("計算結果 ： " + result);
	}

	/**
	 * 不正な文字列チェック.
	 *
	 * @param ch 現在の文字列
	 * @param aftCh 次の文字列
	 * @param index インデックス
	 * @param length 長さ
	 * @throws CalculatorException 不正な文字列が入力された場合にスロー
	 */
	private static void checkCharactor(char ch, char bfrCh, char aftCh, int index, int length)
			throws CalculatorException {

		// 不正な文字列の場合
		if (!isNormalCharactor(ch)) {
			throw new CalculatorException("演算式に不正な文字が含まれています。(21～23)");
		}

		// 先頭の文字が乗算割算の場合
		if (index == 0 && isMultiplyOrDivision(ch)) {
			throw new CalculatorException("演算式が不正です。(26:先頭乗算割算）");
		}

		// 加算減算、乗算割算が連続している場合
		if ((isAddOrSubtract(ch) && isAddOrSubtract(aftCh))
				|| (isMultiplyOrDivision(ch) && isMultiplyOrDivision(aftCh))) {
			throw new CalculatorException("演算式が不正です。(19:加算減算、乗算割算連続)");
		}

		// 加算減算の次に乗算割算が連続している場合
		if (isAddOrSubtract(ch) && isMultiplyOrDivision(aftCh)) {
			throw new CalculatorException("演算式が不正です。(25:加算減算の次に乗算割算)");
		}

		// 最後の文字が数値でない場合
		if (index == (length - 1) && !Character.isDigit(ch)) {
			throw new CalculatorException("演算式が不正です。(24:最後の文字不正）");
		}

		// 0除算の場合（÷0または÷-0）
		if ((bfrCh == CHAR_OPERATOR_DIVISION && ch == '0')
				|| (bfrCh == CHAR_OPERATOR_DIVISION && ch == CHAR_OPERATOR_SUBTRACT && aftCh == '0')) {
			throw new CalculatorException("0除算です。(18:0除算）");
		}
	}

	/**
	 * 不正文字列チェック.
	 *
	 * @param ch 入力値
	 * @return 判定結果
	 */
	private static boolean isNormalCharactor(char ch) {
		if (Character.isDigit(ch) || ch == CHAR_OPERATOR_ADD || ch == CHAR_OPERATOR_SUBTRACT
				|| ch == CHAR_OPERATOR_MULTIPLY || ch == CHAR_OPERATOR_DIVISION || ch == '(' || ch == ')') {
			return true;
		}
		return false;
	}

	/**
	 * 四則演算子かどうかを判定します.
	 *
	 * @param ch 文字
	 * @return 判定結果
	 */
	private static boolean isArithmetic(char ch) {
		if (isAddOrSubtract(ch) || isMultiplyOrDivision(ch)) {
			return true;
		}
		return false;
	}

	/**
	 * 加算減算かどうかを判定します.
	 *
	 * @param ch 文字
	 * @return 判定結果
	 */
	private static boolean isAddOrSubtract(char ch) {
		if (ch == CHAR_OPERATOR_ADD || ch == CHAR_OPERATOR_SUBTRACT) {
			return true;
		}
		return false;
	}

	/**
	 * 乗算割算かどうかを判定します.
	 *
	 * @param ch 文字
	 * @return 判定結果
	 */
	private static boolean isMultiplyOrDivision(char ch) {
		if (ch == CHAR_OPERATOR_MULTIPLY || ch == CHAR_OPERATOR_DIVISION) {
			return true;
		}
		return false;
	}

	/**
	 * String型からint型に変換します.
	 *
	 * @param formulate 式
	 * @return 変換結果
	 * @throws CalculatorException 型の変換に失敗した場合にスロー
	 */
	private static int convertFromStringToInt(String formulate) throws CalculatorException {

		if (formulate == null || "".equals(formulate)) {
			return 0;
		}

		try {
			return Integer.parseInt(formulate);
		} catch (NumberFormatException e) {
			throw new CalculatorException("オーバーフローです。(20:オーバーフロー）");
		}
	}

	/**
	 * 積算結果のオーバーフローチェック.
	 *
	 * @param param1 計算値１
	 * @param param2 計算値２
	 * @return 計算結果
	 * @throws CalculatorException オーバーフローが発生した場合にスロー
	 */
	private static int checkOverFlowMultiply(int param1, int param2) throws CalculatorException {
		long result = (long) param1 * (long) param2;
		return checkOverFlow(result);
	}

	/**
	 * 加算結果のオーバーフローチェック.
	 *
	 * @param param1 計算値１
	 * @param param2 計算値２
	 * @return 計算結果
	 * @throws CalculatorException オーバーフローが発生した場合にスロー
	 */
	private static int checkOverFlowAdd(int param1, int param2) throws CalculatorException {
		long result = (long) param1 + (long) param2;
		return checkOverFlow(result);
	}

	/**
	 * 減算結果のオーバーフローチェック.
	 *
	 * @param param1 計算値１
	 * @param param2 計算値２
	 * @return 計算結果
	 * @throws CalculatorException オーバーフローが発生した場合にスロー
	 */
	private static int checkOverFlowSubtract(int param1, int param2) throws CalculatorException {
		long result = (long) param1 - (long) param2;
		return checkOverFlow(result);
	}

	/**
	 * int型のオーバーフローチェック.
	 *
	 * @param param 計算値
	 * @throws CalculatorException オーバーフローが発生した場合にスロー
	 */
	private static int checkOverFlow(long param) throws CalculatorException {
		if (param > Integer.MAX_VALUE || param < Integer.MIN_VALUE) {
			throw new CalculatorException("オーバーフローです。(20:オーバーフロー）");
		}
		return (int) param;
	}
}
