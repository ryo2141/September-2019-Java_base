package interface_kadai;

/**
 * メインクラス お金の投入と購入可能か判断
 * @author miyauchi
 *
 */
public class Main {
	/**
	 * メインメソッド
	 * @param args 実行時に渡されるコマンドライン変数
	 */
	public static void main(String[] args) {
		AutoHanbaiki a1 = new AutoHanbaiki();

		M10 m10 = new M10();
		M100 m100 = new M100();

		a1.inputMoney(m10);
		check(a1.isBuyableFlg());
		a1.inputMoney(m100);
		check(a1.isBuyableFlg());
		a1.inputMoney(m10);
		check(a1.isBuyableFlg());
	}

	/**
	 * チェックメソッド 現在の金額で購入可能か判断
	 * @param boo 呼び出し時に指定。isBuyableFlgを呼び出すと判断できる
	 */
	public static void check(boolean boo) {
		//投入金額が充分の場合
		if (boo) {
			System.out.println("購入可能です");
		} else {
			System.out.println("お金が足りません");
		}
	}
}
