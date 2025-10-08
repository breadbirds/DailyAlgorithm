
# [프로그래머스] 2018 kakao blind recruitment [1차] 프렌즈4블록

## ⏰  **time**
1시간 30분


## ⏲️**Time Complexity**


## 풀이 

1. 각 모양별 좌표 값을 `map`에 넣는다.
2. 한 노드에서 붙어있는 4개의 블록이 같은 모양이라면, 제거할 좌표를 모은 `toRemove` Set에 넣는다.
3. 만약 `toRemove`의 크기가 0이라면 즉, 제거할 좌표가 더 없으면 반복문을 나간다.
4. 모두 제거한 후, `x` 좌표를 내릴 수 있는 만큼 내린다. => `fallInLove()` 함수
5. `boards`도 map의 좌표값을 반영해 다시 초기화한다.  => `updateBoards()` 함수


```java
while(true) {
        // 제거할 노드들을 먼저 모음
        Set<Node> toRemove = new HashSet<>();
        map.forEach((key, nodes) -> {
            for(Node node : nodes) {
                if (node.x + 1 < m && node.y + 1 < n) {
                    if (boards[node.x + 1][node.y].equals(key) && 
                        boards[node.x][node.y + 1].equals(key) &&
                        boards[node.x + 1][node.y + 1].equals(key)) {

                        toRemove.add(new Node(node.x, node.y));
                        toRemove.add(new Node(node.x + 1, node.y));
                        toRemove.add(new Node(node.x, node.y + 1));
                        toRemove.add(new Node(node.x + 1, node.y + 1));
                    }
                }
            }
        });
            
        if (toRemove.size() == 0) break;
           
        // 제거하기
        map.forEach((key, nodes) -> nodes.removeAll(toRemove));
        for(Node node : toRemove) {
            boards[node.x][node.y] = "";
        }
            
        answer += toRemove.size(); 
        map = fallInLove(map, m);
        updateBoards(boards, map, m, n);
    }
        
    return answer;
}
    
static HashMap<String, ArrayList<Node>> fallInLove(HashMap<String, ArrayList<Node>> map, int m) {
        
    List<Node> allNodes = new ArrayList<>();
    for(ArrayList<Node> nodes : map.values()) {
        allNodes.addAll(nodes);
    }
        
    allNodes.sort((a, b) -> b.x - a.x);  // 내림차순
     
    for(Node node : allNodes) {
        while (node.x + 1 < m && !hasNode(map, node.x + 1, node.y)) {
            node.x += 1;
        }
    }
    return map;
}
    
static boolean hasNode(HashMap<String, ArrayList<Node>> map, int x, int y) {
    for(ArrayList<Node> nodes: map.values()) {
        for(Node n: nodes) {
            if (n.x == x && n.y == y) {
                return true;
            }
        }
    }
    return false;
}
    
static void updateBoards(String[][] boards, HashMap<String, ArrayList<Node>> map, int m, int n) {
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            boards[i][j] = "";
        }
    }

    map.forEach((key, nodes) -> {
        for(Node node : nodes) {
            boards[node.x][node.y] = key;
        }
    });
}
```



## :black_nib: **Review**

다른 사람 풀이 코드 봤는데 스트림 범벅이라서 인류애 상실


## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/17677#

