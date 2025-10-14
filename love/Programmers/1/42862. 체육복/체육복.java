import java.io.*;
import java.util.*;

/**
[문제 읽기]
- 학생 체육복 도난 사건. 여벌 체육복이 있는 학생이 빌려주기로 함
- 학생들 번호는 체격순서로 되어있어서 바로 앞번호 or 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있다.
  ex) 4번 학생은 3,5번 학생에게만 빌려줄 수 있음
- 체육복을 적절히 빌려 최대한 많은 학생이 체육 수업을 들어야 한다.
  체육 수업을 들을 수 있는 학생의 최댓값을 return3

- 단, 여별 체육복을 가져온 학생이 체육복을 도난당했을 수 도 있다. 이런 경우 다른 사람에게 체육복을 빌려줄 수 없다. ?
*/
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        boolean[] isLost = new boolean[n + 1];
        for (int num : lost) isLost[num] = true;

        // 오름차순으로 주어진다는 보장이 없어서 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 자가복구 하거나, 빌려줄 수 있는 학생임을  표시하기
        boolean[] isReserve = new boolean[n + 1];
        for (int num : reserve) {
            if (isLost[num]) {
                isLost[num] = false; // 자기 복구만
            } else {
                isReserve[num] = true; // 빌려줄 수 있는 학생만 따로 표시
            }
        }

        // 빌려주기 로직 (앞 → 뒤)
        for (int i = 1; i <= n; i++) {
            if (isLost[i]) {
                if (i - 1 >= 1 && isReserve[i - 1]) {
                    isReserve[i - 1] = false;
                    isLost[i] = false;
                } else if (i + 1 <= n && isReserve[i + 1]) {
                    isReserve[i + 1] = false;
                    isLost[i] = false;
                }
            }
        }

        // 계산
        for (int i = 1; i <= n; i++) if (!isLost[i]) answer++;

        return answer;
    }
}
