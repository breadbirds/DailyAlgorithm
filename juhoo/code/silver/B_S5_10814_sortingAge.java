package source_code;

import java.io.*;
import java.util.*;

public class B_S5_10814_sortingAge {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] members = new String[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			members[i][0] = st.nextToken();
			members[i][1] = st.nextToken();
		}

		Arrays.sort(members, (o1, o2) -> {
			int n1 = Integer.parseInt(o1[0]);
			int n2 = Integer.parseInt(o2[0]);

			return n1 - n2;
		});

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(members[i][0]).append(" ").append(members[i][1]).append("\n");
		}

		System.out.println(sb);
	}
}
