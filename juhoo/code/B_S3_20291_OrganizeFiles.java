package source_code;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class B_S3_20291_OrganizeFiles {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> result = new TreeMap<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), ".");
			st.nextToken();
			result.merge(st.nextToken(), 1, Integer::sum);
		}

		StringBuilder sb = new StringBuilder();

		for (Entry<String, Integer> e : result.entrySet()) {
			sb.append(e.getKey()).append(" ").append(e.getValue()).append("\n");
		}

		System.out.println(sb);
	}
}
