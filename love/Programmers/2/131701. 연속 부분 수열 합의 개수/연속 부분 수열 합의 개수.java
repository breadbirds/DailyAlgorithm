import java.io.*;
import java.util.*;

/**
[문제 읽기]
- 원형 수열 : 처음과 끝이 연결된 형태의 수열
- 원형 수혈의 연속 부분 수열 합으로 만들 수 있는 수의 개수
*/
class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> sums = new HashSet<>();
        
        // 원형 배열이 끊어지지 않기 위해 2배로 길이 늘리기
        int[] arr2 = new int[n*2];
        for(int i=0; i<n*2; i++){
            arr2[i] = elements[i%n];
        }
        
        // 합 구하기
        for(int len=1; len<=n; len++){

            //
            int sum = 0;
            for(int start = 0; start<n; start++){
                // 초기 윈도우 합
                if(start == 0){
                    for(int k=0; k<len; k++){
                        sum += arr2[k];
                    }
                }else{
                    // 슬라이딩 윈도우 방식 : 오른쪽에서 새로 들어오는값 더하기, 왼쪽 값 하나 빼기 왼쪽 값 하나 빼기
                    sum = (sum - arr2[start - 1]) + arr2[start + len - 1];
                }
                
                // Set 에 추가
                sums.add(sum);
            }
            
        }
        
        return sums.size();
    }
}