package source_code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B_S2_6603_Lottery {
	static int k;
	static int[] list;
	static StringBuilder sb;
	static List<Integer> l;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		sb = new StringBuilder();

		while (true) {
			k = Integer.parseInt(s.split(" ")[0]);
			
			list = new int[k];
			l = new ArrayList<>();

			for (int i = 1; i <= k; i++) {
				list[i - 1] = Integer.parseInt(s.split(" ")[i]);
			}

			calLotteryNumbers(0, 0);
			
			// 다음 줄 확인
			s = br.readLine();

			if (s.equals("0"))
				break;
			
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void calLotteryNumbers(int depth, int start) {
		if (depth == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(l.get(i));

				if (i != 5) {
					sb.append(" ");
				}
			}
			
			sb.append("\n");

			return;
		}

		for (int i = start; i < k; i++) {
			l.add(list[i]);

			calLotteryNumbers(depth + 1, i + 1);

			l.remove(l.size() - 1);
		}
	}
}
