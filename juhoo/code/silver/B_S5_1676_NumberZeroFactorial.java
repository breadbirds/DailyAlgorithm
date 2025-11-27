package source_code;

import java.io.*;
import java.util.*;

public class B_S5_1676_NumberZeroFactorial {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Integer.parseInt(br.readLine());
		long result = 0;

		int multiple = 5;

		while (true) {
			if (N / multiple == 0) {
				break;
			}

			result += N / multiple;
			multiple *= 5;
		}

		System.out.println(result);
	}

}
