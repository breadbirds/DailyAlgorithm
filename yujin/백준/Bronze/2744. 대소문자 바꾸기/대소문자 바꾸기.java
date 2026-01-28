import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();

		for (int i = 0; i < input.length(); i++) {
			char answer = input.charAt(i);
			if (Character.isUpperCase(answer)) {
				System.out.print(Character.toLowerCase(answer));
			} else {
				System.out.print(Character.toUpperCase(answer));
			}
		}

	}

}