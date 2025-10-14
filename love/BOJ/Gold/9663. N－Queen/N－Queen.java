import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
    static int N;
    static int[] arr;

    /**
     * 문제 핵심: 퀸을 놓을 때 가로, 세로, 대각선에 퀸이 겹치지 않도록 배치해야 함
     * 퀸은 한 줄에 하나만 놓을 수 있기 때문에, 한 행(row)마다 퀸을 배치하고
     * 그 배치가 유효한지 체크하면서 다음 행으로 넘어가는 방식으로 해결 (백트래킹 사용)
     */
    
    // Main 코드
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // N*N 격자 크기
        arr = new int[N];
        System.out.println(dfs(0));
    }

    
    /********** 함수 생성 **********/

    // 백트래킹을 통해 N개의 퀸을 놓는 경우의 수 계산
    public static int dfs(int row) {
        
        if(row == N) return 1;
        
        int ans = 0;
        for(int i=0; i<N; i++){
            arr[row] = i;
            
            if(isPossible(row)){
                ans += dfs(row + 1);
            }
        }
        
        return ans;
    }
    
    
    // 퀸을 놓았을 때 유효한 위치인지 확인하는 함수
    // row: 현재 행에서 퀸을 놓은 위치
    // 퀸을 표시하는게 아니라 제한 조건이 되는 위치에 퀸이 있는가 여부만 판단하는 역할을 한다.
    public static boolean isPossible(int row) {
        for(int i=0; i<row; i++){
            if(arr[row] == arr[i]) return false;
            
            if(Math.abs(arr[row] - arr[i]) == row-i) return false;
        }
        
        return true;
    }

}