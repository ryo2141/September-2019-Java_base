package calculate;

/**
 * 計算式例外クラス.
 *
 * @author K.Yonemaru
 */
public class CalculatorException extends Exception {

	/**
	 * 計算式例外.
	 *
	 * @param message メッセージ
	 */
	public CalculatorException(String message) {
		super(message);
	}

	/**
	 * 計算式例外.
	 *
	 * @param message メッセージ
	 * @param cause 原因
	 */
	public CalculatorException(String message, Throwable cause) {
		super(message, cause);
	}
}
