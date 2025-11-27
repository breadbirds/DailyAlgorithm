package source_code;

import java.io.*;
import java.util.*;

public class B_B3_5086_MultipleAndDivisor {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		while (a != 0 && b != 0) {
			if (isFactor(a, b)) {
				sb.append("factor").append("\n");
			} else if (isMultiple(a, b)) {
				sb.append("multiple").append("\n");
			} else {
				sb.append("neither").append("\n");
			}

			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
		}

		System.out.println(sb);
	}

	private static boolean isMultiple(int a, int b) {
		if (a % b == 0) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean isFactor(int a, int b) {
		if (b % a == 0) {
			return true;
		} else {
			return false;
		}
	}

}
