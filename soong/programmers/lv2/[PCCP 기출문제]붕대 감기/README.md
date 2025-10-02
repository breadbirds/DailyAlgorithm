
# [프로그래머스 - PCCP 기출] 붕대 감기

## ⏰  **time**
30분


## ⏲️**Time Complexity**
$O(N)$

## 풀이 

시뮬레이션 문제. 문제 조건 그대로 이행

1. `health`가 초기값보다 클 수 없음
2. 공격이 아닐 때
   1. 체력 `bandage[1]` 만큼 회복
   2. 연속 성공 시간 `heal + 1`
   3. 만약 연속 성공 시간이 `bandage[0]`과 같다면, `health`에 추가 회복량 `bandage[2]`를 더하고 성공 시간을 0으로 초기화
3. 공격일 때
   1. 성공 시간을 0으로 초기화
   2. `health`를 공격인 `attacks[idx][1]` 만큼 감소
   3. 만약 `health`가 0이하면 `-1`를 리턴한다.
4. 이 과정을 공격이 끝날때까지 반복

```java
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
       int answer = health;

		int idx = 0;
		int cnt = 1, heal = 0;
		while (idx < attacks.length) {
			if (health > answer)
				health = answer;
			if (attacks[idx][0] != cnt) { // 공격이 아닐때

				health += bandage[1];
				heal++;
				if (heal == bandage[0]) {
					health += bandage[2];
					heal = 0;
				}
			} else { // 공격일 경우
				heal = 0;
				health -= attacks[idx++][1];
				if (health <= 0)
					return -1;
			}
			cnt++;

		}

		return health;
    }
}
```



## :black_nib: **Review**




## 📡**Link**
- https://school.programmers.co.kr/learn/courses/19344/lessons/242258

