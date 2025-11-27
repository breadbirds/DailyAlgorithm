package source_code;

import java.io.*;
import java.util.*;

public class B_S2_17427_SumOfDivisor {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Integer.parseInt(br.readLine());
		long sum = 0;

		for (int i = 1; i <= N; i++) {
			sum += i * (N / i);
		}

		System.out.println(sum);
	}
}
