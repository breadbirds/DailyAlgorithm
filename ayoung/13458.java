import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        int[] people = new int[N];

        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());

        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Long answer = 0L;

        for (int i = 0; i < N; i++) {
            answer += 1;
            if(people[i] > B) {
                int tmp = people[i] - B;
                answer += tmp/C;
                if(tmp%C != 0) {
                    answer += 1;
                }
            }
        }
        
        System.out.println(answer);
    }
}
