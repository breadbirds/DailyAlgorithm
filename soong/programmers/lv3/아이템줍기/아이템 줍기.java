import java.util.*;
class Solution {
    
    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Node)) return false;
            Node other = (Node) obj;
            return this.x == other.x && this.y == other.y;
        }
    }
    
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
}
