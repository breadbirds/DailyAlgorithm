package Algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4153_20250623 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while ((input = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(input);

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 0 && b == 0 && c == 0) {
				break;
			}

			if (a >= b && a >= c) {
				if (b * b + c * c == a * a) {
					System.out.println("right");
				} else {
					System.out.println("wrong");
				}
			} else if (b >= a && b >= c) {
				if (a * a + c * c == b * b) {
					System.out.println("right");
				} else {
					System.out.println("wrong");
				}
			} else if (c >= a && c >= b) {
				if (a * a + b * b == c * c) {
					System.out.println("right");
				} else {
					System.out.println("wrong");
				}
			}

		}
	}

}
