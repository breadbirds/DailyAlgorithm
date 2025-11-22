
# [프로그래머스 - lv2] 단어 변환

## ⏰  **time**
60분

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**

최단 거리를 구하기 위해 BFS를 사용한다. 문자 방문을 어떻게 표현할지 고민되었는데 `Set`을 사용해 해결하였다.
1. `word`가 타겟 단어와 같으면 `step`을 리턴하고 종료한다.
2. 만약 방문하지 않았고, 비교하는 단어 `word`와 한 단어 차이라면 queue에 넣고 방문 처리한다.



```java
class Solution {
    static class Node {
        int step;
        String ch;
        
        Node(String ch, int step) {
            this.ch = ch;
            this.step = step;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        visited = new HashSet<>();
        answer = convert(begin, target, words);
        
        return answer;
    }
    
    static HashSet<String> visited;
    static int convert(String begin, String target, String[] words) {
        
        Queue<Node> queue = new ArrayDeque<>();
        
        queue.add(new Node(begin, 0));
        visited.add(begin);
        
        while(!queue.isEmpty()) {
            
            Node curr = queue.poll();
            String word = curr.ch;
            int step = curr.step;
            
            if (word.equals(target)) {  // 타겟과 같으면
                // System.out.println(visited);
                return step;                
            }
        
            for(String w : words) {
                if (!visited.contains(w) && isOneDiff(word, w)) {
                    visited.add(w);
                    queue.offer(new Node(w, step + 1));
                }
            }
        }
        
        return 0;
    }
    
    static boolean isOneDiff(String word, String w) {
        
        char[] wordch = word.toCharArray();
        char[] wch = w.toCharArray();
        
        int cnt = 0;
        for(int i = 0; i < wordch.length; i++) {
            if (wordch[i] != wch[i]) {
                cnt++;
            }
        }
        
        return cnt == 1 ? true : false;
        
    }
}
```


## :black_nib: **Review**



## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/43163

