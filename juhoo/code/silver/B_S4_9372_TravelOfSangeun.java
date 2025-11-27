package source_code;

import java.io.*;
import java.util.*;

public class B_S4_9372_TravelOfSangeun {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < testCase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			for (int i = 0; i < M; i++) {
				br.readLine();
			}
			System.out.println(N - 1);
		}
	}

}
