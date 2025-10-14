import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.CopyOnWriteArrayList;
import java.io.IOException;

/**
 * [문제 읽기]
 * - 벨트 위에는 같은 종류의 초밥이 둘 이상 있을 수 있다.
 * - 벨트의 임이의의 한 위치부터 k 개의 접시를 연속해서 먹을 경우, 할인된 정액 가격으로 제공
 * - 각 고객에게 초밥의 종류가 하나씩 쓰인 쿠폰 발행 = 1번 행사에 참가할 경우, 쿠폰에 적힌 종류 초밥 하나를 무료 제공 (벨트위에 없으면 요리사가 만들어 제공)
 * - "가능한 다양한 종류의 초밥을 먹는것이 목표"
 * 
 * 
 * ** 초밥을 연속으로 먹어야 하기 때문에 중간에 건너뛰는 경우는 없다! 즉 right 혼자 증가하지는 않는 다는 것
 * ** Set을 사용할 경우 예외처리에 걸릴 수 있음 (초밥의 종류는 겹치는 경우가 있을수도 있다고 했기 때문)
 */
public class Main {

    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken()); // 접시의 수
    	int D = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
    	int K = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
    	int C = Integer.parseInt(st.nextToken()); // 쿠폰 번호
    	
    	int[] sushi = new int[N];
    	for(int i=0; i<N; i++) {
    		sushi[i] = Integer.parseInt(br.readLine());
    	}
    	
    	// 초기 셋팅
        int kind = 0; // 현재 먹은 초밥의 종류 수
    	int[] count = new int[D + 1]; // 각 초밥 번호별 현재 윈도우 내 개수
        for (int i = 0; i < K; i++) {
        	if (count[sushi[i]] == 0) kind++;
        	count[sushi[i]]++;
        }
        
        int answer = kind;
        if (count[C] == 0) answer++; // 쿠폰 초밥이 포함되지 않았다면
        
        // 슬라이딩 윈도우 순회
        for(int i=1; i<N; i++) {
        	// 앞에 초밥 제거
        	int remove = sushi[i - 1];
        	count[remove]--;
        	if (count[remove] == 0) kind--;
        	
        	// 뒤에 초밥 추가 (회전 인덱스 임에 주의 !)
        	int add = sushi[(i + K - 1) % N];
        	if (count[add] == 0) kind++;
        	count[add]++;
        	
        	// 쿠폰 포함 여부 체크
        	int currentKinds = kind;
        	if(count[C] == 0) currentKinds++;
        	
        	answer = Math.max(answer, currentKinds);
        }
        
        System.out.println(answer);
    }
}
