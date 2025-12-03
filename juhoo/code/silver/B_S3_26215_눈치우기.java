package source_code;

import java.io.*;
import java.util.*;

public class B_S3_26215_´«Ä¡¿ì±â {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> snow = new ArrayList<>();
		int min = 0;

		for (int i = 0; i < N; i++) {
			snow.add(Integer.parseInt(st.nextToken()));
		}

		if (N == 1 && snow.get(0) > 1440) {
			System.out.println(-1);
			return;
		} else if (N == 1) {
			System.out.println(snow.get(0));
			return;
		}


		while (!snow.isEmpty()) {
			Collections.sort(snow);
			min++;

			if (snow.size() == 1) {
				int n = snow.get(0);
				snow.clear();
				if (n > 1) {
					snow.add(n - 1);
				}
			} else {
				int n = snow.get(snow.size() - 1);
				int n2 = snow.get(snow.size() - 2);
				snow.remove(snow.size() - 1);
				snow.remove(snow.size() - 1);

				if (n2 > 1) {
					snow.add(n2 - 1);
				}
				if (n > 1) {
					snow.add(n - 1);
				}
			}
		}

		if (min <= 1440) {
			System.out.println(min);
		} else {
			System.out.println(-1);
		}
	}

}
