package source_code;

import java.util.Scanner;

// 1km = 1리터
// 1 도시 = 1 주유소

// 입력: 도시 개수 // 도로의 길이 // 주유소의 리터당 가격
// 출력: 최소 비용

public class B_S3_13305_gasStation {
	public static void main(String[] args) {
		// 1. 입력받기 - 각각 배열
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

		// 2. 도시 배열을 돌면서 계산하기
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
