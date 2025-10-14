import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
    public static void main(String[] args) throws Exception{
     
    	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	   String n = br.readLine();
    	   
    	   for(int i=0; i<n.length(); i++) {
    		   char temp = n.charAt(i);
    		   
    		   if(Character.isUpperCase(temp)) System.out.print(Character.toLowerCase(temp));
    		   else System.out.print(Character.toUpperCase(temp));
    	   }
    }
}
