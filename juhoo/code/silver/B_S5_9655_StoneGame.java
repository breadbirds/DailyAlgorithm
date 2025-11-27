package baekjoon;

import java.util.Scanner;

// 탁자 위에 돌 N개
// 턴 번갈아가면서, 돌은 1개 or 3개 가져감
// 마지막 돌을 가져가는 사람이 WIN!
// start는 상근

// 입력: N
// 출력: 상근 win -> SK, 창영 win -> CY

// 홀수: 상근 / 짝수: 창영

public class B_S5_9655_StoneGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int gameNum = sc.nextInt();
		if (gameNum % 2 == 1) {
			System.out.println("SK");
		} else {
			System.out.println("CY");
		}
	}

}
