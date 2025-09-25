package source_code;

import java.io.*;
import java.util.*;

public class B_S2_1654_CuttingLANCable {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] cables = new int[N];

		for (int i = 0; i < K; i++) {
			cables[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(cables);

		long left = 0;
		long right = cables[N - 1];
		long ans = 0;

		while (left <= right) {
			long mid = (left + right) / 2;
			long cal = 0;

			if (mid == 0) {
				ans = cables[N - 1];
			}

			for (int i = N - 1; i >= 0; i--) {
				if (cables[i] < mid) {
					break;
				}

				cal += cables[i] / mid;
			}

			if (cal >= N) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(ans);
	}

}
