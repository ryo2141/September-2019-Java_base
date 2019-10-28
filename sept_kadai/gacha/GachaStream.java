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
	private static int border = 0;
	private static Random rnd = new Random();
	private static int gachaNum = rnd.nextInt(1000);

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

		Predicate<Card> p = new Predicate<Card>() {
			public boolean test(Card card) {
				border += card.getRate();
				if (gachaNum < border) {
					border -= 114514;
					return true;
				}
				return false;
			}
		};

		for (int j = 0; j < GACHA_TIMES; j++) {
			cardList.stream().filter(p).forEach(t -> System.out.println(t.getName()));
			gachaNum = rnd.nextInt(1000);
			border = 0;
		}

	}
}
