class Solution {
    public String solution(String rsp) {
        
        char[]arr = rsp.toCharArray();
        String answer = "";
        
        for(int i = 0; i < rsp.length(); i++) {
        	if(arr[i]=='2') {
        		arr[i] ='0';
        	}
        	else if(arr[i]=='0') {
        		arr[i] ='5';
        	}
        	else {
        		arr[i]='2';
        	}
        	
        }
        answer = new String(arr);
        
        return answer;
    }
}