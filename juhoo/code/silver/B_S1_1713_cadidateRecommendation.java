package source_code;

import java.io.*;
import java.util.*;

public class B_S1_1713_cadidateRecommendation {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int seatNum = Integer.parseInt(br.readLine());
		int recommendationNum = Integer.parseInt(br.readLine());
		int[] recommendations = new int[recommendationNum];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < recommendationNum; i++) {
			recommendations[i] = Integer.parseInt(st.nextToken());
		}

		Map<Integer, Integer> voteCnt = new LinkedHashMap<>();

		for (int r : recommendations) {
			// 이미 틀에 있으면 투표 수만 증가
			if (voteCnt.containsKey(r)) {
				voteCnt.replace(r, voteCnt.get(r) + 1);
				continue;
			}

			// 틀이 아직 덜찼다면 후보 추가
			if (voteCnt.size() < seatNum) {
				voteCnt.put(r, 1);
			} else { // 틀이 다 찼다면
				// 추천 횟수 제일 작은 값 찾기
				int minCnt = Integer.MAX_VALUE;
				int oldStudentNum = 0;

				for (int v : voteCnt.keySet()) {
					if (minCnt > voteCnt.get(v)) {
						minCnt = voteCnt.get(v);
						oldStudentNum = v;
					}
				}

				voteCnt.remove(oldStudentNum);
				voteCnt.put(r, 1);
			}
		}

		// 결과 출력
		StringBuilder sb = new StringBuilder();
		Set<Integer> resultSet = voteCnt.keySet();
		List<Integer> resultList = new ArrayList<>(resultSet);
		Collections.sort(resultList);
		int j = 0;

		for (int i : resultList) {
			sb.append(i);
			j++;

			if (j != resultList.size()) {
				sb.append(" ");
			}
		}

		System.out.println(sb);
	}

}
