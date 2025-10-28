# [프로그래머스 - Lv2] 과제 진행하기

## ⏰ **time** 
60분 

## :pushpin: **Algorithm** 

구현, 스택


## ⏲️**Time Complexity** 
$O(N \log N)$

## :round_pushpin: **Logic** 

여러 과제가 시간 순서대로 주어질 때,
새로운 과제가 시작되면 현재 과제를 **중단하고 스택에 저장**했다가
나중에 남은 시간 동안 이어서 수행하는 문제.

1. `plans` 배열을 시작 시간 기준으로 오름차순 정렬한다.
2. 각 과목에 대해
- `종료 시간 = 시작 시간 + 소요 시간 계산`
- 다음 과목의 시작 시간과 비교
3. **현재 과목 종료 > 다음 과목 시작** → 덜 끝난 과목을 스택에 저장
- **현재 과목 종료 ≤ 다음 과목 시작** → 과목 완료 후 남은 시간 동안 스택의 과목을 이어서 수행
4. 모든 과목을 처리한 뒤,
스택에 남아 있는 과목들을 **나중에 멈춘 순서대로(pop)** 완료한다.

```java
  for (int i = 0; i < plans.length - 1; i++) {
        int startTime = toMinutes(plans[i][1]);
        int duration = Integer.parseInt(plans[i][2]);
        int endTime = startTime + duration;

        int nextStart = toMinutes(plans[i + 1][1]);
        if (endTime > nextStart) { // 덜 끝났을 경우
            st.push(new Sub(plans[i][0], endTime - nextStart));
        } else { // 과제 완료
            result.add(plans[i][0]);

            int remainTime = nextStart - endTime;
            // 3️⃣ 남은 시간 동안 이전 과제 이어서 수행
            while (!st.isEmpty() && remainTime > 0) {
                Sub paused = st.pop();
                if (paused.time <= remainTime) {
                    result.add(paused.name);
                    remainTime -= paused.time;
                } else { // 여전히 덜 끝났을 경우
                    st.push(new Sub(paused.name, paused.time - remainTime));
                    break;
                }
            }
        }
    }

    // 4️⃣ 마지막 과제는 무조건 완료
    result.add(plans[plans.length - 1][0]);

    // 5️⃣ 스택에 남은 과제 순서대로 완료
    while (!st.isEmpty()) {
        result.add(st.pop().name);
    }
```

## :black_nib: **Review** 


## 📡**Link** 
- https://school.programmers.co.kr/learn/courses/30/lessons/176962
