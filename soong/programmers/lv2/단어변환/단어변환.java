import java.util.*;

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
