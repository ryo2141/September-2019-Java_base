package fileSearchMiyauchi_jibun;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * ファイル検索クラス
 * @author miyauchi
 *
 */
public class FileSearchMiyauchi {
	/**
	 * メインメソッド
	 * @param args 実行時に渡されるコマンドライン変数
	 */
	public static void main(String[] args) throws IOException {

		//FilenameFilterも可
		//Fileインスタンス作成
		File file = new File("C:\\kensyu\\kadai01\\in");

		//listFilesメソッドで一覧を取得
		File[] list = file.listFiles();

		//「C:\\kensyu\\kadai01\\in」のinフォルダーの中身をループさせて検索する
		for (int i = 0; i < list.length; i++) {

			//三桁の半角数字が含まれる場合
			if (list[i].getName().matches(".*[0-9]{3}.*")) {

				//新たにファイルを作成
				File file02 = new File("C:\\kensyu\\kadai01\\in\\" + list[i].getName());

				//ファイル読み込み
				BufferedReader br = new BufferedReader(new FileReader(file02));
				String str = br.readLine();

				//ファイルから読み出した文を文字ごとに比較して、同じならカウント。
				while (str != null) {
					char[] c = str.toCharArray();

					//文字比較ループ
					for (char c1 : c) {
						int count = 0;

						for (char c2 : c) {
							//c1とc2の文字が一致した場合
							if (c1 == c2) {
								count++;
							}
						}

						//3以上の場合
						if (count >= 3) {
							System.out.println("【" + list[i].getName() + "】" + "<" + str + ">");
							break;
						}
					}
					str = br.readLine();
				}
				br.close();
				//System.out.println(list[i]);
			}

		}

	}
}
