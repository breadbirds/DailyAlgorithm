import java.io.*;
import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
    	Map<String, Integer> map = new HashMap<>() {
    		{
    			put("code", 0);
    			put("date", 1);
    			put("maximum", 2);
    			put("remain", 3);
    		}
    	};
    	
    	
    	// 조건 ext + val_ext 기준으로 1차 정비
    	List<int[]> list = new ArrayList<>();
    	for(int i=0; i<data.length; i++) {
    		int[] cur = data[i];
    		
    		if(cur[map.get(ext)] < val_ext ) {
    			list.add(cur);
    		}
    	}
    	
    	
    	int keyIdx = map.get(sort_by);
    	list.sort(Comparator.comparingInt(a -> a[keyIdx])); // 오름차순
    	
    	// int[][]로 변환
    	int[][] answer = list.toArray(new int[list.size()][]);
    
		// Result
		return answer;
    }

    
}