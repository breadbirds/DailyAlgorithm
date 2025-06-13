import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
    public static void main(String[] args) throws Exception{
     
    	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	   int n = Integer.parseInt(br.readLine());
    	   
    	   for(int i=0; i<n; i++) {
    		   
    		   // 앞에 공백
    		   for(int j=0; j<i; j++) System.out.print(" ");
    		   
    		   // 별
    		   for(int k=0; k< 2*(n-i)-1; k++) System.out.print("*");
    		   
    		   // 뒤에 공백 
    		   //for(int l=0; l<i; l++) System.out.print(" ");
    		   
    		   System.out.println("");
    	   }
    }
}
