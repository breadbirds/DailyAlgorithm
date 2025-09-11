
# [프로그래머스 - lv1] 월간 코드 챌린지 시즌 1. 두 개 뽑아서 더하기

## ⏰  **time**
30분


## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**

1. 오름 차순 정렬과 다른 수로 이뤄져야 하기 때문에, 순서가 있는 `TreeSet`을 활용합니다.
2. 배열 중 두 수를 더해 나올 수 있는 모든 값을 `set`에 넣고, `int[]` 배열 형태로 변경해줍니다.



```java
TreeSet<Integer> set = new TreeSet<Integer>();
for (int i = 0; i < numbers.length - 1; i++) {
    for (int j = i + 1; j < numbers.length; j++) {
        int sum = numbers[i] + numbers[j];
        set.add(sum);
    }
}
```


## :black_nib: **Review**

시간 복잡도 구하기 한번 해봤다!



## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/68644

