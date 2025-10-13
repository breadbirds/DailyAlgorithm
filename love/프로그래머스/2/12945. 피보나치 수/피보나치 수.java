import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        
        // 초기화
        final int MOD = 1234567;
        if (n == 0) return 0;
        if (n == 1) return 1;

        // 모든 피보나치값을 저장하는 배열을 사용하지 않고, n-2 와 n-1 에 해당하는 2개의 변수로 해결 가능
        int a = 0; // F(0)
        int b = 1; // F(1)
        for (int i = 2; i <= n; i++) {
            int c = (a + b) % MOD; // 여기서 '매번 mod'
            a = b;
            b = c;
        }
        
        return b; // 이미 mod 상태라 그대로 반환해도 OK
    }
}