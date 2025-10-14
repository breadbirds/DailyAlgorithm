package source_code;

import java.io.*;
import java.util.*;

public class B_B2_5585_Change {
	static int result;
	static int change;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine()); // 타로가 지불할 돈
		change = 1000 - input;
		result = 0;

		getChange(500);
		getChange(100);
		getChange(50);
		getChange(10);
		getChange(5);
		getChange(1);
		
		System.out.println(result);
	}

	private static void getChange(int num) {
		if (change >= num) {
			result += change / num;
			change %= num;
		}
	}

}
