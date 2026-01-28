import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		int i = sc.nextInt();
//		char[]c = new char[s.length()];
//		
//		for(int j = 0; j < s.length(); j++) {
//			c[j] = s.charAt(j);
//			if(j == i - 1) {
//				System.out.println(c[j]);
//			}
//		}
		char c = s.charAt(i - 1);
		System.out.println(c);
		
		
		
		

	}
}