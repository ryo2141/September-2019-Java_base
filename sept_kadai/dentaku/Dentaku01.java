package dentaku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dentaku01 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("計算式を入力してください。例：2+3=(Enter)で計算を開始します。");
		String str1 = br.readLine();

		String[] sum = new String[str1.length()];
		String number = "";
		int s = 0;
		int goukei = 0;
		char enzan = 'a';

		//for文で繰り返し処理
		for (int i = 0; i < str1.length(); i++) {
			char mo = str1.charAt(i);
			if (i == (str1.length() - 1)) {
				System.out.println("あああああ" + s);
				sum[s] = number;
			} else {
				if (mo == '+' || mo == '-' || mo == '*' || mo == '/') {
					//配列sumに代入？
					sum[s] = number;
					s++;
					sum[s] = String.valueOf(mo);//数値から文字列の変換
					s++;
					number = "";
				} else {
					//変数numberにmoを代入
					number = number + mo;
				}
			}
		}
		//for文で繰り返し処理
		for (int j = 0; j < sum.length; j++) {
			if (sum[j] == null) {
				break;
			}
			if (j == 0) {
				goukei = Integer.parseInt(sum[j]);
			} else {
				if (sum[j].equals("*") || sum[j].equals("/") || sum[j].equals("+") || sum[j].equals("-")) {
					enzan = sum[j].charAt(0);
				} else {
					//switch文で条件によって処理をコントロール
					switch (enzan) {
					case '*':
						goukei *= Integer.parseInt(sum[j]);
						break;
					case '/':
						goukei /= Integer.parseInt(sum[j]);
						break;
					case '+':
						goukei += Integer.parseInt(sum[j]);
						break;
					case '-':
						goukei -= Integer.parseInt(sum[j]);
						break;
					default:
						System.out.println("計算できません。もう一度入力し直してください。");
						break;
					}
				}
			}
		}
		//合計
		System.out.println("合計は" + goukei + "です。");
	}
}
