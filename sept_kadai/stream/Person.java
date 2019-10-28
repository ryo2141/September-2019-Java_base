package stream;

public class Person {
	private String name;
	private int age;
	private String hobby;
	private String bloodType;

	public Person() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Person(String name, int age, String hobby, String bloodType) {
		this.name = name;
		this.age = age;
		this.hobby = hobby;
		this.bloodType = bloodType;
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

	/**
	 * @return hobby
	 */
	public String getHobby() {
		return hobby;
	}

	/**
	 * @param hobby セットする hobby
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	/**
	 * @return bloodType
	 */
	public String getBloodType() {
		return bloodType;
	}

	/**
	 * @param bloodType セットする bloodType
	 */
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

}
