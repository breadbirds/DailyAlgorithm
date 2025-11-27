package source_code;

import java.io.*;
import java.util.*;

public class B_S5_1436_MovieDirectorShom {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		String num = "0";

		while (cnt < N) {
			num = String.valueOf(Integer.parseInt(num) + 1);

			if (num.contains("666")) {
				cnt++;
			}
		}

		System.out.println(num);
	}

}
