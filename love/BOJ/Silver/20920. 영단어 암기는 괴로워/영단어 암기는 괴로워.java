import java.io.*;
import java.util.*;


/**
 * 문제 읽기
 * 
 * - 영어단어장 만들기
 * - 자주 나오는 단어는 앞으로
 * - 단어의 길이가 길수록 앞으로
 * - 알파벳 사전순으로
 * 
 * - 길이가 M 이상인 단어들만 외울예정
 * 
 */

public class Main {
	

    public static void main(String[] args) throws IOException {
    	// init & input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
    	
    	Map<String, Integer> map = new HashMap<>();
    	
    	for(int i=0; i<N; i++) {
    		String word = br.readLine().trim();
    		
    		// 바로 암기
    		if(word.length() < M) continue;
    		
    		// 단어장에 넣기
    		map.put(word, map.getOrDefault(word, 0) + 1);
    	}
    	
    	// Map 에서 바로 key 만뽑아 List에 넣기
    	List<String> words = new ArrayList<>(map.keySet());
    	
    	// 조건에 맞게 정렬
    	words.sort((a, b) -> {
    		// 단어 등장 횟수로 비교 : 내림차순 (더 많이 나온 순서)
    		int wordCntA = map.get(a);
    		int wordCntB = map.get(b);
    		if(wordCntA != wordCntB) return wordCntB - wordCntA;
    		
    		// 길이
    		if(a.length() != b.length()) return b.length() - a.length();
    		
    		// 사전 오름차순 : compoareTo() 는 기본적으로 사전순으로 비교해줌
    		return a.compareTo(b);
    	});
    	

    	// Result : 시관초과 문제로 StirngBuilder 사용
    	StringBuilder sb = new StringBuilder();
        for (String w : words) sb.append(w).append('\n');
        System.out.print(sb.toString());
    }
}