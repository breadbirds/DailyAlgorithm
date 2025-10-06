
# [프로그래머스 - PCCP 기출] 붕대 감기

## ⏰  **time**
30분


## ⏲️**Time Complexity**
$O(N)$

## 풀이 

1. 대문자, 소문자 차이를 없애기 위해 소문자로 통일
2. 문자열을 2개씩 잘라서 스택에 넣는다. 여기서 특수문자나 공백을 만날 시 해당 원소는 버린다.
3. map을 활용해 각 원소의 중복 갯수를 구한다.
4. 합집합은 두 원소 중 큰 값을 교집합은 두 원소 중 작은 값을 더한다.
5. `분자 / 분모 * 65536` 의 값을 정수형으로 감싼다.


## 주의점
- 분모가 0이면 65536이지만, 분자가 0이면 그냥 0이어야함!

```java
class Solution {

    public int solution(String str1, String str2) {

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Stack<String> strChar1 = new Stack<>();
        Stack<String> strChar2 = new Stack<>();

        String tmp = "";
        for (char c : str1.toCharArray()) {
            if (c == ' ' || c < 97 || c > 122) {
                tmp = "";
                continue;
            }
            tmp += c + "";
            if (tmp.length() == 2) {
                strChar1.add(tmp);
                tmp = c + "";
            }
        }

        tmp = "";
        for (char c : str2.toCharArray()) {
            if (c == ' ' || c < 97 || c > 122) {
                tmp = "";
                continue;
            }
            tmp += c + "";
            if (tmp.length() == 2) {
                strChar2.add(tmp);
                tmp = c + "";
            }
        }

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < strChar1.size(); i++) {
            String key = strChar1.get(i);
            map1.put(key, map1.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < strChar2.size(); i++) {
            String key = strChar2.get(i);
            map2.put(key, map2.getOrDefault(key, 0) + 1);
        }

        int top = 0, down = 0;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {  // map2에 같은 원소가 있음
                top += Math.min(map2.get(key), map1.get(key));
                down += Math.max(map2.get(key), map1.get(key));
            } else {
                top += 0;
                down += map1.get(key);
            }

        }

        for (String key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                down += map2.get(key);
            }
        }

        if (top >= 0 && down > 0) {
            return (int) (top * 65536 / down);
        } return 65536;
    }
}
```



## :black_nib: **Review**

다른 사람 풀이 코드 봤는데 스트림 범벅이라서 인류애 상실


## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/17677#

