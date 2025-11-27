import java.io.*;
import java.util.*;

/**
- 각 기능은 진도가 100% 일 때, 서비스에 반영할 수 있다.
- 모든 기능의 개발속도는 다르며 뒤에 있는 기능은 앞 기능이 배포될 때 함께 배포된다.
- 먼저 배포되어야하는 순서대로 작업의 진독 ㅏ적힌 정수배열 & 작업 개발속도 배열
- 각 배포마다 몇 개의 기능이 배포되는가?
*/
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++){
            int days = 100 - progresses[i];
            days = days%speeds[i] == 0 ? days/speeds[i] : days/speeds[i]+1;
            queue.add(days);
            System.out.println(days);
        }
        

        ArrayList<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            

            int day = 0;
            int first = queue.peek();
            
            while(!queue.isEmpty() && queue.peek() <= first){
                queue.poll();
                day++;
            }
            
            list.add(day);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}