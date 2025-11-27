import java.io.*;
import java.util.*;

/**
[문제 읽기]
- 특정 프로세스가 몇 번째로 실행되는지 구하여라
- 우선순위는 숫자가 클 수록 높음
*/

class Solution {
    
    // 우선순위와 기존 위치 정보를 그대로 유지하기 위한 Node 객체
    class Node{
        int prioritie;
        int location;
        
        Node(int prioritie, int location){
            this.prioritie = prioritie; // 우선순위
            this.location = location; // 자신의 위치번호
        }
    }
    
    public int solution(int[] priorities, int location) {
        
        // 가장 높은 우선순위만 관리할 PQ
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // 자신의 번호와 우선순위를 가지는 Node 객체 생성
        Queue<Node> queue = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            queue.offer(new Node(priorities[i], i));
            pq.offer(priorities[i]);
        }
        
        // Simulation
        int turn = 0;
        
        while(!queue.isEmpty()){
            
            Node cur = queue.poll();
            
            // 최대값 비교
            if(cur.prioritie < pq.peek()){
                // 우선순위가 더 높은게 있다면 뒤로
                queue.offer(cur);
            }else{
                // cur 의 우선순위가 같거나 높은경우? 우선순위가 바뀌어야 하므로 pq 에서 값을 하나 제거한다.
                // 그리고 한번 이동한 것이 되므로 turn 값을 증가시킨다.
                pq.poll();
                turn++;
                
                // 현재값과 위치가 동일하다면
                if(cur.location == location) break;
            }
        }
        
        
        return turn;
    }
}