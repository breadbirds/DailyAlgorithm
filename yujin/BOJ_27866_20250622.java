package Algo;

import java.util.Scanner;

public class BOJ_27866_20250622 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		int i = sc.nextInt();
		char answer = 'a';

		for (int j = 0; j < S.length(); j++) {
			answer = S.charAt(i - 1);
		}
		
		System.out.println(answer);
	}

}
