import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 특정한 정수 상한액 계산. 그 이상인 상한액을, 상한액 이하의 요청에는 그대로 배정
 * 상한액을 계산하는 정해진 공식은 별도로 없으며, 예산을 최대한 배정하고자 하는 문제
 */
public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 지방의 수
        int N = Integer.parseInt(br.readLine());
        
        // 요청 예산
        int[] arr = new int[N];
        int max = 0; //상한선 후보
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	max = Math.max(max, arr[i]);
        }
        
        // 총 예산
        int M = Integer.parseInt(br.readLine());
        
        // 하한선, 상한선 초기화
        int low = 0;
        int hight = max;
        int answer = 0;
        
        while(low <= hight) {
        	int mid = (low + hight) / 2;
        	
        	// 현재의 상한선(mid) 를 모두 소진해야 하는지, 그것보다 적게 지급하고 끝낼 수 있는지 !
        	long total = 0;
        	for(int i=0; i<N; i++) {
        		total += Math.min(arr[i],  mid);
        	}
        	
        	// 예산 내에서 total 이 해결될 수 있는 경우, 상한선을 갱신하고, 최소값을 올려본다.
        	if(total <= M) {
        		answer = mid;
        		low = mid + 1;
        	}else {
        		hight = mid - 1;
        	}
        }
        
        System.out.println(answer);
	}


}
