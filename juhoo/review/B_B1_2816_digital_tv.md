# 백준 2816 디지털 티비 | 브론즈 1

[🍋 문제 바로가기](https://www.acmicpc.net/problem/2816)

### 내 코드
```java
package source_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 여러 채널 중 KBS1, KBS2를 1,2번 채널로 만들려고 함
// 리모콘을 이용해서 리스트의 순서를 바꿈
// 왼쪽의 작은 화살표는 현재 선택 채널
// 가장 처음에 화살표는 첫 채널을 가리킴

// 버튼
// 1. 화살표를 한 칸 아래로 내림(i -> i+1)
// 2. 화살표를 위로 한 칸 올림 (i -> i-1)
// 3. 현재 선택 채널을 한 칸 아래로 내림(i switch i+1 / 화살표는 i+1)
// 4. 현재 선택 채널을 위로 한 칸 올림(i switch i-1 / 화살표는 i-1)

// 입력: 채널 수 N / 채널 이름들
// 출력: 눌러야 하는 버튼들(공백X)


public class B_B1_2816_digital_tv {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 1. 입력 받아서 저장 & kbs1, kbs2 위치 찾기
		int channelNum = sc.nextInt();
		sc.nextLine();
		List<String> channels = new ArrayList<>();
		
		int kbs1Location = -1;
		int kbs2Location = -1;
		
		int arrowNum = 0;
		String result = "";
		
		for(int i = 0; i<channelNum; i++) {
			String channelText = sc.nextLine();
			channels.add(channelText);
			
			if(channelText.equals("KBS1")) {
				kbs1Location = channels.size() - 1;
			} else if(channelText.equals("KBS2")) {
				kbs2Location = channels.size() - 1;
			}
		}
		
		// 2. KBS1 옮기기
		// 2-1. KBS1의 위치만큼 화살표 옮기기
		int idx = channels.indexOf("KBS1");

		for(int i = 0; i<idx; i++) {
			result += "1";
		}
		
		// 2-2. KBS1을 0번째로 옮기기
		while(!channels.get(0).equals("KBS1")) {
			result += "4";
			
			idx = channels.indexOf("KBS1");
			if(idx > 0) {
				Collections.swap(channels, idx, idx - 1);
			}
		}
		
			
		// 3. KBS2 옮기기
		// 2-1. KBS2의 위치만큼 화살표 옮기기
		idx = channels.indexOf("KBS2");

		for(int i = 0; i<idx; i++) {
			result += "1";
		}
		
		// 2-2. KBS2을 1번째로 옮기기
				while(!channels.get(1).equals("KBS2")) {
					result += "4";
					
					idx = channels.indexOf("KBS2");
					if(idx > 0) {
						Collections.swap(channels, idx, idx - 1);
					}
				}
				
				System.out.println(result);

		
	}

}

```

#### 코드 피드백
`개선 포인트`

1. **불필요한 화살표 이동 제거 가능**
	- 현재 코드는 1번 버튼으로 화살표를 이동시킨 후, 다시 4번 버튼으로 교체함
    - 하지만 실제로는 4 버튼만 눌러도 화살표가 자동으로 따라감!
    => 1번 버튼 따로 처리할 필요 없음

2. 중복 로직 함수화 가능
	- KBS1, KBS2를 0번째, 1번째로 만드는 코드가 거의 동일함 => 함수로 빼기

3. String result -> StringBuilder로 변경 권장
	- += 연산은 문자열이 새로 만들어져서 성능이 떨어짐
    - StringBuilder는 성능 좋고 append만 하면 돼서 효율적임

</br>

### 개선 코드
```java
import java.util.*;

public class B_B1_2816_digital_tv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int channelNum = sc.nextInt();
        sc.nextLine();
        List<String> channels = new ArrayList<>();

        for (int i = 0; i < channelNum; i++) {
            channels.add(sc.nextLine());
        }

        StringBuilder result = new StringBuilder();

        moveToIndex(channels, "KBS1", 0, result);  // KBS1을 0번으로
        moveToIndex(channels, "KBS2", 1, result);  // KBS2를 1번으로

        System.out.println(result);
    }

    private static void moveToIndex(List<String> list, String target, int finalIndex, StringBuilder result) {
        while (!list.get(finalIndex).equals(target)) {
            int idx = list.indexOf(target);
            Collections.swap(list, idx, idx - 1);
            result.append("4");
        }
    }
}
 
```

</br>

### Java List 종류 비교
이번 문제에서는 순서를 옮기기 수월하도록 arrayList를 사용하였는데, 그럼 김에 싹 정리 다시 한 번 해보았다.

좋아, 벨로그용으로 Java의 주요 `List` 종류를 **한눈에 비교 가능한 표 형식**으로 깔끔하게 정리해줄게.
사용 목적에 따라 선택하기 쉽게 **특징, 시간복잡도, 적합한 상황**까지 넣었어.

---

## 📝 Java List 종류 비교표

| 자료구조                   | 기본 구조       | 주요 특징                                                 | 접근 속도                    | 삽입/삭제 속도                  | 적합한 상황                             |
| ---------------------- | ----------- | ----------------------------------------------------- | ------------------------ | ------------------------- | ---------------------------------- |
| `ArrayList`            | 배열 기반       | - 연속된 메모리 공간 사용<br>- 인덱스 접근 빠름<br>- 중간 삽입/삭제 느림       | `O(1)`                   | `O(n)`                    | ✅ 읽기/검색 위주 작업<br>✅ 요소가 자주 바뀌지 않을 때 |
| `LinkedList`           | 이중 연결 리스트   | - 노드 연결 구조<br>- 삽입/삭제 빠름<br>- 인덱스 접근 느림               | `O(n)`                   | `O(1)` (양 끝), `O(n)` (중간) | ✅ 삽입/삭제 빈번<br>✅ 큐/덱처럼 양쪽 조작 필요할 때  |
| `Vector`               | 배열 기반 (동기화) | - `ArrayList`와 유사하나<br>**스레드 동기화** 지원<br>- 무겁고 거의 안 씀 | `O(1)`                   | `O(n)`                    | ✅ 과거 레거시 코드 호환<br>⚠️ 요즘은 잘 안 씀     |
| `Stack`                | 벡터 기반       | - LIFO 구조 (후입선출)<br>- 내부적으로 `Vector` 상속               | `O(1)`                   | `O(1)`                    | ✅ 되돌리기 기능<br>✅ 재귀적 구조 처리 등         |
| `CopyOnWriteArrayList` | 배열 기반       | - 쓰기 시 전체 복사<br>- 읽기 안전<br>- **멀티스레드 환경에 적합**         | 읽기: `O(1)`<br>쓰기: `O(n)` | `O(n)`                    | ✅ 읽기 많은 다중 스레드 환경 (ex. 캐시 리스트)     |



### 정리

* **속도 빠른 검색/읽기** → `ArrayList`
* **빈번한 삽입/삭제** → `LinkedList`
* **동기화 필요** → `CopyOnWriteArrayList` or `Collections.synchronizedList(...)`
* **스택 구조 필요** → `Stack`
* **거의 안 씀 (과거)** → `Vector`


