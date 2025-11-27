package source_code;

import java.io.*;
import java.util.*;

public class B_B3_3009_ForthPoint {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] input = new int[3][2];

		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}

		Map<Integer, Integer> cal = new HashMap<>();
		Map<Integer, Integer> cal2 = new HashMap<>();

		for (int i = 0; i < 3; i++) {
			cal.put(input[i][0], cal.getOrDefault(input[i][0], 0) + 1);
			cal2.put(input[i][1], cal2.getOrDefault(input[i][1], 0) + 1);
		}

		int resultX = 0;
		int resultY = 0;

		for (int k : cal.keySet()) {
			if (cal.get(k) == 1) {
				resultX = k;
				break;
			}
		}

		for (int k : cal2.keySet()) {
			if (cal2.get(k) == 1) {
				resultY = k;
				break;
			}
		}

		System.out.println(resultX + " " + resultY);
	}

}
