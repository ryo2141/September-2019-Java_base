package gacha;

import java.util.Random;

/**
 * ガチャクラス
 * @author miyauchi
 *
 */
public class Gacha01 {
	/** Sレアの確率2.5% */
	private static final double PRIZE_PER_2p5 = 0.025;
	/** レアの確率5% */
	private static final double PRIZE_PER_5 = 0.05;
	/** ノーマルの確率20% */
	private static final double PRIZE_PER_20 = 0.2;

	/**
	 * 実行メソッド
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			System.out.println(card());
		}
	}

	/**
	 * カードメソッド カードを返す
	 * @return
	 */
	public static String card() {
		Random rnd = new Random();
		if (rnd.nextDouble() <= PRIZE_PER_2p5) {
			return "Sレア：へパイトス";
		} else if (rnd.nextDouble() > PRIZE_PER_2p5 && rnd.nextDouble() <= PRIZE_PER_2p5 * 2) {
			return "Sレア：ウルド";
		} else if (rnd.nextDouble() > PRIZE_PER_2p5 * 2 && rnd.nextDouble() <= PRIZE_PER_2p5 * 2 + PRIZE_PER_5) {
			return "レア：水ノエル";
		} else if (rnd.nextDouble() > PRIZE_PER_2p5 * 2 + PRIZE_PER_5
				&& rnd.nextDouble() <= PRIZE_PER_2p5 * 2 + PRIZE_PER_5 * 2) {
			return "レア：木ノエル";
		} else if (rnd.nextDouble() > PRIZE_PER_2p5 * 2 + PRIZE_PER_5 * 2
				&& rnd.nextDouble() <= PRIZE_PER_2p5 * 2 + PRIZE_PER_5 * 3) {
			return "レア：火ノエル";
		} else if (rnd.nextDouble() > PRIZE_PER_2p5 * 2 + PRIZE_PER_5 * 3
				&& rnd.nextDouble() <= PRIZE_PER_2p5 * 2 + PRIZE_PER_5 * 3 + PRIZE_PER_20) {
			return "ノーマル：オーディン";
		} else if (rnd.nextDouble() > PRIZE_PER_2p5 * 2 + PRIZE_PER_5 * 3 + PRIZE_PER_20
				&& rnd.nextDouble() <= PRIZE_PER_2p5 * 2 + PRIZE_PER_5 * 3 + PRIZE_PER_20 * 2) {
			return "ノーマル：アマテラス";
		} else if (rnd.nextDouble() > PRIZE_PER_2p5 * 2 + PRIZE_PER_5 * 3 + PRIZE_PER_20 * 2
				&& rnd.nextDouble() <= PRIZE_PER_2p5 * 2 + PRIZE_PER_5 * 3 + PRIZE_PER_20 * 3) {
			return "ノーマル：ゼウス";
		} else {
			return "ノーマル：ヘライース";
		}
	}

}
