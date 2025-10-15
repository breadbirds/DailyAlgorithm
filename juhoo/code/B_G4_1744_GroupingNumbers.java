package source_code;

import java.io.*;
import java.util.*;

public class B_G4_1744_GroupingNumbers {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 수열의 크기
		List<Integer> numbers = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			numbers.add(Integer.parseInt(br.readLine()));
		}

		// 정렬
		Collections.sort(numbers);

		int result = 0;
		boolean isPositive = false;

		while (numbers.size() > 0) {
			int cur = numbers.get(0);

			if (numbers.size() == 1) {
				result += cur;
				numbers.remove(0);
			} else if (cur <= 1) {
				if (cur < 0 && numbers.get(1) < 0) { // 음수 연속이면 곱해서 양수로 만듦
					result += cur * numbers.get(1);
					numbers.remove(0);
					numbers.remove(0);
				} else if (cur < 0 && numbers.contains(0)) { // 남은 유일 음수인데 0이 존재한다면 곱해서 0으로 만듦
					numbers.remove(numbers.indexOf(0));
					numbers.remove(0);
				} else { // 나머지는 그냥 더함
					result += cur;
					numbers.remove(0);
				}
			} else { // 1을 제외한 양수의 경우 곱해서 더하기
				// 양수에서는 큰 수부터 곱하기 위해 다시 역순 정렬
				if (isPositive == false) {
					Collections.reverse(numbers);
					isPositive = true;
				}

				result += (numbers.get(0) * numbers.get(1));
				numbers.remove(0);
				numbers.remove(0);
			}
		}

		System.out.println(result);
	}

}
