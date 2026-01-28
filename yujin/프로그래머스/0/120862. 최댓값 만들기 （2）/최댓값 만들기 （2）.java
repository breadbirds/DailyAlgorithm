import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int a = 0, b = 0;
        Arrays.sort(numbers);
        
        a = numbers[0]*numbers[1];
        b = numbers[numbers.length-1]*numbers[numbers.length-2];
        
        answer = Math.max(a, b);
        
        return answer;
    }
}