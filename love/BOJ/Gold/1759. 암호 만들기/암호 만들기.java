import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * 문제 읽기
 * - 암호는 서로 다른 L 개의 알파벳 소문자로 구성된다.
 *   최소 한개의 모음(a, e, i, o, u) + 두 개의 자음 으로 구성
 *  
 * - 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되어 있을 것	
 *   abc 는 가능성 있지만, bac 는 그렇지 않음
 *   
 *   
 * - 새 보안 시스템에서 암호로 사용했을 법한 문자의 종류는 C 가지
 * - C개의 문자들이 모두 주어졌을 때, 가능성 있는 암호를 모두 구하여라!
 */
public class Main {
	
	static int L, C;
    static char[] arr;
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	// init & input
    	L = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
        arr = new char[C];

    	st = new StringTokenizer(br.readLine());
    	for(int i=0; i<C; i++) {
    		arr[i] = st.nextToken().charAt(0);
    	}
    	Arrays.sort(arr);

    	
    	// Simulation
        dfs(0, 0, 0, 0, new StringBuilder());
    	
    	// Result
    	System.out.println(out);
    }
    
    static boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }

    // 선택할 문자 idx, 현재 문자열의 길이 len, 모음 v, 자음 cons
    static void dfs(int idx, int len, int v, int cons, StringBuilder cur){
    	
    	// 종료 조건 : 전체 글자수에 도달 했을 경우 : 모음 1개 이상 & 자음 2개 이상 구성일 때에만 추가
        if(len == L){
            if(v >= 1 && cons >= 2) out.append(cur).append('\n');
            return;
        }
        
        // 중단조건1 : 현재위치가 동일하여 (idx == C) 더이상 후보군이 없는 경우
        if(idx == C) return;
        
        // 중단조건2 : 남은 후보 개수(len + (C-idx)) 가 목표길이(L) 보다 작은 경우, 
        if(len + (C - idx) < L) return; // 남은 문자 수 부족 가지치기

        for(int i=idx; i<C; i++){
            char ch = arr[i];
            cur.append(ch);
            
            // 재귀 : 모음/자음 여부 따져서 값 다르게 넘기기
            if(isVowel(ch)) 
            	dfs(i+1, len+1, v+1, cons, cur);
            else            
            	dfs(i+1, len+1, v, cons+1, cur);
            
            // // 방금 추가한 마지막 문자 제거 = 백트래킹
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
