import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;


/**
 * 문제읽기
 * 
 * - 어떤 단어가 총 몇 번 등장하는지 세는 문제
 * - 단, 중복되어 세는 것은 빼고 해야함.
*/
import java.util.*;

public class Main {

    public static void main(String[] args){
        
    	// input
    	Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        String searchText = sc.nextLine();
        int idx = 0;
        int answer = 0;
        
        // Simulation
        while(idx+searchText.length() <= str.length()) {

        	String temp = str.substring(idx, idx+searchText.length());

        	// 동일 문자인지 비교
        	if(temp.equals(searchText)) {
        		answer++;
        		idx += searchText.length();
        	}else {
        		idx++;
        	}
        }
        
        // Result
        System.out.println(answer);
        
  
    }
}

