package source_code;

import java.io.*;
import java.util.*;

public class B_S3_2075_theNthLargestNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> numberList = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				numberList.add(Integer.parseInt(st.nextToken()));
			}
		}

		numberList.sort(Comparator.reverseOrder());

		System.out.println(numberList.get(N - 1));

	}

}
