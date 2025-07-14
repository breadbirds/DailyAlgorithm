import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 태수의 새로운 점수가 랭킹 리스트에 몇 등으로 들어갈 수 있는지 계산
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 현재 점수 개수
        int newScore = sc.nextInt(); // 태수의 점수
        int P = sc.nextInt(); // 랭킹에 올라갈 수 있는 최대 인원 수

        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            scores.add(sc.nextInt());
        }

        int rank = 1; // 등수는 1등부터 시작
        for (int score : scores) {
            if (score > newScore) {
                rank++;
            } else {
                break;
            }
        }

        // 리스트가 비어있거나, 아직 여유가 있다면 등수 출력
        if (N < P) {
            System.out.println(rank);
        }
        // 리스트가 꽉 찼을 때
        else {
            // 만약 마지막 점수와 동점이거나 더 낮으면 못 들어감
            if (N > 0 && scores.get(P - 1) >= newScore) {
                System.out.println(-1);
            } else {
                System.out.println(rank);
            }
        }
    }
}
