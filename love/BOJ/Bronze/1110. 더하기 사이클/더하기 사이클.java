import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 문제 : https://www.acmicpc.net/problem/1110
 * 
 * 풀이 방식
 * - 처음 문제를 읽고, 풀이 과정을 생각하면서 항상 '주어진 수의 오른쪽 수' 에 집착(?) 해서 문자 형태만 생각했다.
 *   그런데... n/10, n%10 으로 각 자리수 합을 쉽게 구하는걸 잊고 있었다.. 충격
 *   이렇게 간단히 풀 수 있는걸 수십줄 씩 문자열 -> 숫자 변환 형태로 풀 뻔 !
 *   
 *   문제를 읽고 규칙을 써내려가는 것 뿐만 아니라, 반복되는 규칙을 효율적으로 풀어나갈 방법도 잊지말고 적용하도록 노력..!
 */
public class Main {
	
    public static void main(String[] args) throws Exception{
     
    	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           int n = Integer.parseInt(br.readLine());
           int origin = n;
           int count = 0;

           do {
               int left = n / 10;        // 십의 자리
               int right = n % 10;       // 일의 자리
               int sum = left + right;
               n = right * 10 + (sum % 10); // 새로운 수 *10 을 하는 이유는, right 값은 십의 자리로 와야하기 때문 !
               count++;
           } while (n != origin);

           System.out.println(count);
    	
    }
}
