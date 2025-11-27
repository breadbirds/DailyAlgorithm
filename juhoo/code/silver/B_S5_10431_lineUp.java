package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 키 순서대로 번호 부여 (작은 순서대로 1번부터)
// 학생 수 : 20명 (같은 키 x)

// 1. 아무나 한 명을 줄 맨 앞에 세움
// 2. 다음 학생이 맨 뒤에 서면서 규칙 이행
// 2-1. 자기 앞에 더 큰 애가 없으면 멈춤
// 2-2. 자기 앞에 더 큰 애가 한 명이라도 있으면 그 중에 가장 앞에 있는 애의 바로 앞에 섬
// (반복)

// 입력: 케이스 수 P, 케이스 별 순서
// 출력: 케이스 번호, 학생들이 물러난 걸음 수 총합

public class B_S5_10431_lineUp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseNum = sc.nextInt();

		for (int i = 0; i < caseNum; i++) {
			int statusCase = sc.nextInt();

			List<Integer> newStanding = new ArrayList<>();
			int backMove = 0;

			// 1. 한 명을 줄 맨 앞에 세움
			newStanding.add(sc.nextInt());

			for (int j = 0; j < 19; j++) {

				int currentStudent = sc.nextInt();

				// 2. 다음 학생이 맨 뒤에 서면서 규칙 이행
				boolean hasBigger = false;
				int tallerIdx = -1;

				for (int s : newStanding) {
					if (s > currentStudent) {
						hasBigger = true;
						tallerIdx = newStanding.indexOf(s);
						break;
					}
				}

				if (hasBigger) {
					// 2-2. 자기 앞에 더 큰 애가 한 명이라도 있으면 그 중에 가장 앞에 있는 애의 바로 앞에 섬
					newStanding.add(tallerIdx, currentStudent);

					// 새로 들어온 애 뒤의 사람 수만큼 물러나야 함
					backMove += newStanding.size() - (tallerIdx + 1);
				} else {
					// 2-1. 자기 앞에 더 큰 애가 없으면 stop
					newStanding.add(currentStudent);
				}
			}

			System.out.println(statusCase + " " + backMove);

		}
	}

}
