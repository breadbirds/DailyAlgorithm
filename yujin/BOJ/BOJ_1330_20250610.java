package Algo;

import java.util.Scanner;

public class BOJ_1330_20250610 {
	public static void main(String[] args) {
		int a, b;
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		if (a > b) {
			System.out.println(">");
		}
		if (a < b) {
			System.out.println("<");

		}
		if (a == b) {
			System.out.println("==");
		}

	}

}
