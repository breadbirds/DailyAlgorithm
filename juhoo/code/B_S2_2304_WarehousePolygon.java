package source_code;

import java.io.*;
import java.util.*;

public class B_S2_2304_WarehousePolygon {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // ����� ����
		int[][] pillar = new int[N][2]; // ����� x�� ��ġ�� ����

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pillar[i][0] = Integer.parseInt(st.nextToken()); // x�� ��ġ
			pillar[i][1] = Integer.parseInt(st.nextToken()); // ����
		}

		// x�� ��ǥ �������� �������� ����
		Arrays.sort(pillar, (s1, s2) -> {
			return Integer.compare(s1[0], s2[0]);
		});

		int area = 0; // ���
		int[] prev = pillar[0]; // ���� max ��� ����
		int idx = 0;

		if (N == 1) {
			area = prev[1];
		} else {
			for (int i = 1; i < N; i++) {
				int height = pillar[i][1];
				int x = pillar[i][0];

				// �� ���� ���̰� ������ ���� ���� �߰�
				if (height >= prev[1]) {
					area += (x - prev[0]) * prev[1];
					prev = pillar[i]; // ����
					idx = i;
				}
			}

			// max �� �κ� ���
			area += prev[1];

			prev = pillar[N - 1];

			for (int i = N - 2; i >= idx; i--) {
				int height = pillar[i][1];
				int x = pillar[i][0];

				// �� ���� ���̰� ������ ���� ���� �߰�
				if (height >= prev[1]) {
					area += (prev[0] - x) * prev[1];
					prev = pillar[i]; // ����
				}
			}

		}

		System.out.println(area);
	}
}
