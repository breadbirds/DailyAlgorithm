import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	static StringBuffer sb = new StringBuffer();
	
	static int NODE;
	static int LINE;
	static int START;
	
	static int arr[][];
	static boolean[] check;
	
    public static void main(String[] args) throws Exception{
     
    	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	   StringTokenizer st = new StringTokenizer(br.readLine());
    	   
    	   // 초기화 
    	   NODE = Integer.parseInt(st.nextToken());
    	   LINE = Integer.parseInt(st.nextToken());
    	   START = Integer.parseInt(st.nextToken());
    	   arr = new int[NODE+1][NODE+1];
    	   check = new boolean[NODE+1];
    	   
    	   // input
    	   for(int i=0; i<LINE; i++) {
    		   st = new StringTokenizer(br.readLine());
    		   
    		   int a = Integer.parseInt(st.nextToken());
    		   int b = Integer.parseInt(st.nextToken());
    		   arr[a][b] = arr[b][a] = 1;
    	   }
    	   
    	   // DFS
    	   dfs(START);
    	   sb.append("\n");
    	   
    	   // BFS 
    	   check = new boolean[NODE+1];
    	   bfs(START);

   			// Result
   			System.out.println(sb);
    	   
    }

	private static void dfs(int start) {
		sb.append(start + " ");
		check[start] = true;
		
		// 재귀
		for(int i=1; i<=NODE; i++) {
			if(arr[start][i] == 1 && !check[i]) {
				check[i] = true;
				dfs(i);
			}
		}
	}
	
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(start);
		check[start] = true;
		
		while(!q.isEmpty()) {
			start = q.poll();
			sb.append(start + " ");
			
			for(int i=1; i<=NODE; i++) {
				if(arr[start][i] == 1 && !check[i]) {
					q.add(i);
					check[i] = true;
				}
				
			}
		}
		
	}
}
