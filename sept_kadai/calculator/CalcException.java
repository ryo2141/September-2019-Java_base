package calculator;

/**
 * CalcExceptionクラス
 * @author miyauchi
 *
 */
public class CalcException extends Exception {

	/**
	 * コンストラクタ
	 * @param message エラー時の出力メッセージ
	 */
	public CalcException(String message) {
		super(message);
	}

}