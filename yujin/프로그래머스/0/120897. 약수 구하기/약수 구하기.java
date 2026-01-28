import java.util.*;

class Solution {
    
    public int[] solution(int n) {
       List<Integer>answer = new ArrayList<>();
        
        for(int i = 1; i <= n; i++){
        if(n%i == 0){
            answer.add(i);
        }
        }
        
        int []result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
        	result[i] = answer.get(i);
        }
        return result;
    }
}