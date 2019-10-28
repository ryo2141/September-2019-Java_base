package interface_kadai;

public class AutoHanbaiki {
	/** 投入金額 */
	private int inMoney;
	/** 購入可否 */
	private boolean buyableFlg;

	/**
	 * お金の投入と購入可否の判定
	 * @param m お金となるMoney型のオブジェクト
	 */
	void inputMoney(Money m) {
		int input = m.getNedan();
		inMoney += input;

		//投入金額が120円以上の場合
		if (inMoney >= 120) {
			setBuyableFlg(true);
		}
	}

	/**
	 * @return inMoney
	 */
	public int getInMoney() {
		return inMoney;
	}

	/**
	 * @param inMoney セットする inMoney
	 */
	public void setInMoney(int inMoney) {
		this.inMoney = inMoney;
	}

	/**
	 * @return buyableFlg
	 */
	public boolean isBuyableFlg() {
		return buyableFlg;
	}

	/**
	 * @param buyableFlg セットする buyableFlg
	 */
	public void setBuyableFlg(boolean buyableFlg) {
		this.buyableFlg = buyableFlg;
	}
}
