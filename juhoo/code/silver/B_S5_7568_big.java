package source_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 덩치: (x, y) = (몸무게, 키)
// (x,y), (p,q) => x > p and y > q => A 덩치가 B보다 크다!
// 키와 몸무게가 둘 다 크지 않다면 같은 등수가 됨

// 입력: 전체 사람 수 // 각 사람의 몸무게와 키
// 출력: 순서대로 덩치 등수 나열

public class B_S5_7568_big {
	static int higherWeight = 0;
	static int higherHeight = 0;
	static int jump = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int personNum = sc.nextInt();
		int[][] persons = new int[personNum][2];
		int[] result = new int[personNum];

		for (int i = 0; i < personNum; i++) {
			persons[i][0] = sc.nextInt();
			persons[i][1] = sc.nextInt();

			// result 0으로 초기화
			result[i] = 0;
		}

		higherWeight = 0;
		higherHeight = 0;

		for (int i = 0; i < personNum; i++) {
			int biggerNum = 0;

			if (result[i] == 0) {
				for (int j = 0; j < personNum; j++) {
					if (persons[j][0] > persons[i][0] && persons[j][1] > persons[i][1] && i != j) {
						biggerNum++;
					}
				}
			}

			// 등수 기록
			result[i] = biggerNum + 1;
		}

		for (int i = 0; i < personNum; i++) {
			System.out.print(result[i]);
			if (i != personNum - 1) {
				System.out.print(" ");
			}
		}

	}

}
