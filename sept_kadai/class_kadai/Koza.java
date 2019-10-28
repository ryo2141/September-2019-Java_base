package class_kadai;

public class Koza {
	private String name;
	private long savings;

	public Koza(String name, long num) {
		this.name = name;
		this.savings = num;
	}

	public void setBankName(String name) {
		this.name = name;
	}

	public void setSavings(long num) {
		this.savings = num;
	}

	public String getBankName() {
		return name;
	}

	public long getSavings() {
		return savings;
	}

}
