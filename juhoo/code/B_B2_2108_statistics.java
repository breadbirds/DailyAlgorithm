package source_code;

import java.io.*;
import java.util.*;

public class B_B2_2108_statistics {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numList = new int[N];

		for (int i = 0; i < N; i++) {
			numList[i] = Integer.parseInt(br.readLine());
		}

		mean(numList);
		median(numList);
		mode(numList);
		range(numList);

	}

	private static void range(int[] numList) {
		Arrays.sort(numList);

		System.out.println(numList[numList.length - 1] - numList[0]);
	}

	private static void mode(int[] numList) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < numList.length; i++) {
			map.put(numList[i], map.getOrDefault(numList[i], 0) + 1);
		}

		List<Integer> keySet = new ArrayList<>(map.keySet());

		keySet.sort((a, b) -> {
			int cmp = Integer.compare(map.get(b), map.get(a));

			if (cmp != 0)
				return cmp;

			return Integer.compare(b, a);
		});

		if (map.size() > 1 && map.get(keySet.get(0)) == map.get(keySet.get(1))) {
			int i = 0;

			while (i < map.size() - 1 && map.get(keySet.get(i)) == map.get(keySet.get(i + 1))) {
				i++;
			}

			System.out.println(keySet.get(i - 1));
		} else {
			System.out.println(keySet.get(0));
		}

	}

	private static void median(int[] numList) {
		Arrays.sort(numList);
		int middleIndex = numList.length / 2;

		System.out.println(numList[middleIndex]);
	}

	private static void mean(int[] numList) {
		int result = 0;
		for (int i = 0; i < numList.length; i++) {
			result += numList[i];
		}

		System.out.println(Math.round((float) result / numList.length));
	}

}
