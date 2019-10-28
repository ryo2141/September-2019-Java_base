package interface_kadai;

/**
 * 10円玉クラス
 * @author miyauchi
 *
 */
public class M10 implements Money {
	/**
	 * 値段取得メソッドをオーバーライドした10円玉取得メソッド
	 */
	@Override
	public int getNedan() {
		return 10;
	}
}
