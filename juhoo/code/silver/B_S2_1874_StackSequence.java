package source_code;

import java.io.*;
import java.util.*;

public class B_S2_1874_StackSequence {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		int inputCnt = 0;
		int curNum = input[inputCnt];
		if (inputCnt < N - 1) {
			inputCnt++;
		}

		for (int i = 1; i <= N; i++) {
			if (stack.isEmpty() || curNum > stack.peek()) {
				stack.add(i);
				sb.append("+").append("\n");
			}

			while (!stack.isEmpty() && curNum == stack.peek()) {
				stack.pop();
				curNum = input[inputCnt];

				if (inputCnt < N - 1) {
					inputCnt++;
				}

				sb.append("-").append("\n");
			}

//			System.out.println(stack);
		}

		if (curNum == input[N - 1]) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}
	}
}
