package source_code;

import java.io.*;
import java.util.*;

// 재현: 잘못된 수를 부르면 0을 외침 & 가장 최근 재민이가 쓴 수 지움
// 구하는 것: 모든 수의 합

public class B_S4_20773_Zero {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Long> stack = new Stack<>();

		for (int i = 0; i < K; i++) {
			long num = Long.parseLong(br.readLine());

			if (num != 0) {
				stack.add(num);
			} else {
				stack.pop();
			}
		}

		long sum = 0;
		for (int i = 0; i < stack.size(); i++) {
			sum += stack.get(i);
		}

		System.out.println(sum);
	}

}
