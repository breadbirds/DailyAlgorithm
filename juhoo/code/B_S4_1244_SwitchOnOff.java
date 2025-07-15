package source_code;

import java.util.Scanner;

// 남: 받은 수의 배수인 스위치 상태 바꿈 (1)
// 여: 받은 수를 기준으로 그 수 포함, 양쪽으로 뻗어나가면서 같은 수면 다 바꿈 (2)

// 입력: 스위치 개수 // 스위치 각 상태들 // 학생 수 // 한 학생의 성별, 학생이 받은 수
// 출력: 스위치의 마지막 상태 (한 줄에 20개씩)

// 1. 입력받기
// 1-1. 배열에 스위치 상태 저장
// 1-2. 배열에 학생 정보 저장

// 2. 스위치 변경하기
// 2-1. 여자인지 남자인지 판별
// 2-2. 남자라면, 받은 수의 배수인 스위치 상태 변경
// 2-3. 만약 받은 수의 배수가 스위치 배열 크기보다 크다면 넘어감
// 2-4. 여자라면, 같은 수의 스위치 인덱스를 찾아 스위치 변경
// 2-5. 그 인덱스를 기준으로, 좌우로 동시 이동하면서 값이 같으면 스위치 변경
// 2-6. 값이 다르거나, 배열 인덱스를 벗어나면 멈춤

// 3. 최종 상태 출력하기

public class B_S4_1244_SwitchOnOff {
	static int[] switchStatus;

	public static void main(String[] args) {
		// 1. 입력받기
		Scanner sc = new Scanner(System.in);

		int switchCnt = sc.nextInt();
		switchStatus = new int[switchCnt];

		// 1-1. 배열에 스위치 상태 저장
		for (int i = 0; i < switchCnt; i++) {
			switchStatus[i] = sc.nextInt();
		}

		int studentCnt = sc.nextInt();
		int[][] student = new int[studentCnt][2];

		// 1-2. 배열에 학생 정보 저장
		for (int i = 0; i < studentCnt; i++) {
			for (int j = 0; j < 2; j++) {
				student[i][j] = sc.nextInt();
			}
		}

		// 2. 스위치 변경하기
		for (int i = 0; i < studentCnt; i++) {
			// 2-1. 여자인지 남자인지 판별
			int gender = student[i][0];
			int num = student[i][1];

			// 2-2. 남자라면, 받은 수의 배수인 스위치 상태 변경
			if (gender == 1) {
				int multiple = num;
				int n = 2;

				// 2-3. 만약 받은 수의 배수가 스위치 배열 크기보다 크다면 넘어감
				while (multiple < switchCnt) {
					convertValue(multiple);
					multiple = num * n;
					n++;
				}
			} else if (gender == 2 && num < switchCnt) { // 2-4. 여자라면, 같은 수의 스위치 인덱스를 찾아 스위치 변경
				convertValue(num);

				// 2-5. 그 인덱스를 기준으로, 좌우로 동시 이동하면서 값이 같으면 스위치 변경
				// 2-6. 값이 다르거나, 배열 인덱스를 벗어나면 멈춤
				int left = num - 1;
				int right = num + 1;

				while (left > 0 && right <= switchCnt && (switchStatus[left - 1] == switchStatus[right - 1])) {
					convertValue(left);
					convertValue(right);

					left--;
					right++;
				}
			}
		}

		// 3. 최종 상태 출력하기
		int i = 1;

		while (i <= switchCnt) {
			System.out.print(switchStatus[i-1] + " ");
			
			if(i % 20 == 0) {
				System.out.println();
			}

			i++;
		}
	}

	// 값을 반전시키는 함수
	private static void convertValue(int num) {
		switchStatus[num - 1] = (switchStatus[num - 1] == 1) ? 0 : 1;
	}

}
