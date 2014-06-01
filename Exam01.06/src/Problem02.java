import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem02 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		String input = scan.nextLine();
		ArrayList<Integer> cardsHand = new ArrayList<>();
		Pattern cardPat = Pattern.compile("[\\dJQKA]+");
		Matcher cardMatch = cardPat.matcher(input);

		while (cardMatch.find()) {
			if (cardMatch.group().equals("J")) {
				cardsHand.add(12);
			} else if (cardMatch.group().equals("Q")) {
				cardsHand.add(13);
			} else if (cardMatch.group().equals("K")) {
				cardsHand.add(14);
			} else if (cardMatch.group().equals("A")) {
				cardsHand.add(15);
			} else {
				cardsHand.add(Integer.parseInt(cardMatch.group()));

			}
		}
		
		int weight = 0;
		for (int i = 0; i <= cardsHand.size() - 1; i++) {
			int equalCards = 1;
			int tempWeight = 0;
			for (int j = i+1; j <= cardsHand.size() - 1; j++) {
				if (cardsHand.get(i) == cardsHand.get(j)) {
					equalCards++;
				}else {
					break;
				}
			}
			tempWeight += equalCards * cardsHand.get(i);
			if (equalCards != 1) {
				tempWeight *= 2;
			}
			weight += tempWeight;
			i+= equalCards-1;
		}
		
		System.out.println(weight);

	}

}
