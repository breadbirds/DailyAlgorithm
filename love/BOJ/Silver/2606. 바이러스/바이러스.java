import java.util.*;

public class Main {
    static int N, M, answer;
    static boolean[] visited;
    static List<Integer>[] graph;

    static void dfs(int node) {
        visited[node] = true;
        for (int next : graph[node]) {
            if (!visited[next]) {
            	answer++;
            	dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); 
        M = sc.nextInt(); 
        answer = 0;

        visited = new boolean[N + 1]; 
        graph = new ArrayList[N + 1];
  
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 친구 관계 입력 받기
        for (int i = 0; i < M; i++) {
            int v = sc.nextInt();
            int u = sc.nextInt();
            graph[v].add(u);
            graph[u].add(v);
        }
        
        
        dfs(1);


        System.out.println(answer);
    }
}
