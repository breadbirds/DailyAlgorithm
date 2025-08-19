package source_code;

import java.io.*;
import java.util.*;

public class B_11651_S5_sortingCoordinates2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] inputArray = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			inputArray[i][0] = Integer.parseInt(st.nextToken());
			inputArray[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(inputArray, Comparator.comparing((int[] p) -> p[1]).thenComparing(p -> p[0]));

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(inputArray[i][0]);
			sb.append(" ");
			sb.append(inputArray[i][1]);
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
