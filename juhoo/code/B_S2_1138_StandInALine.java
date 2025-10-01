package source_code;

import java.io.*;
import java.util.*;

public class B_S2_1138_StandInALine {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // ��� ��
		int[] input = new int[N]; // �Է� ����
		List<Integer> list = new LinkedList<>(); // ��� ����

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		// �ڿ������� ���� ��� ����Ʈ�� �ֱ�
		for (int i = N - 1; i >= 0; i--) {
			int idx = input[i]; // ���ʿ������� �������� �ϴ� ��ġ (=���ʿ� ��ġ�� ū ��� ��)

			if (idx > list.size()) {
				idx = list.size() - 1;
			}

			list.add(idx, i + 1);
		}

		// ��� ���ڿ� �����
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(list.get(i));

			if (i != N - 1) {
				sb.append(" ");
			}
		}

		System.out.println(sb);
	}
}
