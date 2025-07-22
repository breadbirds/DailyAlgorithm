# 백준 20920 영단어 암기는 괴로워 | 실버 3
[👑 문제 바로가기](https://www.acmicpc.net/problem/20920)

쉽게 봤는데 어려웠던 문제..
우선 복합 정렬 조건을 설계하는걸 잘 몰라서 어려웠고, 시간 초과 문제로 Scanner가 아닌 BufferedReader를 써야해서 낯설었다.

### 나의 코드
```java
package source_code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 1. 자주 나오는 단어일수록 앞에 배치
// 2. 단어 길이가 길수록 앞에 배치
// 3. 알파벳 사전 순으로 앞에 배치
// M 이상인 단어만 외움

public class B_S3_20920_영단어암기는괴로워 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int wordCnt = Integer.parseInt(input[0]);
		int limitLength = Integer.parseInt(input[1]);
		
		List<String> words = new ArrayList<>();

		for (int i = 0; i < wordCnt; i++) {
			String word = br.readLine();

			if (word.length() >= limitLength) {
				words.add(word);
			}
		}

		// 1. 단어의 빈도수 세서 Map에 저장
		Map<String, Integer> sameWordCnt = new HashMap<>();
		for (String s : words) {
			if (sameWordCnt.containsKey(s))
				sameWordCnt.put(s, sameWordCnt.get(s) + 1);
			else
				sameWordCnt.put(s, 1);
		}

		List<Map.Entry<String, Integer>> entryList = new ArrayList<>(sameWordCnt.entrySet());

		// 2. 정렬
		entryList.sort((e1, e2) -> {
			if (!e1.getValue().equals(e2.getValue())) {
				return e2.getValue() - e1.getValue(); // 빈도수 내림차순
			}
			if (e1.getKey().length() != e2.getKey().length()) {
				return e2.getKey().length() - e1.getKey().length(); // 길이 내림차순
			}
			return e1.getKey().compareTo(e2.getKey()); // 사전 순 오름차순
		});

		// 3. 출력
		StringBuilder sb = new StringBuilder();
	    for (Map.Entry<String, Integer> entry : entryList) {
	        sb.append(entry.getKey()).append('\n');
	    }

	    System.out.print(sb);
	}

}

```

빈도수를 Map에 저장하는 것까지는 초반 나의 생각과 동일했다. 그런데 빈도수 기준 정렬까지 하고 나니 남은 두 정렬을 어떻게 처리해야할지 감이 잘 오지 않았고, 복잡한 방법 말고 생각이 안났다.
사실 이 부분은 전에도 정리한 적이 있는 정렬 관련 문제이다. 그래서 다시 한 번 정리!


### ✍🏻 Map.Entry
Map에 저장된 "key : value" 한 쌍을 하나의 덩어리로 보는 것.
```java
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " -> " + entry.getValue());
}

```
-> 그래서 getKey(), getValue()가 가능하다.

#### entrySet()
Map 안에 있는 모든 key-value 쌍을 리스트처럼 꺼낼 수 있게 해주는 함수.
그래서 `for (Map.Entry<...> : map.entrySet())`처럼 쓸 수 있음.

</br>

### ✍🏻 리스트 정렬 기준 직접 정하기 (Comparator)

Java에서는 리스트를 정렬할 때 sort()를 쓰는데, 정렬 기준을 직접 정하고 싶으면 Comparator를 넣어서 커스텀 함.

```
list.sort((a, b) -> a - b);  // 숫자 오름차순
list.sort((a, b) -> b - a);  // 숫자 내림차순
```

이렇게 정렬 기준을 람다식으로 직접 넣는게 커스텀 sort!

#### entryList.sort()
문제에서 세 가지(빈도수, 길이, 알파벳 순) 기준에 따라서 정렬을 하라고 한 상황
```java
entryList.sort((e1, e2) -> {
    if (!e1.getValue().equals(e2.getValue())) {
        return e2.getValue() - e1.getValue(); // 1. 빈도수 내림차순
    }
    if (e1.getKey().length() != e2.getKey().length()) {
        return e2.getKey().length() - e1.getKey().length(); // 2. 길이 내림차순
    }
    return e1.getKey().compareTo(e2.getKey()); // 3. 알파벳 순 오름차순
});
```

1. `if (!e1.getValue().equals(e2.getValue()))`
  빈도수가 다르다면 내림차순 정렬

2. `if (e1.getKey().length() != e2.getKey().length())`
  단어 길이가 다르다면 내림차순 정렬

3. `return e1.getKey().compareTo(e2.getKey())`
  위 두 조건이 같으면 알파벳 순서로 오름차순 정렬
  -> String 클래스는 Comparable을 구현하고 있고, 그 안에 있는 compareTo()는 알파벳 순서로 비교를 해줌!
  
</br>

### ✍🏻 BufferedReader 정리
#### 기본 구조
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
```
- System.in -> 키보드 입력
- InputStreamReader -> 바이트를 문자로 변환
- BufferedReader -> 문자열을 버퍼에 저장해서 한 줄씩 빠르게 읽음

#### 한 줄씩 입력 받기
`String input = br.readLine();  // 엔터 기준 한 줄 전체 읽기
`
-> 숫자로 입력 받으려면 `Integer.parseInt()`

#### 여러 개 입력 받기
: 공백으로 입력이 구분되어 있을 때 사용
```java
String[] tokens = br.readLine().split(" ");
int a = Integer.parseInt(tokens[0]);
int b = Integer.parseInt(tokens[1]);

```

#### 빠른 출력 사용
```java
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
bw.write("출력할 문자열\n");
bw.flush();  // 출력 강제 수행
bw.close();

```

</br>

### 추가 문제
<details>
<summary>📚 커스텀 정렬 관련 추가 연습 문제</summary>

1. 단어 정렬 (백준 1181)

- [문제 링크](https://www.acmicpc.net/problem/1181)
- 조건:
  - 길이가 짧은 단어가 앞에
  - 길이가 같으면 사전 순 정렬

---

2. 좌표 정렬하기 2 (백준 11651)

- [문제 링크](https://www.acmicpc.net/problem/11651)
- 조건:
  - y좌표 오름차순
  - y가 같으면 x좌표 오름차순

---

3. 나이순 정렬 (백준 10814)

- [문제 링크](https://www.acmicpc.net/problem/10814)
- 조건:
  - 나이 오름차순
  - 나이가 같으면 가입한 순서 유지 (안정 정렬)

---

4. 국영수 (백준 10825)

- [문제 링크](https://www.acmicpc.net/problem/10825)
- 조건:
  1. 국어 내림차순
  2. 국어 같으면 영어 오름차순
  3. 국, 영 같으면 수학 내림차순
  4. 모든 점수 같으면 이름 사전 순 오름차순

---

5. 단어 공부 (백준 1157)

- [문제 링크](https://www.acmicpc.net/problem/1157)
- 조건:
  - 가장 많이 나온 알파벳 출력
  - 대소문자 구분 없이
  - 여러 개면 `?`

---

6. 파일 정렬 (카카오 2018 - [정렬, 문자열 파싱 문제])

- [문제 링크 (프로그래머스)](https://school.programmers.co.kr/learn/courses/30/lessons/17686)
- 조건:
  - HEAD 기준 정렬 (사전 순)
  - NUMBER 기준 정렬 (숫자 오름차순)
  - 원래 순서 유지 (HEAD, NUMBER 같으면)

</details>


