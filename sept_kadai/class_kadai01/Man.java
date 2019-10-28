package class_kadai01;

import java.util.ArrayList;
import java.util.List;

public class Man {
	private String name;
	private int age;
	List<Koza> kozaList = new ArrayList<>();

	void show() {
		System.out.println("名前：" + name);
		System.out.println("年齢：" + age);
		for (int i = 0; i < kozaList.size(); i++) {
			System.out.println("口座" + (i + 1) + "：" + kozaList.get(i).getName());
			System.out.println("　　" + "貯金：" + kozaList.get(i).getMoney() + "円");
		}
		System.out.println();

	}

	void hurikomi(int i, long money) {
		money += kozaList.get(i - 1).getMoney();
		kozaList.get(i - 1).setMoney(money);
	}

	void hikiotoshi(int i, long money) {
		money -= kozaList.get(i - 1).getMoney();
		if (money < 0) {
			money *= -1;
		}
		kozaList.get(i - 1).setMoney(money);

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
