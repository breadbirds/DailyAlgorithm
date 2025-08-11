package source_code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B_S3_NandM3 {
	static int N;
	static int M;
	static List<Integer> numList;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		sb = new StringBuilder();

		N = Integer.parseInt(s.split(" ")[0]);
		M = Integer.parseInt(s.split(" ")[1]);
		numList = new ArrayList<>();

		findSequence(0);

		System.out.println(sb);

	}

	private static void findSequence(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numList.get(i));

				if (i != M - 1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			numList.add(i);

			findSequence(depth + 1);

			numList.remove(numList.size() - 1);
		}

	}
}
