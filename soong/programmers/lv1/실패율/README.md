
# [프로그래머스 - lv1] 2019 kakao blind recruitment. 실패율

## ⏰  **time**
30분


## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**

1. `stage`마다의 실패율을 담을 `fail`과 `stage`별 스테이지에 도달하지 못한 사람을 담을 `map`을 선언한다.
2. 스테이지에 도달하지 못한 사람들을 스테이지 별로 `map`에 넣어준다.
3. 실패율을 계산해 `fail`에 추가한다. 이때 주의점은 `total`이 0이 되었을 경우 `NaN` 오류 발생 가능성이 있어 if문으로 처리해준다.
 - "스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다."
4. 실패율(`fail`의 value 값)을 내림차순으로 정렬한다. 정렬된 스테이지 값들을 `result`에 넣어 출력한다.
 - 실패율이 같을 때 스테이지들을 오름차순으로 정렬하는 코드를 넣었는데 없어도 통과!


```java
int total = stages.length;
for(int key: map.keySet()) {
    int nonClear = map.get(key);
    if (total > 0) {
        fail.put(key, (double) nonClear / total);
    } else {
        fail.put(key, 0.0);
    }
    total -= nonClear;
}

List<Integer> keySet = new ArrayList<>(fail.keySet());
keySet.sort((o1, o2) -> {
    int cmp = fail.get(o2).compareTo(fail.get(o1));
    if (cmp == 0) {
        return o1.compareTo(o2);  // 값이 같으면 key를 오름차순
    }
    return cmp;
});
```


## :black_nib: **Review**

정렬하는 부분에서 좀 막혔다. 오름차순/내림차순 헷갈리지 말기



## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/42889

