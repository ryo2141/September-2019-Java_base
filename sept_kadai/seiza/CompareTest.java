package seiza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(1);
		list.add(53);
		list.add(2);
		list.add(5);
		list.add(10);
		list.add(90);
		list.add(11);
		list.add(7);

		Collections.sort(list, new MyComparator());

		for (Integer i : list) {
			System.out.println(i);
		}
	}
}
