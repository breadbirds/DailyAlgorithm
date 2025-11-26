package source_code;

import java.io.*;
import java.util.*;

public class B_S2_2290_LCDTest {
	static char[][] lcd;
	static int s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken()); // 크기
		String n = st.nextToken(); // lcd 모니터에 나타내야 할 수
		lcd = new char[2 * s + 3][(s + 2) * n.length() + n.length() - 1];

		for (int i = 0; i < lcd.length; i++) {
		    Arrays.fill(lcd[i], ' ');
		}
		
		int startIdx = 0;
		for (int i = 0; i < n.length(); i++) {
			int curNum = n.charAt(i) - '0';
			fillArray(curNum, startIdx);
			startIdx += (s + 3);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 2 * s + 3; i++) {
			for (int j = 0; j < (s + 2) * n.length() + n.length() - 1; j++) {
				sb.append(lcd[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void fillArray(int curNum, int startX) {
		int width = s + 2; // 4
		int height = s * 2 + 3; // 7
		int mid = height / 2;

		switch (curNum) {
		case 0:
			makeHorizontalLine(startX, 0);
			makeHorizontalLine(startX, height - 1);

			makeVerticalLine(startX, 1, height);
			makeVerticalLine(startX + width - 1, 1, height);
			makeVerticalLine(startX, mid + 1, height);
			makeVerticalLine(startX + width - 1, mid + 1, height);
			break;

		case 1:
			makeVerticalLine((startX + width) / 2, 1, height);
			makeVerticalLine((startX + width) / 2, mid + 1, height);
			break;

		case 2:
			makeHorizontalLine(startX, 0);
			makeHorizontalLine(startX, mid);
			makeHorizontalLine(startX, height - 1);

			makeVerticalLine(startX + width - 1, 1, height);
			makeVerticalLine(startX, mid + 1, height);
			break;

		case 3:
			makeHorizontalLine(startX, 0);
			makeHorizontalLine(startX, mid);
			makeHorizontalLine(startX, height - 1);

			makeVerticalLine(startX + width - 1, 1, height);
			makeVerticalLine(startX + width - 1, mid + 1, height);
			break;

		case 4:
			makeHorizontalLine(startX, mid);

			makeVerticalLine(startX, 1, height);
			makeVerticalLine(startX + width - 1, 1, height);
			makeVerticalLine(startX + width - 1, mid + 1, height);
			break;

		case 5:
			makeHorizontalLine(startX, 0);
			makeHorizontalLine(startX, mid);
			makeHorizontalLine(startX, height - 1);

			makeVerticalLine(startX, 1, height);
			makeVerticalLine(startX + width - 1, mid + 1, height);
			break;

		case 6:
			makeHorizontalLine(startX, 0);
			makeHorizontalLine(startX, mid);
			makeHorizontalLine(startX, height - 1);

			makeVerticalLine(startX, 1, height);
			makeVerticalLine(startX, mid + 1, height);
			makeVerticalLine(startX + width - 1, mid + 1, height);
			break;

		case 7:
			makeHorizontalLine(startX, 0);

			makeVerticalLine(startX + width - 1, 1, height);
			makeVerticalLine(startX + width - 1, mid + 1, height);
			break;

		case 8:
			makeHorizontalLine(startX, 0);
			makeHorizontalLine(startX, mid);
			makeHorizontalLine(startX, height - 1);

			makeVerticalLine(startX, 1, height);
			makeVerticalLine(startX + width - 1, 1, height);
			makeVerticalLine(startX, mid + 1, height);
			makeVerticalLine(startX + width - 1, mid + 1, height);
			break;

		case 9:
			makeHorizontalLine(startX, 0);
			makeHorizontalLine(startX, mid);
			makeHorizontalLine(startX, height - 1);

			makeVerticalLine(startX, 1, height);
			makeVerticalLine(startX + width - 1, 1, height);
			makeVerticalLine(startX + width - 1, mid + 1, height);
			break;
		}
	}

	private static void makeHorizontalLine(int startX, int y) {
		for (int x = startX + 1; x <= startX + s; x++) {
			lcd[y][x] = '-';
		}
	}

	private static void makeVerticalLine(int startX, int y, int height) {
		for (int i = 0; i < (height - 2) / 2; i++) {
			lcd[y + i][startX] = '|';
		}
	}

}
