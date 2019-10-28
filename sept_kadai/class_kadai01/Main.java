package class_kadai01;

public class Main {
	public static void main(String[] args) {
		Man manA = new Man();
		manA.setName("アップル");
		manA.setAge(23);

		Koza kozaA01 = new Koza();
		kozaA01.setName("AEVIC銀行");
		kozaA01.setMoney(1000L);

		Koza kozaA02 = new Koza();
		kozaA02.setName("AEVIC太郎銀行");
		kozaA02.setMoney(200000L);

		manA.kozaList.add(kozaA01);
		manA.kozaList.add(kozaA02);

		Man manB = new Man();
		manB.setName("ビール");
		manB.setAge(40);

		Koza kozaB01 = new Koza();
		kozaB01.setName("AEVIC一郎銀行");
		kozaB01.setMoney(2000L);

		Koza kozaB02 = new Koza();
		kozaB02.setName("AEVIC二郎銀行");
		kozaB02.setMoney(400000L);

		Koza kozaB03 = new Koza();
		kozaB03.setName("AEVIC三郎銀行");
		kozaB03.setMoney(10000000000L);

		manB.kozaList.add(kozaB01);
		manB.kozaList.add(kozaB02);
		manB.kozaList.add(kozaB03);

		manA.show();
		manB.show();

		manA.hurikomi(1, 5000);
		manA.show();

		manA.hikiotoshi(1, 500);
		manA.show();

		Koza kozaA03 = new Koza();
		kozaA03.setName("AEVIC三郎銀行");
		kozaA03.setMoney(100);
		manA.kozaList.add(kozaA03);
		manA.show();

		manA.kozaList.remove(1);
		manA.show();

	}
}
