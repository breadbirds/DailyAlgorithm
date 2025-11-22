import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        // int[] -> String[]
        String[] arr = new String[numbers.length];
        for(int i=0; i<numbers.length;i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        
        // 정렬하기 b+a 했을때 내림차순 (큰 값이 앞으로)
        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));
        
        // 0 일 경우 예외처리
        if(arr[0].equals("0")) return "0";
        
        // 0이 아닐 경우 이어붙여 최대값 만들기
        StringBuilder sb = new StringBuilder();
        for(String num: arr) sb.append(num);
        
        return sb.toString();
    }
}