import java.util.*;
class Solution {
    
    static class Node {
        int x, y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
        
        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        HashMap<String, ArrayList<Node>> map = new HashMap<>();
        String[][] boards = new String[m][n];
        for(int i = 0; i < m; i++) {
            int j = 0;
            for(String b: board[i].split("")) {
                boards[i][j] = b;
                // 키 없으면, 새 list 생성
                map.putIfAbsent(b, new ArrayList<>());
                // 키의 리스트에 Node 추가
                map.get(b).add(new Node(i, j++));
            }
        }
        
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
}