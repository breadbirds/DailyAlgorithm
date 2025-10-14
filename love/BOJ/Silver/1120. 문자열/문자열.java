import java.io.*;
import java.util.*;


/**
 * 문제 읽기
 * - 길이가 N인 문자열 X, Y 가 주어짐. 이 때, 두 문자열 X 와 Y의 차이는 X[i] != Y[i]인 i 의 개수
 *   ex) X = jimin , Y = minji 일 때, 둘의 차이는  ==> index 1 번째만 동일하다는 의미  
 *   
 * - 두 문자열 A, B 가 주어진다.
 * - A의 길이는 B의 길이보다 작거나 같다.
 * - A의 길이가 B 길이와 같아질 때 까지 다음과 같은 연산을 할 수 있다.
 * 	 1. A의 앞에 아무 알파벳이나 추가
 *   2. A의 뒤에 아무 알파벳이나 추가
 * 
 * - 이때, A와 B의 길이가 같으면서 A와 B의 차이를 최소로 하는 프로그램을 작성하여라
 * 
 * 
 * 오답 포인트... ㅜㅜ
 * - 처음엔 a~z 까지 모든 경우의 수를 문자열 앞/뒤에 다 대입하는 dfs 를 생각했었으나, 시간초과 발생.
 *   해답을 찾아보니 그렇게 까지 계산할 필요가 없다! 문제에서 주어진것처럼 어떤 문자를 넣든 상관 없고, AB의 길이 차이만 최소로 하면 되기 때문에...
 *   a 와 b 문자열의 offset. 다른 문자의 개수만 확인하면 되는 문제
 * 
 */
public class Main {

	static int answer;
	static String A, B;
	
    public static void main(String[] args) throws Exception {
    	
    	// init & input
    	Scanner sc = new Scanner(System.in);
    	String[] str = sc.nextLine().split(" ");
    	A = str[0];
    	B = str[1];
    	answer = Integer.MAX_VALUE;
    	
    	int n = A.length();
    	int m = B.length();
    	int gap = m - n;
    	
    	
    	/**
    	 * Simulation
    	 * 현재 문자열 A를 B와 비교해서 일치하는 부분이 몇개인지 확인
    	 * 문자열 A와 B + 문자열을 비교하기 위한 B의 시작위치 start 를 넘긴다.
    	 */
    	for(int start=0; start <= gap; start++) {
    		int diff = diffAt(start);
    		if (diff < answer) answer = diff;
    	}
    	

    	// Result
    	System.out.println(answer);
    }
    
    // A와 B의 [i .. i+ A.length-1] 구간을 직접 비교!
    // 여기서 A를 B 안의 특정 위치 's' 에 겹쳐서! 놓아주어야 함
    private static int diffAt(int start) {
    	int cnt = 0;
    	
    	for(int i=0; i<A.length(); i++) {
    		// B.charAt(i)는 항상 B의 0번째부터와 비교한다는 의미이므로 잘못된 수식
    		if(A.charAt(i) != B.charAt(start+i)) cnt++;
    	}
    	
    	return cnt;
    }


}
