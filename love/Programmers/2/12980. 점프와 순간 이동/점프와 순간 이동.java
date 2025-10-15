import java.util.*;
import java.io.*;

/**
[문제 읽기]
- 한 번에 K 칸 앞 으로 점프 : K 만큼의 건전지 사용량 줄어듬
- (현재까지 온거리) * 2 해당하는 위치로 순간이동 : 건저지 사용량 X
- 건전지를 아끼기 위해 점프를 최소화 하며 목적지까지 도착하기 위한 방법 (사용해야하는 건전지 사용량의 최솟값 return)
*/

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        while(n > 0){
            
            if(n%2 == 0){
                 n /= 2; 
            }else {
                n -= 1;
                answer++;
            }
        }

        return answer;
    }
}