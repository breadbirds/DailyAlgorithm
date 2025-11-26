
# [프로그래머스 - 2019 카카오 개발자 겨울 인턴십] 튜플

## ⏰  **time**
60분


## ⏲️**Time Complexity**
$O(N)$

## 풀이 

처음에 문제 이해가 어려웠다. 처음엔 가장 긴 길이의 튜플을 list에 넣어 출력했는데 그게 아니었다!!
튜플을 크기 순으로 정렬해서, 거기서 처음 만나는 수면 `set`에 넣고, set에 넣게 되면 리스트인 `result`에도 넣는 것이었다.
그냥 처음 만난 순서대로 출력하기..

```java
List<List<Integer>> list = new ArrayList<>();
List<Integer> arr = null;
StringBuilder num = new StringBuilder();
        
for(char c: s.toCharArray()) {
    if (c == '{') {
        arr = new ArrayList<>();
    } else if (c == '}') {
         if (num.length() > 0) {     // 아직 안 넣은 숫자 있으면 처리
             arr.add(Integer.parseInt(num.toString()));
             num.setLength(0);
          }
         list.add(arr);
    }  else if (Character.isDigit(c)) { // 숫자
         num.append(c);              
    } else {
        if (num.length() > 0) {     // 숫자 종료 시 리스트에 넣기
             arr.add(Integer.parseInt(num.toString()));
             num.setLength(0);
        }
    }
}
```
```java
list.sort(Comparator.comparingInt(List::size));  // 크기순 정렬
Set<Integer> set = new HashSet<>();
List<Integer> result = new ArrayList<>();
        
for(List<Integer> l : list) {
    for(int x: l) {
        if(set.add(x)) {
            result.add(x);
        }
    }
}
```

## :black_nib: **Review**




## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/64065

