package source_code;

import java.util.Scanner;

// 입력: 판의 가로 세로 길이 /// 각 칸의 값 (_ or *)
// 출력: 심장이 위치한 x, y /// 왼쪽 팔, 오른쪽 팔, 왼쪽 다리, 오른쪽 다리 길이

// 1. 입력받기
// 1-1. 배열에 판 저장 - _이면 0, *이면 1로 변환하여 저장하기

// 2. 머리 찾기
// 2-1. 판에서 위에서부터 1이 포함된 첫 열 찾기

// 3. 심장 위치 찾기 - (머리 x값 -1) (머리 y값)

// 4. 팔 길이 계산
// 4-1. 심장 위치를 기준으로 값이 0이 될때까지 왼쪽으로 가면서 count
// 4-2. 심장 위치를 기준으로 값이 0이 될때까지 오른쪽으로 가면서 count

// 5. 다리 길이 계산
// 5-1. 허리 길이 끝 찾기 - 심장 위치를 기준으로 값이 0이 될 때까지 아래로 이동
// 5-2. 왼쪽 다리 길이 count
// 5-3. 오른쪽 다리 길이 count

// 6. 출력하기

public class B_B4_20125_cookie {
	public static void main(String[] args) {
		// 1. 입력받기
		Scanner sc = new Scanner(System.in);

		int boardWidth = sc.nextInt();
		sc.nextLine();

		int[][] board = new int[boardWidth][boardWidth];

		// 1-1. 배열에 판 저장 - _이면 0, *이면 1로 변환하여 저장하기
		for (int i = 0; i < boardWidth; i++) {
			String line = sc.nextLine();

			for (int j = 0; j < boardWidth; j++) {
				char c = line.charAt(j);

				if (c == '_') {
					board[i][j] = 0;
				} else {
					board[i][j] = 1;
				}
			}
		}

		int[] head = new int[2];
		int[] heart = new int[2];
		int leftArm = 0;
		int rightArm = 0;
		int leftLeg = 0;
		int rightLeg = 0;
		int waistLength = 0;

		// 2. 머리 좌표 찾기
		// 2-1. 판에서 위에서부터 1이 포함된 첫 열 찾기

		loop1: for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardWidth; j++) {
				if (board[i][j] == 1) {
					head[0] = i + 1;
					head[1] = j + 1;
					break loop1;
				}
			}
		}

		// 3. 심장 위치 찾기 - (머리 x값 -1) (머리 y값)
		heart[0] = head[0] + 1;
		heart[1] = head[1];

		// 4. 팔 길이 계산
		// 4-1. 심장 위치를 기준으로 값이 0이 될때까지 왼쪽으로 가면서 count
		for (int j = heart[1] - 2; j >= 0; j--) {
			if (board[heart[0] - 1][j] == 1) {
				leftArm++;
			} else {
				break;
			}
		}

		// 4-2. 심장 위치를 기준으로 값이 0이 될때까지 오른쪽으로 가면서 count
		for (int j = heart[1]; j < boardWidth; j++) {
			if (board[heart[0] - 1][j] == 1) {
				rightArm++;
			} else {
				break;
			}
		}

		// 5. 다리 길이 계산
		// 5-1. 허리 길이 끝 찾기 - 심장 위치를 기준으로 값이 0이 될 때까지 아래로 이동
		for (int i = heart[0] + 1; i < boardWidth; i++) {
			if (board[i - 1][heart[1] - 1] == 1) {
				waistLength++;
			} else {
				break;
			}
		}

		// 5-2. 왼쪽 다리 길이 count
		for (int i = heart[0] + waistLength; i < boardWidth; i++) {
			if (board[i][heart[1] - 2] == 1) {
				leftLeg++;
			} else {
				break;
			}
		}

		// 5-3. 오른쪽 다리 길이 count
		for (int i = heart[0] + waistLength; i < boardWidth; i++) {
			if (board[i][heart[1]] == 1) {
				rightLeg++;
			} else {
				break;
			}
		}

		// 6. 출력하기
		// 출력: 심장이 위치한 x, y /// 왼쪽 팔, 오른쪽 팔, 허리, 왼쪽 다리, 오른쪽 다리 길이
		System.out.printf("%d %d\n", heart[0], heart[1]);
		System.out.printf("%d %d %d %d %d\n", leftArm, rightArm, waistLength, leftLeg, rightLeg);
	}

}
