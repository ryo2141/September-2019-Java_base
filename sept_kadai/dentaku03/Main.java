package dentaku03;

class Source {

	private final String str;
	private int pos;

	public Source(String str) {
		this.str = str;
	}

	public final int peek() {
		if (pos < str.length()) {
			return str.charAt(pos);
		}
		return -1;
	}

	public final void next() {
		++pos;
	}
}

class Parser extends Source {

	public Parser(String str) {
		super(str);
	}

	public final int number() {
		StringBuilder sb = new StringBuilder();
		int ch;
		while ((ch = peek()) >= 0 && Character.isDigit(ch)) {
			sb.append((char) ch);
			next();
		}
		return Integer.parseInt(sb.toString());
	}

	// expr = term, {("+", term) | ("-", term)}
	public final int expr() {
		int x = term();
		for (;;) {
			switch (peek()) {
			case '+':
				next();
				x += term();
				continue;
			case '-':
				next();
				x -= term();
				continue;
			}
			break;
		}
		return x;
	}

	// term = factor, {("*", factor) | ("/", factor)}
	public final int term() {
		int x = factor();
		for (;;) {
			switch (peek()) {
			case '*':
				next();
				x *= factor();
				continue;
			case '/':
				next();
				x /= factor();
				continue;
			}
			break;
		}
		return x;
	}

	// factor = factor = [spaces], ("(", expr, ")") | number, [spaces]
	public final int factor() {
		int ret;
		spaces();
		if (peek() == '(') {
			next();
			ret = expr();
			if (peek() == ')') {
				next();
			}
		} else {
			ret = number();
		}
		spaces();
		return ret;
	}

	public void spaces() {
		while (peek() == ' ') {
			next();
		}
	}
}

public class Main {

	static void test(String s) {
		System.out.println(s + " = " + new Parser(s).expr());
	}

	public static void main(String[] args) {
		test("1 + 2");
		test("123");
		test("1 + 2 + 3");
		test("1 - 2 - 3");
		test("1 - 2 + 3");
		test("2 * 3 + 4");
		test("2 + 3 * 4");
		test("100 / 10 / 2");
		test("( 2 + 3 ) * 4");
	}
}