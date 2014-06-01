import java.util.Scanner;
import java.util.TreeMap;

public class Problem04 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		int n = Integer.parseInt(scan.nextLine());
		TreeMap<String, TreeMap<String, Integer>> users = new TreeMap<>();
		String[] readLine = new String[n * 3];
		
		//Input
		for (int i = 0; i < n; i++) {
			readLine = scan.nextLine().split(" ");
			if (users.get(readLine[1]) == null) { //If the user doesn't have a record
				users.put(readLine[1], new TreeMap<>());
				users.get(readLine[1]).put(readLine[0], Integer.parseInt(readLine[2]));
			}else if (users.get(readLine[1]).get(readLine[0]) != null) { //If the IP has already minutes
				int newMinutes = users.get(readLine[1]).get(readLine[0]) + Integer.parseInt(readLine[2]);
				users.get(readLine[1]).put(readLine[0], newMinutes);
			}else{ //If the IP doesn't have a record
				users.get(readLine[1]).put(readLine[0], Integer.parseInt(readLine[2]));
			}
		}
		
		//Output
		for (String user : users.keySet()) {
			System.out.print(user + ": ");
			int minutes = 0;
			for (String ip : users.get(user).keySet()) {
				minutes += users.get(user).get(ip);
			}
			System.out.print(minutes + " ");
			System.out.print(users.get(user).keySet().toString().replace("{", "[").replace("}", "]").replace("=", ""));
			System.out.println();
			
		}
	}

}
