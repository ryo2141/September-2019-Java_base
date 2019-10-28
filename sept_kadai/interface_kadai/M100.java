package interface_kadai;

/**
 * 100円玉クラス
 * @author miyauchi
 *
 */
public class M100 implements Money {
	/**
	 * 値段取得メソッドをオーバーライドした100円取得メソッド
	 */
	@Override
	public int getNedan() {
		return 100;
	}
}
