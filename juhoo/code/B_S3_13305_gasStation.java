package source_code;

import java.util.Scanner;

// 1km = 1����
// 1 ���� = 1 ������

// �Է�: ���� ���� // ������ ���� // �������� ���ʹ� ����
// ���: �ּ� ���

public class B_S3_13305_gasStation {
	public static void main(String[] args) {
		// 1. �Է¹ޱ� - ���� �迭
		Scanner sc = new Scanner(System.in);

		int cityCnt = sc.nextInt();
		long[] cityCost = new long[cityCnt];
		int[] loadLength = new int[cityCnt - 1];
		
		for (int i = 0; i < cityCnt - 1; i++) {
			loadLength[i] = sc.nextInt();
		}

		for (int i = 0; i < cityCnt; i++) {
			cityCost[i] = sc.nextInt();
		}

		// 2. ���� �迭�� ���鼭 ����ϱ�
		int currentIndex = 0;
		int nextIndex = 1;
		int loadIndex = 1;
		long resultCost = cityCost[0] * loadLength[0];

		while (loadIndex < cityCnt - 1 && nextIndex < cityCnt && currentIndex < cityCnt) {
//			System.out.println("=================================");
//			System.out.println("current: " +cityCost[currentIndex]);
//			System.out.println("next: " +cityCost[nextIndex]);
//			System.out.println("load: " +loadLength[loadIndex]);
//			System.out.println("resultCost: " +resultCost);

			if (cityCost[currentIndex] <= cityCost[nextIndex]) {
				resultCost += cityCost[currentIndex] * loadLength[loadIndex];
				nextIndex++;
				loadIndex++;
			} else {
				resultCost += cityCost[nextIndex] * loadLength[loadIndex];
				currentIndex = nextIndex;
				nextIndex++;
				loadIndex++;
			}

		}

		System.out.println(resultCost);
	}

}
