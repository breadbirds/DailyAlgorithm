package source_code;

import java.io.*;
import java.util.*;

public class B_B2_2798_Blackjack {
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] cards = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		solve(0, cards, M, 0, 0);

		System.out.println(result);
	}

	private static void solve(int sum, int[] cards, int m, int depth, int start) {
		if (depth == 3) {
			if (sum == m) {
				result = m;
			} else if (sum < m) {
				result = Math.max(result, sum);
			}
			return;
		}

		for (int i = start; i < cards.length; i++) {
			solve(sum + cards[i], cards, m, depth + 1, i + 1);
		}
	}

}
