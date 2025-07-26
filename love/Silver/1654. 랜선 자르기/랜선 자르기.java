import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
       
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int K = Integer.parseInt(st.nextToken());
    	int N = Integer.parseInt(st.nextToken());
    	
    	int[] arr = new int[K];
    	long max = 0;
    	
    	for(int i=0; i<K; i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    		if(arr[i] > max) max = arr[i];
    	}
    	
    	
    	long answer = 0;
    	long start = 1;
    	long end = max;
    	
    	while(start <= end) {
    		long mid = (start + end) / 2;
    		
    		long count = 0;
    		for(int i=0; i<K; i++) {
    			count += arr[i]/mid;
    		}
    		
    		if(count >= N) {
    			// 잘린 개수가 N개 이상이면 더 크게 잘라도 괜찮음 ! 문제 조건은 '최대 랜선 길이' 를 구해야하기 때문
    			answer = mid;
    			start = mid + 1;
    		}else {
    			end = mid - 1;
    		}
    	}
    	
    	
    	System.out.println(answer);
    }
}