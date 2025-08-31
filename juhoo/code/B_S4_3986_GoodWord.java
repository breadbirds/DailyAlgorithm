package source_code;

import java.io.*;
import java.util.*;

public class B_S4_3986_GoodWord {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;

		for (int i = 0; i < N; i++) {
			Stack<Character> stack = new Stack<>();
			String str = br.readLine();

			for (int j = 0; j < str.length(); j++) {
				if (stack.isEmpty()) {
					stack.add(str.charAt(j));
				} else if (stack.peek() != str.charAt(j)) {
					stack.add(str.charAt(j));
				} else {
					while (!stack.isEmpty() && stack.peek() == str.charAt(j)) {
						stack.pop();
					}
				}

			}

			if (stack.size() == 0) {
				result++;
			}

		}

		System.out.println(result);

	}
}
