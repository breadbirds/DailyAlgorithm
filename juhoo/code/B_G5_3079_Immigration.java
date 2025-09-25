package source_code;

import java.io.*;
import java.util.*;

public class B_G5_3079_Immigration {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // �ɻ�� ����
		int M = Integer.parseInt(st.nextToken()); // ��� ��
		int[] time = new int[N]; // �ɻ�뺰 �ɻ� �ð�

		for (int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(time);

		long lo = 1; // ���� ���� �ð�
		long hi = (long) time[0] * M; // ���� �ִ� �ð�
		long ans = 0; // �� �ɸ� �ð�

		while (lo <= hi) {
			long mid = (lo + hi) / 2;

			// mid �ð����� �ɻ� ������ ��� �� ���
			long cal = 0L;
			for (int i = 0; i < N; i++) {
				if (cal > M) {
					break;
				}

				cal += mid / time[i]; // mid �ð���ŭ �� �ɻ�뿡�� �ɻ縦 ���ÿ� �ϸ鼭 �ð� üũ
			}

			if (cal >= M) {
				ans = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}

		System.out.println(ans);
	}

}
