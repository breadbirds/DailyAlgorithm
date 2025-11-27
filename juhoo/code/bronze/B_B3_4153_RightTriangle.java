package source_code;

import java.io.*;
import java.util.*;

public class B_B3_4153_RightTriangle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] triangle = new int[3];

		triangle[0] = Integer.parseInt(st.nextToken());
		triangle[1] = Integer.parseInt(st.nextToken());
		triangle[2] = Integer.parseInt(st.nextToken());

		while (triangle[0] != 0 && triangle[1] != 0 && triangle[2] != 0) {
			String result = "right";

			Arrays.sort(triangle);

			int a = triangle[0];
			int b = triangle[1];
			int c = triangle[2];

			if (a * a + b * b != c * c) {
				result = "wrong";
			}

			// 입력받기
			st = new StringTokenizer(br.readLine());
			triangle[0] = Integer.parseInt(st.nextToken());
			triangle[1] = Integer.parseInt(st.nextToken());
			triangle[2] = Integer.parseInt(st.nextToken());

			System.out.println(result);
		}
	}

}
