
# [프로그래머스 - lv2] Summer/Winter Coding. 방문 길이

## ⏰  **time**
30분


## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**

경로는 `(x1, y1) -> (x2, y2)` 가 한 경로이다.

1. `(0, 0)` 에서 시작해 `move` 함수로 이동할 경로를 탐색한다.
2. `move` 함수에서는 다음으로 이동할 방향 `dir`로 이동한다. 단, 경계는 넘지 않아야 함.
3. 시작 경로인 `st`와 `next`를 해쉬 셋인 `lines`에 넣고, `next`를 다음 경로로 이동하기 위한 시작점인 `st`에 넣어 갱신한다.
4. 겹치지 않는 모든 경로가 들어가있는 `lines`의 크기를 출력한다.


```java
char[] dirsList = dirs.toCharArray();
HashSet<Line> lines = new HashSet<>();
Point st = new Point(0,0);

for(char dir : dirs.toCharArray()){
    Point next = move(dir, st);
    if(next.x != st.x || next.y != st.y){ // 경계 넘어가면 st 그대로
        lines.add(new Line(st.x, st.y, next.x, next.y));
        st = next;
    }
}

return lines.size();
```


## :black_nib: **Review**

HashSet에 넣을 때, 객체로 넣는 상황을 주의할 것.
HashSet은 객체로 인식하므로 값이 같아도, `new Point(0, 0)` 을 2번 넣으면 각각 다른 객체로 인식된다.



## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/49994

