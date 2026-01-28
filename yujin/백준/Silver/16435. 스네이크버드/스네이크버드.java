import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int L = sc.nextInt();
		int fruit[] = new int [N];
		
		for(int i = 0; i < N; i++) {
			fruit[i] = sc.nextInt();
		}
		
	    Arrays.sort(fruit);
//	    System.out.print(Arrays.toString(fruit));
		
		for(int i = 0; i < N; i++) {
			if(fruit[i] <= L) {
				L += 1;
			}

		}
		System.out.print(L);

	}

}