## 백준 2292 벌집 | 브론즈 2

### 내 코드
```java
package source_code;

import java.util.Scanner;

// 육각형
// 중앙 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호를 매김
// 중앙 1에서 N번 방까지 최소 개수 방을 지나서 갈 때 몇 개의 방을 지나가는가?

// 입력: N
// 출력: 최소 개수 방을 지나서 갈 때 몇 개의 방을 지나는지

// 규칙: depth 증가 (1 -> 2 -> 8 - > 201 -> 38) -> 6의 배수씩 커짐

public class B_B2_2292_Honeycomb {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int targetRoom = sc.nextInt();
		
		int cntNum = 0;
		int calculate = 1;
		

		while(true) {			
			if(calculate <= targetRoom) {
				if(calculate == 1) {
					calculate++;
					cntNum++;
				} else {
					calculate += 6*cntNum;
					cntNum++;
				}
			} else {
				break;
			}
		}
		
		System.out.println(cntNum);
	}

}
```

#### 코드 피드백
`좋은 점	`
- 문제의 규칙(6의 배수씩 증가)을 잘 이해하고 calculate += 6 * cntNum 로직으로 구현
- calculate로 현재 위치를 추적하고, cntNum을 레벨(depth)로 사용한 방식이 직관적

`개선 포인트`
- **불필요한 조건 제거**
	`if(calculate == 1) {
					calculate++;
					cntNum++;
				}` -> 이 부분은 필요 없음
                각각을 1로 초기화 하면 됨

- **불필요한 반복문 -> 수식 처리로 개선 **
	이 문제는 1 + 6 * (1 + 2 + ... + (n - 1)) 형태의 누적합이기 때문에, 실제로는 수학식으로 해결 가능
    while 반복문보단 while (calculate < N)만 남기면 더 자연스럽고 빠름
    
</br>

### 개선 코드
```java
import java.util.Scanner;

public class B_B2_2292_Honeycomb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int targetRoom = sc.nextInt();

        int cnt = 1;        // 최소 개수 (시작은 1번 방)
        int range = 1;      // 현재 범위의 최대 번호

        while (range < targetRoom) {
            range += 6 * cnt;
            cnt++;
        }

        System.out.println(cnt);
    }
}

```

처음에는 사실 calculate와 targetRoom가 같은 경우를 고려하지 않아서 오답처리 되었었다. 같은 경우도 고려를 해주어야 함!

이 문제는 숫자 사이의 수학적 규칙을 찾는 것이 핵심인 것 같다.