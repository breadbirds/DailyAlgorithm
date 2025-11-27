package source_code;

import java.io.*;
import java.util.*;

public class B_B3_14215_ThreeSticks {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] input = str.split(" ");
		int[] sticks = new int[3];

		for (int i = 0; i < 3; i++) {
			sticks[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(sticks);

		if (sticks[2] >= sticks[0] + sticks[1]) {
			sticks[2] = sticks[0] + sticks[1] - 1;
		}

		System.out.println(sticks[0] + sticks[1] + sticks[2]);
	}

}
