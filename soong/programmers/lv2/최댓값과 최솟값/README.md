
# [프로그래머스 - lv2] 최댓값과 최솟값

## ⏰  **time**
10분


## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**

최댓값과 최솟값을 구하기!


```java
import java.util.*;
class Solution {
    public String solution(String s) {
  
        String[] split = s.split(" ");
        int[] nums = new int[split.length];
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        
        return min + " " + max;
    }
}
```


## :black_nib: **Review**

몸풀기~ 쉽구만유


## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/12939?language=java

