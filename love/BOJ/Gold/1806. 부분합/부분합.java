import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int S = Integer.parseInt(st.nextToken());
    	int[] arr = new int[N];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N; i++)
    		arr[i] = Integer.parseInt(st.nextToken());
    
    	// 슬라이딩 윈도우 계산하기 : 부분합 이 (S) 이상이며, 길이기 가장 짧은 구간의 길이를 출력
    	int left = 0;
    	int right = 0;
    	
    	int sum = 0;
    	int answer = N+1; // 최소 구간을 구하는 문제이기 때문에 정답이 N+1 길이 이상 나올 수가 없다.
    	
    	while(true) {
    		if(sum >= S) {
    			answer = Math.min(answer, right-left);
    			sum -= arr[left++];
    		}else if (right == N) {
    			break;
    		}else {
    			sum += arr[right++];
    		}
    	}
    	
    	// 출력
    	System.out.println(answer == N + 1 ? 0 : answer);
    }
}
