package dentaku02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
	private Map<String, Integer> degrees;
	private List<String> factorKinds;
	private List<String> binaryKinds;
	private List<String> rightAssocs;

	private List<Token> tokens;
	private int i;

	public Parser() {
		degrees = new HashMap<>();
		degrees.put("*", 60);
		degrees.put("/", 60);
		degrees.put("+", 50);
		degrees.put("-", 50);
		degrees.put("=", 10);
		factorKinds = Arrays.asList(new String[] { "digit", "variable" });
		binaryKinds = Arrays.asList(new String[] { "sign" });
		rightAssocs = Arrays.asList(new String[] { "=" });
	}

	public Parser init(List<Token> tokens) {
		i = 0;
		this.tokens = new ArrayList<Token>(tokens);
		Token eob = new Token();
		eob.kind = "eob";
		eob.value = "(eob)";
		this.tokens.add(eob);
		return this;
	}

	private Token token() throws Exception {
		if (tokens.size() <= i) {
			throw new Exception("No more token");
		}
		return tokens.get(i);
	}

	private Token next() throws Exception {
		Token t = token();
		++i;
		return t;
	}

	private Token lead(Token token) throws Exception {
		if (factorKinds.contains(token.kind)) {
			return token;
		} else {
			throw new Exception("The token cannot place there.");
		}
	}

	private int degree(Token t) {
		if (degrees.containsKey(t.value)) {
			return degrees.get(t.value);
		} else {
			return 0;
		}
	}

	private Token bind(Token left, Token operator) throws Exception {
		if (binaryKinds.contains(operator.kind)) {
			operator.left = left;
			int leftDegree = degree(operator);
			if (rightAssocs.contains(operator.value)) {
				leftDegree -= 1;
			}
			operator.right = expression(leftDegree);
			return operator;
		} else {
			throw new Exception("The token cannot place there.");
		}
	}

	public Token expression(int LeftDegree) throws Exception {
		Token left = lead(next());
		int rightDegree = degree(token());
		while (LeftDegree < rightDegree) {
			Token operator = next();
			left = bind(left, operator);
			rightDegree = degree(token());
		}
		return left;
	}

	public List<Token> block() throws Exception {
		List<Token> blk = new ArrayList<Token>();
		while (!token().kind.equals("eob")) {
			blk.add(expression(0));
		}
		return blk;
	}

	public static void main(String[] args) throws Exception {
		System.out.println("例：a = 4 + 5 * 2");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();

		List<Token> tokens = new Lexer().init(text).tokenize();
		List<Token> blk = new Parser().init(tokens).block();
		for (Token asToken : blk) {
			System.out.println(asToken.paren());
		}

	}

}
