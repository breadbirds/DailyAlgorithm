# [프로그래머스 - Lv3] 아이템 줍기

## ⏰  **time**
60분

## :pushpin: **Algorithm**
BFS, HashSet 정렬

## ⏲️**Time Complexity**


## :round_pushpin: **Logic**

1. 모든 사각형의 경계선에 속하는 좌표를 모두 set에 넣는다.
2. 그 중 다른 사각형의 내부에 들어가는 좌표를 제거한다.
3. 시작 좌표인 `characterX`, `characterY`부터 hashset안에 있는 좌표고 방문하지 않았으면 방문 set에 넣고 방문처리해준다.!


```java
static HashSet<Node> set;
public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
    int answer = 0;
        
    set = new HashSet<>();
        
    for(int[] pos: rectangle) {
        int x1 = pos[0] * 2, y1 = pos[1]* 2;
        int x2 = pos[2]* 2, y2 = pos[3]* 2;
            
        for(int i = x1; i <= x2; i++) {
            set.add(new Node(i, y1));
            set.add(new Node(i, y2));
        }
           
        for(int i = y1; i <= y2; i++) {
            set.add(new Node(x1, i));
            set.add(new Node(x2, i));
        }
    }
        
    // 내부 제거
    for(int[] pos: rectangle) {
        int x1 = pos[0]* 2, y1 = pos[1]* 2;
        int x2 = pos[2]* 2, y2 = pos[3]* 2;
            
        for (int x = x1 + 1; x < x2; x++) {
            for (int y = y1 + 1; y < y2; y++) {
                set.remove(new Node(x, y));
            }
        }
    }
        
    visited = new HashSet<>();
    answer = bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        
    return answer;
}
    
static HashSet<Node> visited;
static int[] dx = {-1, 1, 0, 0};
static int[] dy = {0, 0, -1, 1};
static int bfs(int sx, int sy, int tx, int ty) {
        
    Queue<Node> queue = new ArrayDeque<>();
    queue.offer(new Node(sx, sy));
    visited.add(new Node(sx, sy));
    int steps = 0;
        
    while(!queue.isEmpty()) {
     
        int size = queue.size();            
        for(int s = 0; s < size; s++) {
            Node curr = queue.poll();
            if (curr.x == tx && curr.y == ty) return steps / 2;
                
            for(int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                    
                Node next = new Node(nx, ny);
                if (set.contains(next) && !visited.contains(next)) {
                    visited.add(new Node(nx, ny));
                    queue.offer(new Node(nx, ny));
                }
            }
        }
            
        steps++;
    }
    return 0;
}
```

## :black_nib: **Review**

노드 방문 처리는 HashSet으로 하는게 더 편하다. 
그리고 왜 좌표를 아직도 2배 해주는지 몰겟슨.. 그리고 큐에 들어갈때마다 한 스텝이 아니고 좌표 탐색이 끝낫을대 step을 +1해야한다.


## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/87694
