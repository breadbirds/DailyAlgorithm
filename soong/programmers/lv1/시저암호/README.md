## [PGS - LV1] 시저 암호

`s`의 각 문자열에서 `n`만큼 뒤에 있는 문자를 구하는 문제

## 시간 복잡도
$O(N)$

## 제출 코드

- 소문자라면 `a`에서 얼마나 추가 되었는 지인 `(ch - 'a' + n)`에서 순환할 수 있게 알파벳 수인 26의 나머지를 구한다.
- 대문자도 동일

```java
class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for(char ch: s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                answer.append((char) ('a' + (ch - 'a' + n) % 26));
            } 
            else if (ch >= 'A' && ch <= 'Z') {
                answer.append((char) ('A' + (ch - 'A' + n) % 26));
            } else {
                answer.append(" ");
            }
        }
        
        return answer.toString();
    }
}
```
