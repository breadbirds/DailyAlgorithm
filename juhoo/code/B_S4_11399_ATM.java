package source_code;

import java.io.*;
import java.util.*;

public class B_S4_11399_ATM {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // ����� ��
		int[] input = new int[N]; // �� ����� ���� �����ϴµ� �ɸ��� �ð�

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		// �������� ����
		Arrays.sort(input);

		// ������� �ð� ���
		int lastTime = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += lastTime + input[i];
			lastTime = lastTime + input[i];
		}

		System.out.println(sum);
	}
}
