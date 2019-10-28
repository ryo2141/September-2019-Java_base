package dentaku;

public class Dentaku05 {
	public static void main(String[] args) {
		String formula = "2*3";
		System.out.println(parseAndCalc(formula));

	}

	static double parseAndCalc(String formula) {
		char[] opes = { '+', '-', '*', '/' };
		char ope = ' ';
		int opeIdx = 0;
		for (char o : opes) {
			opeIdx = formula.indexOf(o);
			if (opeIdx != -1) {
				ope = formula.charAt(opeIdx);
				break;
			}
		}

		double x = Double.parseDouble(formula.substring(0, opeIdx));
		double y = Double.parseDouble(formula.substring(opeIdx + 1, formula.length()));

		double answer;
		if (ope == '+') {
			answer = x + y;
		} else if (ope == '-') {
			answer = x - y;
		} else if (ope == '*') {
			answer = x * y;
		} else {
			answer = x / y;
		}
		return answer;
	}
}
