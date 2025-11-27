package source_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 6명의 선수 - 상위 네 명 점수 합해서 팀 점수 계산
// 가장 낮은 점수 팀 우승
// 여섯 명 아래는 그냥 탈락
// 동점 -> 다섯 번째 주자가 빨리 들어온 팀이 우승

// 입력: 테스트 케이스 수 // 하나의 정수 // 팀 번호(N개)
// 출력: 우승팀 번호

// 1. 입력
// 1-1. 리스트에 팀 번호 저장

// 2. 6명이 아닌 팀 삭제
// 2-1. list 크기만큼 돌면서 전체 팀 명수 count (map에 저장)
// 2-2. map에서 value가 6보다 작은 key 찾기
// 2-3. 해당 키와 같은 값을 가진 list의 값들 삭제

// 3. 팀별 점수 계산
// 3-1. map[int][int[4]] 각 팀별로 5번째까지 배열에 인덱스 저장
// 3-2. map의 모든 값의 크기(배열의 크기)가 5가 되면 stop
// 3-3. 인덱스 4까지 팀별 점수를 합산해서 다시 map에 저장

// 4. 우승 팀 추출
// 4-1. 가장 점수가 낮은 key 찾기 
// 4-2. 만약 여러 개라면, 각 팀의 5번째 인덱스 비교해서 낮은 팀 우승

// 5. 출력

public class B_S3_9017_CrossCountry {
	public static void main(String[] args) {
		// 1. 입력
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			int personCnt = sc.nextInt();

			// 1-1. 리스트에 팀 번호 저장
			List<Integer> scores = new ArrayList<>();
			for (int i = 0; i < personCnt; i++) {
				scores.add(sc.nextInt());
			}
			
			// 2. 6명이 아닌 팀 삭제
			// 2-1. list 크기만큼 돌면서 전체 팀 명수 count (map에 저장)
			Map<Integer, Integer> teamCnt = new HashMap<>();
			for (int i = 0; i < scores.size(); i++) {
				int teamNum = scores.get(i);

				if (teamCnt.containsKey(teamNum)) {
					teamCnt.put(teamNum, teamCnt.get(teamNum) + 1);
				} else {
					teamCnt.put(teamNum, 1);
				}
			}
			
			

			// 2-2. map에서 value가 6보다 작은 key 찾기
			for (int i : teamCnt.keySet()) {
				if (teamCnt.get(i) < 6) {
					// 2-3. 해당 키와 같은 값을 가진 list의 값들 삭제
					int j = 0;
					
					while(j < scores.size()) { // *
						if (scores.get(j) == i) {
							scores.remove(j);
						} else {
							j++;
						}
					}
				}
			}
						

			// 3. 팀별 점수 계산
			// 3-1. map[int][int[]] 각 팀별로 5번째까지 배열에 인덱스 저장
			Map<Integer, int[]> calculate = new HashMap<>();

			for (int i = 0; i < scores.size(); i++) {
				int[] existing = calculate.get(scores.get(i));

				if (existing == null) {
					calculate.put(scores.get(i), new int[] { i });
				} else if (existing.length < 5) { // 3-2. map의 모든 값의 크기(배열의 크기)가 5가 되면 stop
					int[] expanded = Arrays.copyOf(existing, existing.length + 1);
					expanded[expanded.length - 1] = i;
					calculate.put(scores.get(i), expanded);
				} 
			}
			
			// 3-3. 인덱스 4까지 팀별 점수를 합산해서 다시 map에 저장
			Map<Integer, Integer> addScore = new HashMap<>();
			for (int i : calculate.keySet()) {
				int[] score = calculate.get(i);
				
								
				int addResult = 0;
				int cnt = 0;
				for (int n : score) {
					if(cnt == 4) {
						break;
					}
					addResult += n;
					cnt++;
				}
				
				addScore.put(i, addResult);
			}

			// 4. 우승 팀 추출
			// 4-1. 가장 점수가 낮은 key 찾기
			int minScore = Integer.MAX_VALUE;
			int minTeam = -1;
			List<Integer> sameScoreCnt = new ArrayList<>();

			for (int i : addScore.keySet()) {
				if (minScore > addScore.get(i)) {
					minScore = addScore.get(i);
					minTeam = i;
					sameScoreCnt.clear();
					sameScoreCnt.add(i); // **
				} else if (minScore == addScore.get(i)) {
					sameScoreCnt.add(i);
				}
			}

			// 4-2. 만약 여러 개라면, 각 팀의 5번째 인덱스 비교해서 낮은 팀 우승
			if (sameScoreCnt.size() > 1) {
				minScore = Integer.MAX_VALUE;
				minTeam = -1;

				for (int i : sameScoreCnt) {
					if (minScore > calculate.get(i)[4]) {
						minScore = calculate.get(i)[4];
						minTeam = i;
					}
				}
			}

			// 5. 출력
			System.out.println(minTeam);
		}

	}

}
