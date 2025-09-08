package source_code;

import java.io.*;
import java.util.*;

public class B_S3_17204_GameOfDeath {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer> game = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			game.add(Integer.parseInt(br.readLine()));
		}

		int result = 0;
		int curIndex = 0;

		while (curIndex != M) {
			if (result > N) {
				result = -1;
				break;
			}
			result++;
			curIndex = game.get(curIndex);
		}

		System.out.println(result);
	}

}
