package source_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// �ּ����� ���̷� ���ٸ��� ������
// �ּ����� ������ �� ���� ���ϱ� (but ���ε��� ���� ��� ����)
// ���̰� H : ���� H, ������ H��ŭ ������

// �Է�: ���ٸ� ���� // ���ε� ���� // ��ġ�� �� �ִ� ���ε� ��ġ
// ���: ���ٸ� ���̸� ��� ���� �� �ִ� ���ε� �ּ� ����

public class B_S4_17266_DarkUnderpass {
	static List<Integer> lightDistance;

	public static void main(String[] args) {
		// 1. �Է¹ޱ�
		Scanner sc = new Scanner(System.in);
		int underpassLength = sc.nextInt();
		int lightCnt = sc.nextInt();
		int[] lightLocation = new int[lightCnt];

		for (int i = 0; i < lightCnt; i++) {
			lightLocation[i] = sc.nextInt();
		}

		// 2. ���ε� ������ ���� ��� �� ����
		lightDistance = new ArrayList<>();
		calculateLightDistance(lightLocation);

		// 3. ��ü ���ε� �� �� ���� ���
		lightDistance.add(lightLocation[0]);
		lightDistance.add(underpassLength - lightLocation[lightCnt - 1]);

		// 4. ���ݵ� �� ���� ū ���� �ּ� ����
		int result = Collections.max(lightDistance);

		System.out.println(result);

	}

	private static void calculateLightDistance(int[] lightLocation) {
		for (int i = 1; i < lightLocation.length; i++) {
			int d = (lightLocation[i] - lightLocation[i - 1]) / 2;
			if ((lightLocation[i] - lightLocation[i - 1]) % 2 == 0) {
				lightDistance.add(d);
			} else {
				lightDistance.add(d + 1);
			}
		}
	}

}
