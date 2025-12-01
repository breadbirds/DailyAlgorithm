import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        int n = s.length();
        int answer = 0;

        // i: 팰린드롬이 시작되는 인덱스 후보
        for (int i = 0; i < n; i++) {
            if (isPalindrome(s, i, n - 1)) {
                // 앞부분 s[0..i-1] 를 뒤에 붙이면 됨 → 길이 = n + i
                answer = n + i;
                break;
            }
        }

        System.out.println(answer);
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
