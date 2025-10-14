import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
    public static final int MAX_N = 6;
    
    public static String[] arr = new String[MAX_N];
    public static HashMap<String, Integer> stringToIndex = new HashMap<>();

    public static void main(String[] args) throws IOException{
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	int[] trees = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N; i++) {
    		trees[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	
    	// 최대값 설정을 위해, 나무들 중 가장 키가 큰 것 찾기
    	int result = 0;
    	int start = 0;
    	int end = Arrays.stream(trees).max().getAsInt();
    	
    	while(start <= end) {
    		int mid = (start + end) / 2;
    		
    		// mid 가 나무를 자르기 위한 기준점 == H
    		long sum = 0;
    		for(int tree: trees) {
    			if(tree > mid) sum += tree - mid;
    		}
    		
    		
    		// 더 큰 값, 즉 최소화 할 수 있는 상황이면 start 값이 증가하고,
    		// 그럴수 없다면 end 값이 줄어들기 때문에 while 문이 제대로 끝날 수 있게 된다.
    		if(sum >= M) {
    			result = mid;
    			start = mid + 1;
    		} else {
    			end = mid - 1;
    		}
    		
    	}
    	
    	System.out.println(result);
    	
    	
    }
}
