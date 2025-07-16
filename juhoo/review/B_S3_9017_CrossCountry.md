# 백준 9017 크로스 컨트리 | 실버 3
[👾 문제 바로가기](https://www.acmicpc.net/problem/9017)

정말 구현 문제는 쉽지 않다 ..
반례가 너무 많고,, 신경 쓸 것이 너무 많다..

### 나의 코드
```java
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

```

우선 여러 번 틀려서, 반례를 엄청 찾았는데 수정된 부분은 정말 별거 아니다.

//** 표시되 부분 2군데인데,
우선 list로 값을 받아놓고 앞의 value를 삭제하고 다음 인덱스로 넘어가도록 초반에 for문을 만들었다. 
어떻게 이런 실수를.. 
list는 배열과 달리 앞의 value가 없어지면 인덱스가 하나씩 당겨진다는걸 생각을 안했다.

그리고 같은 결과인 팀이 여러 개일 경우를 판별할 때 처음 min값이 나온 팀을 포함시키기 않는 대참사도 발생했다.

=> 이런 것들이 합쳐져서 반례를 찾아해매게 되었다.

#### 코드 리뷰
1. **scores.remove() 중복 삭제**
	- 시간복잡도가 O(N)이라 전체 성능 저하 우려
    - 새 리스트를 만들어서 유효한 팀만 필터링하는 방식이 더 효율적!
    ```java
      List<Integer> filtered = new ArrayList<>();
  for (int team : scores) {
      if (teamCnt.get(team) >= 6) {
          filtered.add(team);
      }
  }
  scores = filtered;

    ```
    
2. **int[] 대신 List<Integer> 추천**
	-  Map의 value로 int[]를 넣었는데, 배열을 매번 copy 하면서 append하는 방식은 비효율적이고 지저분.
	- List<Integer>로 바꾸면 간단하고 가독성도 좋음. 굳이 배열을 고집하지 말자.

3. **불필요한 반복 제거**
	```java
      int cnt = 0;
    for (int n : score) {
        if(cnt == 4) break;
        addResult += n;
        cnt++;
    }

    ```
  
	-> 여기서 그냥 for문으로 4번 인덱스까지만 탐색하면 되는 것...
  
4. **minScore 재사용보다는 별도의 변수 사용 추천**
  -> 가독성을 위해

5. **Map.containsKey() + get() -> getOrDefault()로 축약 가능!**
  

 </br>

  
### 개선 코드
```java
package source_code;

import java.util.*;

public class B_S3_9017_CrossCountry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int tc = 0; tc < testCase; tc++) {
            int personCnt = sc.nextInt();
            List<Integer> scores = new ArrayList<>();
            for (int i = 0; i < personCnt; i++) {
                scores.add(sc.nextInt());
            }

            // 1. 팀별 인원 수 카운트
            Map<Integer, Integer> teamCount = new HashMap<>();
            for (int team : scores) {
                teamCount.put(team, teamCount.getOrDefault(team, 0) + 1);
            }

            // 2. 6명 이상인 팀만 필터링
            List<Integer> validScores = new ArrayList<>();
            for (int team : scores) {
                if (teamCount.get(team) >= 6) {
                    validScores.add(team);
                }
            }

            // 3. 팀별 인덱스 기록 (최대 5명까지만)
            Map<Integer, List<Integer>> teamIndexMap = new HashMap<>();
            for (int i = 0; i < validScores.size(); i++) {
                int team = validScores.get(i);
                teamIndexMap.putIfAbsent(team, new ArrayList<>());
                if (teamIndexMap.get(team).size() < 5) {
                    teamIndexMap.get(team).add(i);
                }
            }

            // 4. 점수 합산 (상위 4명)
            Map<Integer, Integer> teamScoreMap = new HashMap<>();
            for (Map.Entry<Integer, List<Integer>> entry : teamIndexMap.entrySet()) {
                List<Integer> indices = entry.getValue();
                int sum = 0;
                for (int i = 0; i < 4; i++) {
                    sum += indices.get(i);
                }
                teamScoreMap.put(entry.getKey(), sum);
            }

            // 5. 최소 점수 팀 탐색 (동점 시 5번째 주자 비교)
            int winner = -1;
            int minScore = Integer.MAX_VALUE;
            List<Integer> candidates = new ArrayList<>();

            for (Map.Entry<Integer, Integer> entry : teamScoreMap.entrySet()) {
                int team = entry.getKey();
                int score = entry.getValue();

                if (score < minScore) {
                    minScore = score;
                    winner = team;
                    candidates.clear();
                    candidates.add(team);
                } else if (score == minScore) {
                    candidates.add(team);
                }
            }

            if (candidates.size() > 1) {
                int minFifth = Integer.MAX_VALUE;
                for (int team : candidates) {
                    int fifth = teamIndexMap.get(team).get(4);
                    if (fifth < minFifth) {
                        minFifth = fifth;
                        winner = team;
                    }
                }
            }

            System.out.println(winner);
        }
    }
}

```