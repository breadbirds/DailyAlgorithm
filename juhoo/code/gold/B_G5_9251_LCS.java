package source_code;

import java.io.*;
import java.util.*;

public class B_G5_9251_LCS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();

		// str1, str2의 각 인덱스까지 봤을 때 lcs 길이
		// {str1 idx, str2 idx}
		int[][] dp = new int[str1.length + 1][str2.length + 1];

		for (int i = 0; i < str1.length; i++) {
			for (int j = 0; j < str2.length; j++) {
				if (str1[i] == str2[j]) {
					dp[i][j] = (i != 0 && j != 0) ? dp[i - 1][j - 1] + 1 : 1;
				} else {
					dp[i][j] = Math.max((i > 0 ? dp[i - 1][j] : 0), (j > 0 ? dp[i][j - 1] : 0));
				}
			}
		}

		System.out.println(dp[str1.length - 1][str2.length - 1]);
	}

}
