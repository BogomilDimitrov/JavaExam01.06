import java.util.ArrayList;
import java.util.Scanner;


public class Problem01{

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner (System.in);
		int n = scan.nextInt();
		int[] numbers = new int[n];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i]=scan.nextInt();
		}
		if (n<4) {
			System.out.println("No");
		}
		ArrayList<String> output = new ArrayList<>();

		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				for (int j2 = 0; j2 < numbers.length; j2++) {
					for (int k = 0; k < numbers.length; k++) {
						boolean check= numbers[i]!=numbers[j]&&numbers[j]!=numbers[j2]
									 &&numbers[i]!=numbers[j2]&&numbers[i]!=numbers[k]
									 &&numbers[j]!=numbers[k]&&numbers[j2]!=numbers[k];
						if (check&&(""+numbers[i]+numbers[j]).equals(""+numbers[j2]+numbers[k])) {
							output.add(numbers[i]+"|"+numbers[j]+"=="+numbers[j2]+"|"+numbers[k]);
						}
					}
				}
			}
		}
		for (int i = 0; i < output.size(); i++) {
			System.out.println(output.get(i));
		}
		if (output.isEmpty()) {
			System.out.println("No");
		}
	}
}

