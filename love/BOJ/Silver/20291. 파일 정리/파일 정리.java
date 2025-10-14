import java.io.*;
import java.util.*;

/**
 * 문제 읽기
 * - 파일을 확장자 별로 정리해서 몇개 씩 있는지 알려줘
 * - 보기 편하게 확장자들을 사전 순으로 정렬해 줘
 */
public class Main {

    public static void main(String[] args) throws Exception {
    	
    	// 1. init & input
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	// 2. Simulation
    	// HashMap이 아닌 TreeMap 사용으로 확장자(key) 기준 자동정렬
    	Map<String, Integer> files = new TreeMap<>();
    	while(N-- > 0) {
    		String[] file = br.readLine().split("\\.");
    		files.put(file[1], files.getOrDefault(file[1], 0) + 1);
    	}
    	
    	// 3. Result
    	for(Map.Entry<String, Integer> e: files.entrySet()) {
    		System.out.println(e.getKey() + " " + e.getValue());
    	}
    }

}
