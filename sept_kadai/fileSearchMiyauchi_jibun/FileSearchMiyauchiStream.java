package fileSearchMiyauchi_jibun;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * ファイル検索クラス
 * @author miyauchi
 *
 */
public class FileSearchMiyauchiStream {
	/**
	 * 実行クラス
	 * @param args コマンドライン引数
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		//Stream作成, C:\\kensyu\\kadai01\\in内の呼び出し
		Stream<Path> file = Files.list(Paths.get("C:\\kensyu\\kadai01\\in"));

		Predicate<String> pre = t -> {
			boolean bl = false;
			String[] strings = t.split("");

			//文字を比較して同じものを判定するループ
			for (String s1 : strings) {
				int count = 0;
				for (String s2 : strings) {
					if (s1.equals(s2)) {
						if (count < 2) {
							count++;
						} else {
							bl = true;
						}
					}
				}
			}
			//真偽値を返す
			return bl;
		};

		//表示のためのStream
		Consumer<Path> c = path -> {
			try {
				Files.lines(path).filter(pre)
						.forEach(str -> System.out.println("【" + path.getFileName() + "】" + str));
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		};

		//Predicate<Path> p = t -> t.getFileName().toString().matches(".*[0-9]{3}.*");
		//file.filter(t -> t.getFileName().toString().matches(".*[0-9]{3}.*")).forEach(System.out::println);

		//実際にファイル検索を行うStream
		file.filter(t -> t.getFileName().toString().matches(".*[0-9]{3}.*")).forEach(c);
		file.close();
	}
}

//stream
//Path
//File
//Files.lines