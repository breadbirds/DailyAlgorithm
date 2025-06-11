# 백준 1157 단어 공부 | 브론즈 1

### 문제
[😈 문제 바로가기](https://www.acmicpc.net/problem/1157)

### 나의 코드
```java
package source_code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 대소문자 단어에서 가장 많이 사용된 알파벳 찾기
// 결과가 하나가 아니라면 ? 출력

// 입력: 대소문자 섞인 단어
// 출력: 알파벳 or ?

// 1. 소문자를 전부 대문자로 통일
// 2. 단어를 알파벳 별로 살피며 개수 체크 후 map 저장
// 3. 가장 많은 수가 저장된 map의 키를 출력
// 3-1. 여러 개라면 ? 출력

public class B_B1_1157_WordStudy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		
		// 1. 소문자를 전부 대문자로 통일
		char[] upperWord = word.toUpperCase().toCharArray();
				
		// 2. 단어를 알파벳 별로 살피며 개수 체크 후 map 저장
		Map<Character, Integer> wordCnt = new HashMap<>();
		for(char s : upperWord) {
			// 이미 존재하는 키라면 값 ++
			if(wordCnt.containsKey(s)) {
				wordCnt.put(s, wordCnt.get(s) + 1);
			} else { // 없으면 키 추가
				wordCnt.put(s, 1);
			}
		}
		
		// 3. 가장 많은 수가 저장된 map의 키를 출력
		int maxNum = -1;
		char maxChar = '?';
		int sameCnt = 0;
		
		for(char c : wordCnt.keySet()) {
			if(wordCnt.get(c) > maxNum) {
				maxNum = wordCnt.get(c);
				maxChar = c;
			}
		}
		
		for(char c : wordCnt.keySet()) {
			if(wordCnt.get(c) == maxNum) {
				sameCnt++;
			}
		}
		
		
		if(sameCnt > 1) {
			System.out.println("?");
		} else {
			System.out.println(maxChar);

		}
	}
}
```

대문자-소문자 변환 함수와 map을 이용해서 문제를 풀었다.

#### 피드백
`개선점`
- **put() 중복 제거**
	containsKey() 없이 getOrDefault() 쓰면 비교 안해도 됨
- **max 계산 & 동점자 확인 한 번에 처리**
	하나의 for문 안에서 처리할 것
- **스캐너 종료하는 습관 들이기** : `sc.close()`

</br>

### 개선 코드
```java
public class B_B1_1157_WordStudy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine().toUpperCase();
        sc.close();

        Map<Character, Integer> wordCnt = new HashMap<>();
        for (char ch : word.toCharArray()) {
            wordCnt.put(ch, wordCnt.getOrDefault(ch, 0) + 1);
        }

        int max = -1;
        char result = '?';

        for (char c : wordCnt.keySet()) {
            int cnt = wordCnt.get(c);
            if (cnt > max) {
                max = cnt;
                result = c;
            } else if (cnt == max) {
                result = '?';
            }
        }

        System.out.println(result);
    }
}


```
	