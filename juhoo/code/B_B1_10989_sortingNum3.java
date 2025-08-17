package source_code;

import java.io.*;
import java.util.*;

public class B_B1_10989_sortingNum3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int N = Integer.parseInt(s);
		int[] result = new int[N];

		for (int i = 0; i < N; i++) {
			s = br.readLine();
			result[i] = Integer.parseInt(s);
		}

		Arrays.sort(result);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(result[i]);
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
