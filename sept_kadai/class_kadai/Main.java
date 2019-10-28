package class_kadai;

public class Main {
	public static void main(String[] args) {
		//2
		Man manA = new Man("アップル", 23);
		manA.kaisetu("AEVIC銀行", 1000);
		manA.kaisetu("AEVIC太郎銀行", 200000);
		manA.show();

		//3
		Man manB = new Man("ビール", 40);
		manB.kaisetu("AEVIC一郎銀行", 2000);
		manB.kaisetu("AEVIC二郎銀行", 400000);
		manB.kaisetu("AEVIC三郎銀行", 10000000000L);
		manB.show();

		//4
		manA.hurikomi(1, 5000L);
		manA.show();

		//5
		manA.hikidashi(1, 500L);
		manA.show();

		//6
		manA.kaisetu("AEVIC三郎銀行", 100L);
		manA.show();

		//7
		manA.kozaClose(1);
		manA.show();
	}
}
