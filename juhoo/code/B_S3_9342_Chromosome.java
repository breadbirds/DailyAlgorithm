package source_code;

import java.io.*;
import java.util.*;

public class B_S3_9342_Chromosome {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] startEnd = { 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] order = { 'A', 'F', 'C' };

		for (int i = 0; i < N; i++) {
			String result = "Infected!";
			String str = br.readLine();
			int idx = 0;
			int orderIdx = 0;

			loop1: while (idx < str.length()) {
				if (order[orderIdx] == str.charAt(idx)) {
					idx++;
				} else if (orderIdx < 2 && order[orderIdx + 1] == str.charAt(idx)) {
					orderIdx++;
				} else if (idx == 0 || idx == str.length() - 1) {
					for (int j = 0; j < startEnd.length; j++) {
						if (startEnd[j] == str.charAt(idx)) {
							idx++;
							continue loop1;
						} else if (j == startEnd.length - 1) {
							result = "Good";
							break loop1;
						}
					}
				} else {
					result = "Good";
					break;
				}
			}

			System.out.println(result);
		}
	}

}
