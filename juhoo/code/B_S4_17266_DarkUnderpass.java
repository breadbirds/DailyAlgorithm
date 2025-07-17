package source_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 최소한의 높이로 굴다리를 밝히자
// 최소한의 예산이 들 높이 구하기 (but 가로등은 높이 모두 동일)
// 높이가 H : 왼쪽 H, 오른쪽 H만큼 밝혀짐

// 입력: 굴다리 길이 // 가로등 개수 // 설치할 수 있는 가로등 위치
// 출력: 굴다리 길이를 모두 비출 수 있는 가로등 최소 높이

public class B_S4_17266_DarkUnderpass {
	static List<Integer> lightDistance;

	public static void main(String[] args) {
		// 1. 입력받기
		Scanner sc = new Scanner(System.in);
		int underpassLength = sc.nextInt();
		int lightCnt = sc.nextInt();
		int[] lightLocation = new int[lightCnt];

		for (int i = 0; i < lightCnt; i++) {
			lightLocation[i] = sc.nextInt();
		}

		// 2. 가로등 사이의 간격 계산 후 저장
		lightDistance = new ArrayList<>();
		calculateLightDistance(lightLocation);

		// 3. 전체 가로등 앞 뒤 간격 계산
		lightDistance.add(lightLocation[0]);
		lightDistance.add(underpassLength - lightLocation[lightCnt - 1]);

		// 4. 간격들 중 가장 큰 값이 최소 높이
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
