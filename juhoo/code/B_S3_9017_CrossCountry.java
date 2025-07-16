package source_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 6���� ���� - ���� �� �� ���� ���ؼ� �� ���� ���
// ���� ���� ���� �� ���
// ���� �� �Ʒ��� �׳� Ż��
// ���� -> �ټ� ��° ���ڰ� ���� ���� ���� ���

// �Է�: �׽�Ʈ ���̽� �� // �ϳ��� ���� // �� ��ȣ(N��)
// ���: ����� ��ȣ

// 1. �Է�
// 1-1. ����Ʈ�� �� ��ȣ ����

// 2. 6���� �ƴ� �� ����
// 2-1. list ũ�⸸ŭ ���鼭 ��ü �� ��� count (map�� ����)
// 2-2. map���� value�� 6���� ���� key ã��
// 2-3. �ش� Ű�� ���� ���� ���� list�� ���� ����

// 3. ���� ���� ���
// 3-1. map[int][int[4]] �� ������ 5��°���� �迭�� �ε��� ����
// 3-2. map�� ��� ���� ũ��(�迭�� ũ��)�� 5�� �Ǹ� stop
// 3-3. �ε��� 4���� ���� ������ �ջ��ؼ� �ٽ� map�� ����

// 4. ��� �� ����
// 4-1. ���� ������ ���� key ã�� 
// 4-2. ���� ���� �����, �� ���� 5��° �ε��� ���ؼ� ���� �� ���

// 5. ���

public class B_S3_9017_CrossCountry {
	public static void main(String[] args) {
		// 1. �Է�
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			int personCnt = sc.nextInt();

			// 1-1. ����Ʈ�� �� ��ȣ ����
			List<Integer> scores = new ArrayList<>();
			for (int i = 0; i < personCnt; i++) {
				scores.add(sc.nextInt());
			}
			
			// 2. 6���� �ƴ� �� ����
			// 2-1. list ũ�⸸ŭ ���鼭 ��ü �� ��� count (map�� ����)
			Map<Integer, Integer> teamCnt = new HashMap<>();
			for (int i = 0; i < scores.size(); i++) {
				int teamNum = scores.get(i);

				if (teamCnt.containsKey(teamNum)) {
					teamCnt.put(teamNum, teamCnt.get(teamNum) + 1);
				} else {
					teamCnt.put(teamNum, 1);
				}
			}
			
			

			// 2-2. map���� value�� 6���� ���� key ã��
			for (int i : teamCnt.keySet()) {
				if (teamCnt.get(i) < 6) {
					// 2-3. �ش� Ű�� ���� ���� ���� list�� ���� ����
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
						

			// 3. ���� ���� ���
			// 3-1. map[int][int[]] �� ������ 5��°���� �迭�� �ε��� ����
			Map<Integer, int[]> calculate = new HashMap<>();

			for (int i = 0; i < scores.size(); i++) {
				int[] existing = calculate.get(scores.get(i));

				if (existing == null) {
					calculate.put(scores.get(i), new int[] { i });
				} else if (existing.length < 5) { // 3-2. map�� ��� ���� ũ��(�迭�� ũ��)�� 5�� �Ǹ� stop
					int[] expanded = Arrays.copyOf(existing, existing.length + 1);
					expanded[expanded.length - 1] = i;
					calculate.put(scores.get(i), expanded);
				} 
			}
			
			// 3-3. �ε��� 4���� ���� ������ �ջ��ؼ� �ٽ� map�� ����
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

			// 4. ��� �� ����
			// 4-1. ���� ������ ���� key ã��
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

			// 4-2. ���� ���� �����, �� ���� 5��° �ε��� ���ؼ� ���� �� ���
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

			// 5. ���
			System.out.println(minTeam);
		}

	}

}
