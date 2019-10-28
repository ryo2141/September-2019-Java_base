package stream;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
	/**
	 * 人間リストに値を設定し、値を返却します.
	 *
	 * @return 人間リスト
	 */
	private static List<Person> getPersonList() {

		Person person1 = new Person("山田一郎", 26, "水泳", "A");
		Person person2 = new Person("山田二郎", 18, null, "B");
		Person person3 = new Person("山田三郎", 25, "ピアノ", "O");
		Person person4 = new Person("山田四郎", 30, "ロッククライミング", "A");
		Person person5 = new Person("山田五郎", 28, "腕立て伏せ", "O");

		List<Person> personList = new ArrayList<>();
		personList.add(person1);
		personList.add(person2);
		personList.add(person3);
		personList.add(person4);
		personList.add(person5);

		return personList;
	}

	/**
	 * 実行メソッド
	 * @param args
	 */
	public static void main(String[] args) {
		List<Person> personList = getPersonList();

		//3
		List<Person> over20 = personList.stream().filter(i -> i.getAge() > 20).collect(toList());
		for (Person p : over20) {
			System.out.println(p.getName() + ":" + p.getAge());
		}

		//4
		List<Person> over20Sorted = personList.stream().filter(i -> i.getAge() > 20)
				.sorted((a, b) -> a.getAge() - b.getAge())
				.collect(toList());
		//20歳以上の人の名前と年齢を出力するループ
		for (Person p : over20Sorted) {
			System.out.println(p.getName() + ":" + p.getAge());
		}

		//5
		long sum = personList.stream().mapToLong(value -> Integer.toUnsignedLong(value.getAge())).sum();
		System.out.println(sum);

		//6
		boolean bl = personList.stream().allMatch(i -> i.getAge() >= 20);
		System.out.println(bl ? true : false);

		//7
		boolean bl2 = personList.stream().anyMatch(i -> i.getAge() < 20);
		System.out.println(bl2 ? true : false);

		//8(AB型がいなければtrue, その他はfalse)
		boolean bl3 = personList.stream().anyMatch(i -> i.getBloodType().equals("AB"));
		System.out.println(bl3 ? false : true);

		//9
		//名前と趣味の文字列の長さを出力するループ
		for (Person p : personList) {
			//NullPointerExceptionをキャッチしたときには例外でnullを0に置き換える
			try {
				System.out.println(p.getName() + ":" + p.getHobby().length());
			} catch (NullPointerException e) {
				System.out.println(p.getName() + ":" + 0);
			}
		}
		//9 stream使用  Optional.ofNullable()
		System.out.println();
		personList.stream().forEach(
				i -> System.out.println(i.getName() + ":" + Optional.ofNullable(i.getHobby()).orElse("").length()));
		//Optionalクラスの説明
		Optional<Integer> optional = personList.stream().map(s -> s.getName().length()).reduce((a, b) -> a + b);
		System.out.println(optional.get());
	}
}
