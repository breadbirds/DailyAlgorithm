import java.util.*;

public class Main {
	
	public static int N;
	public static String balls;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        balls = sc.next();

        int moveRedLeft = countToMove('R', true);
        int moveRedRight = countToMove('R', false);
        int moveBlueLeft = countToMove('B', true);
        int moveBlueRight = countToMove('B', false);

        // Result
        int answer = Math.min(Math.min(moveRedLeft, moveRedRight), Math.min(moveBlueLeft, moveBlueRight));
        System.out.println(answer);
    }

    private static int countToMove(char color, boolean toLeft) {
        int count = 0;
        int len = balls.length();

        // 연속된 같은 색 제외 : true(왼쪽으로 공몰이) false(오른쪽으로 공몰이)
        if (toLeft) {
            int idx = 0;
         
            //왼쪽에 연속되어 있는공은 제외(움직일 필요없음) : while() 조건문으로, 다른색상의 공이 나오면 바로 탐색을 멈춤
            while (idx < len && balls.charAt(idx) == color) {
                idx++;
            }
            for (int i = idx; i < len; i++) {
                if (balls.charAt(i) == color) count++;
            }
        } else {
            int idx = len - 1;
            while (idx >= 0 && balls.charAt(idx) == color) {
                idx--;
            }
            for (int i = 0; i <= idx; i++) {
                if (balls.charAt(i) == color) count++;
            }
        }

        return count;
    }
}
