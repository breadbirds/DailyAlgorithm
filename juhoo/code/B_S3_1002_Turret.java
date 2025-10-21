package source_code;

import java.io.*;
import java.util.*;

public class B_S3_1002_Turret {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());

			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			// �� ���� ������ �Ÿ�
			double rLength = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

			if (x1 == x2 && y1 == y2 && r1 == r2) { // ������ ��ħ
				sb.append(-1).append("\n");
			} else if (rLength < Math.abs(r1 - r2)) { // �� ���ο��� �ȸ����� ���
				sb.append(0).append("\n");
			} else if (rLength == Math.abs(r1 - r2)) { // ����
				sb.append(1).append("\n");
			} else if (rLength > r1 + r2) { // �� �ܺο��� �ȸ����� ���
				sb.append(0).append("\n");
			} else if (rLength == r1 + r2) { // ����
				sb.append(1).append("\n");
			} else {
				sb.append(2).append("\n");
			}

		}

		System.out.println(sb);
	}

}
