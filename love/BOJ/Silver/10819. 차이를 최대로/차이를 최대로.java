import java.io.*;
import java.util.*;


/**
 * 
 * 문제 읽기
 * 
 * - N 개의 정수로 이루어진 배열 A, 순서를 변경해서 최대값을 구하는 프로그램 작성
 * - 수의 순서를 변경하여 얻을 수 있는 식의 최댓값 출력하기
 * 
 * 수식
 * - |A[0] - A[1]| + |A[1] - A[2]| ....
 * 
 */
public class Main {

	static int N, answer;
	static int[] arr;
	
	// 수식 계산
    static int calc(int[] x){
        int s = 0;
        for(int i=0;i<N-1;i++) 
        	s += Math.abs(x[i] - x[i+1]);
        return s;
    }

    // idx 자리에 어떤 값을 놓을지 바꿔가며 보기 ~ 
    static void swap(int i, int j){
        int t = arr[i]; 
        arr[i] = arr[j]; 
        arr[j] = t;
    }

    public static void main(String[] args) throws Exception {
    	
    	// init & input
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	arr = new int[N];
    	answer = 0;
    	for(int i=0; i<N; i++)
    		arr[i] = sc.nextInt();

    	// Simulation
    	dfs(0);
    	
    	// Result
    	System.out.println(answer); // ✅ 결과 출력
    }
    
    static void dfs(int idx){
    	
    	// 중단 조건
        if (idx==N){ 
        	answer = Math.max(answer, calc(arr)); 
        	return; 
        }

        for (int i=idx;i<N;i++){
        	// 순서 바꾸기
            swap(idx, i);
            
            // 재귀 호출
            dfs(idx+1);
            
            // 원복
            swap(idx, i);
        }
    }


}
