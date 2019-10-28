package gacha;

public class Card {

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
