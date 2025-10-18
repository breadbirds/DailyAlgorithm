package source_code;

import java.io.*;
import java.util.*;

public class B_S3_1449_Repairman {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // ���� ���� ���� ����
		int L = Integer.parseInt(st.nextToken()); // �������� ����
		int[] input = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		// �������� ����
		Arrays.sort(input);
		int result = 1; // ������ ����
		int first = 0;

		for (int i = 1; i < N; i++) {
			if (input[i] - input[first] >= L) {
				result++;
				first = i;
			}
		}

		System.out.println(result);
	}
}
