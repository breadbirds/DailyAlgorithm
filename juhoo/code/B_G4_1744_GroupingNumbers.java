package source_code;

import java.io.*;
import java.util.*;

public class B_G4_1744_GroupingNumbers {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // ������ ũ��
		List<Integer> numbers = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			numbers.add(Integer.parseInt(br.readLine()));
		}

		// ����
		Collections.sort(numbers);

		int result = 0;
		boolean isPositive = false;

		while (numbers.size() > 0) {
			int cur = numbers.get(0);

			if (numbers.size() == 1) {
				result += cur;
				numbers.remove(0);
			} else if (cur <= 1) {
				if (cur < 0 && numbers.get(1) < 0) { // ���� �����̸� ���ؼ� ����� ����
					result += cur * numbers.get(1);
					numbers.remove(0);
					numbers.remove(0);
				} else if (cur < 0 && numbers.contains(0)) { // ���� ���� �����ε� 0�� �����Ѵٸ� ���ؼ� 0���� ����
					numbers.remove(numbers.indexOf(0));
					numbers.remove(0);
				} else { // �������� �׳� ����
					result += cur;
					numbers.remove(0);
				}
			} else { // 1�� ������ ����� ��� ���ؼ� ���ϱ�
				// ��������� ū ������ ���ϱ� ���� �ٽ� ���� ����
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
