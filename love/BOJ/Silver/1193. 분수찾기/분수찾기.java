import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        sc.close();

        int line = 1; // 현재 대각선 번호
        int count = 0; // 지금까지의 누적 항 개수

        // 1. X가 포함된 대각선을 찾기
        while (count + line < X) {
            count += line;
            line++;
        }

        // 2. 대각선 안에서의 순서 (1-based)
        int pos = X - count;

        // 3. 짝수 / 홀수 대각선에 따라 분자, 분모 계산
        int numerator, denominator;
        if (line % 2 == 0) { // 짝수 줄은 위에서 아래로
            numerator = pos;
            denominator = line - pos + 1;
        } else { // 홀수 줄은 아래에서 위로
            numerator = line - pos + 1;
            denominator = pos;
        }

        System.out.println(numerator + "/" + denominator);
    }
}
