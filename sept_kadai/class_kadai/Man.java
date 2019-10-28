package class_kadai;

import java.util.ArrayList;
import java.util.List;

public class Man {
	private String name;
	private int age;
	private List<Koza> kozaList = new ArrayList<>();

	public Man(String name, int age) {
		this.name = name;
		this.age = age;
	}

	void kaisetu(String bankName, long savings) {
		Koza a = new Koza(bankName, savings);
		kozaList.add(a);
	}

	public void hurikomi(int i, long money) {
		money += kozaList.get(i - 1).getSavings();
		kozaList.get(i - 1).setSavings(money);

	}

	public void hikidashi(int i, long money) {
		money -= kozaList.get(i - 1).getSavings();
		if (money < 0) {
			money *= -1;
		}
		kozaList.get(i - 1).setSavings(money);
	}

	public void kozaClose(int i) {
		kozaList.remove(i - 1);
	}

	void show() {
		System.out.println("名前:" + this.name);
		System.out.println("年齢:" + this.age);
		for (int i = 0; i < kozaList.size(); i++) {
			System.out.println("口座" + (i + 1) + "：銀行名：" + kozaList.get(i).getBankName());
			System.out.println("　　 " + "　貯金額：" + String.format("%,d", kozaList.get(i).getSavings()) + "円");
		}
		System.out.println();
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

	/**
	 * @return age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age セットする age
	 */
	public void setAge(int age) {
		this.age = age;
	}

}
