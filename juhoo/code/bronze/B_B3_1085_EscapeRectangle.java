package source_code;

import java.io.*;
import java.util.*;

public class B_B3_1085_EscapeRectangle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		// 더 가까운 x와 y 값 찾기
		int minX = Math.min(x, w - x);
		int minY = Math.min(y, h - y);

		System.out.println(Math.min(minX, minY));
	}

}
