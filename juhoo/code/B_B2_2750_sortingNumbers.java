package source_code;

import java.io.*;
import java.util.*;

public class B_B2_2750_sortingNumbers {
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

		for (int i = 0; i < N; i++) {
			System.out.println(result[i]);
		}
	}
}
