package source_code;

import java.io.*;
import java.util.*;

public class B_S2_2805_CuttingWood {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] treeHeight = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			treeHeight[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(treeHeight);

		// binary search
		int left = 0;
		int right = treeHeight[N - 1];
		int ans = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			int cal = 0;

			for (int i = N - 1; i >= 0; i--) {
				if (treeHeight[i] > mid) {
					cal += treeHeight[i] - mid;
				}
				if (cal >= M)
					break;
			}

			if (cal >= M) {
				ans = mid;
				left = mid + 1;
			} else if (cal < M) {
				right = mid - 1;
			}
		}

		System.out.println(ans);
	}

}
