package source_code;

import java.io.*;
import java.util.*;

public class B_S5_11650_sortingCoordinate {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] coordinates = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			coordinates[i][0] = Integer.parseInt(st.nextToken());
			coordinates[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(coordinates, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] != o2[0] ? o1[0] - o2[1] : o1[1] - o2[1];
			}

		});

		for (int i = 0; i < N; i++) {
			System.out.println(coordinates[i][0] + " " + coordinates[i][1]);
		}
	}
}
