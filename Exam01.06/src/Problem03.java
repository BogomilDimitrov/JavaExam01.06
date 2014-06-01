import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Problem03 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		String inputLine = scan.nextLine();
		
		//Taking out only the digits
		Pattern digitPat = Pattern.compile("[\\d\\.]+");
		Matcher digitMatch = digitPat.matcher(inputLine);
		
		ArrayList<String> digits = new ArrayList<>();
		
		while (digitMatch.find()) {
			digits.add(digitMatch.group());
		}
		//Taking out only the operators
		Pattern operatorPat = Pattern.compile("[-+]+");
		Matcher operatorMatch = operatorPat.matcher(inputLine);
		
		ArrayList<String> operators = new ArrayList<>();
		
		while (operatorMatch.find()) {
			operators.add(operatorMatch.group());
		}
		
		
		BigDecimal result = new BigDecimal(digits.get(0));
		for (int i = 0; i < operators.size(); i++) {
			if (operators.get(i).equals("+")) {
				result = result.add(new BigDecimal(digits.get(i+1)));
			}else {
				result = result.subtract(new BigDecimal(digits.get(i+1)));
			}
		}
		
		System.out.println(result.toPlainString());

	}

}
