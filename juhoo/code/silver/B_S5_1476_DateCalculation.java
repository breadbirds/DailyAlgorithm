package source_code;

import java.io.*;
import java.util.*;

// {지구, 태양, 달} = {E, S, M} 
// 1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19

public class B_S5_1476_DateCalculation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int e = 1, s = 1, m = 1;
		int result = 1;

		while (e != E || s != S || m != M) {
			e = (e == 15) ? 1 : e + 1;
			s = (s == 28) ? 1 : s + 1;
			m = (m == 19) ? 1 : m + 1;
			result++;
		}

		System.out.println(result);
	}
}
