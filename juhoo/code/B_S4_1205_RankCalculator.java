package source_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 입력: N(리스트의 점수 개수), 새로운 점수, P(랭킹 리스트에 올라 갈 수 있는 점수 개수)
// 입력: N개의 점수 비오름차순으로 제공
// 출력: 태수의 new 점수의 등수

// 1. 입력받기
// 1-1. 점수 개수, 태수 점수, 리스트 전체 크기 저장
// 1-2. 현재 리스트의 점수들을 리스트에 저장

// 2. 등수 구하기

// 3. 출력하기

public class B_S4_1205_RankCalculator {
	public static void main(String[] args) {
		// 1. 입력받기
		Scanner sc = new Scanner(System.in);

		// 1-1. 점수 개수, 태수 점수, 리스트 전체 크기 저장
		int currentRankNum = sc.nextInt();
		int newScore = sc.nextInt();
		int fullNum = sc.nextInt();

		// 1-2. 현재 리스트의 점수들을 리스트에 저장
		List<Integer> scores = new ArrayList<>();

		for (int i = 0; i < currentRankNum; i++) {
			scores.add(sc.nextInt());
		}

		// 2. 등수 구하기
		// 2-1. 앞에서부터 태수 점수와 비교
		int result = 0;
		int i = scores.size() - 1;
		int lastNum = (currentRankNum != 0) ? scores.get(scores.size() - 1) : 0;

		while (true) {
			// 2-5. 기존 배열에 있는 점수 개수가 0이면 result에 1 저장
			if (currentRankNum == 0 && fullNum > 0) {
				result = 1;
				break;
			}

			// 마지막 숫자와 비교해서 new number보다 크거나 같으면 -1 return (다 찼으면)
			if (lastNum >= newScore && scores.size() >= fullNum) {
				result = -1;
				break;
			}

			// 마지막 숫자와 비교해서 new number보다 작으면 왼쪽으로 이동하면서 count
			if ((scores.size() < fullNum) || (lastNum <= newScore)) {
				while (i >= 0 && scores.get(i) <= newScore) {
					i--;
				}

				if (i >= 0 && scores.get(i) == newScore) {
					result = i + 1;
				} else {
					result = i + 2;
				}

				break;
			}

		}

		// 3. 출력하기
		System.out.println(result);
	}

}
