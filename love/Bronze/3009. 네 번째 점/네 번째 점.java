import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x1 = 0, y1 = 0;
        int x2 = 0, y2 = 0;
        int x3 = 0, y3 = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        x3 = Integer.parseInt(st.nextToken());
        y3 = Integer.parseInt(st.nextToken());

        int x4, y4;

        // x 좌표 결정
        if (x1 == x2)       x4 = x3;
        else if (x1 == x3)  x4 = x2;
        else                x4 = x1;

        // y 좌표 결정
        if (y1 == y2)       y4 = y3;
        else if (y1 == y3)  y4 = y2;
        else                y4 = y1;

        System.out.println(x4 + " " + y4);
    }
}
