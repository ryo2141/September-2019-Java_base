package gacha;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class GachaStream {
	private static final int GACHA_TIMES = 10;

	private static final int S_RARE = 25;
	private static final int RARE = 50;
	private static final int NORMAL = 200;

	private static final List<Card> cardList = new ArrayList<>();
	static {
		cardList.add(new Card(S_RARE, "Sレア：へパイトス"));
		cardList.add(new Card(S_RARE, "Sレア：ウルド"));
		cardList.add(new Card(RARE, "レア：水ノエル"));
		cardList.add(new Card(RARE, "レア：木ノエル"));
		cardList.add(new Card(RARE, "レア：火ノエル"));
		cardList.add(new Card(NORMAL, "ノーマル：オーディン"));
		cardList.add(new Card(NORMAL, "ノーマル：アマテラス"));
		cardList.add(new Card(NORMAL, "ノーマル：ゼウス"));
		cardList.add(new Card(NORMAL, "ノーマル：ヘライース"));
	}

	public static void main(String[] args) {

		Random rnd = new Random();
		List<String> hitCardList = new ArrayList<>();

		// ガチャを引く（0～999までのランダム変数）
		int gachaNum = rnd.nextInt(1000);

		// 確率判定用のボーダー
		int border = 0;

		for (Card card : cardList) {
			border += card.getRate();

			if (gachaNum < border) {
				hitCardList.add(card.getName());
				break;
			}
		}

		int borderUpdate = border;

		Predicate<Card> p = new Predicate<Card>() {
			public boolean test(Card card) {
				if (gachaNum < borderUpdate) {
					return true;
				}

				return false;
			}
		};

		for (int i = 0; i < GACHA_TIMES; i++) {
			cardList.stream().filter(p).forEach(t -> System.out.println(t.getName()));
		}

	}
}

class Card {

	private int rate;
	private String name;

	public Card(int rate, String name) {
		this.rate = rate;
		this.name = name;
	}

	/**
	 * @return rate
	 */
	public int getRate() {
		return rate;
	}

	/**
	 * @param rate セットする rate
	 */
	public void setRate(int rate) {
		this.rate = rate;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
