import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Document {
    int index;
    int priority;

    Document(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCases = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCases; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서 수
            int K = Integer.parseInt(st.nextToken()); // 궁금한 문서 위치

            Queue<Document> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new Document(i, priority));
            }

            int count = 0;

            while (!queue.isEmpty()) {
                Document current = queue.poll();

                boolean hasHigherPriority = false;
                for (Document d : queue) {
                    if (d.priority > current.priority) {
                        hasHigherPriority = true;
                        break;
                    }
                }

                // 전체를 순회하는 별도 함수를 만들지 않더라도, 앞에서 판단되기 때문에 빠르게 해결 가능 
                if (hasHigherPriority) {
                    queue.add(current); // 뒤로 보냄
                } else {
                    count++; // 인쇄
                    if (current.index == K) {
                        sb.append(count).append("\n");
                        break;
                    }
                }
            }
        }

        System.out.print(sb);
    }
}