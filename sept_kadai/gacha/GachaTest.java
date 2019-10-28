package gacha;

import java.util.Random;

public class GachaTest {
	private static final double PRIZE_PER = 0.005;

	public static void main(String[] args) {

		GachaTest test = new GachaTest();

		for (int i = 0; i < 10000; i++) {
			System.out.println(test.drawLot());
		}
	}

	public int drawLot() {
		boolean isPrize = false;
		int counter = 0;
		Random rnd = new Random();
		while (isPrize == false) {
			counter++;
			if (rnd.nextDouble() <= PRIZE_PER) {
				isPrize = true;
			}
		}
		return counter;
	}
}