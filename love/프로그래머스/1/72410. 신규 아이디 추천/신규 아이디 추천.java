class Solution {
    public String solution(String new_id) {
    	// Step1 : 대소문자 치환
    	new_id = new_id.toLowerCase();
    	
    	// Step2 : 사용불가 문자 제거
    	new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
    	
    	// Step3 : 마침표(.) 가 2번 이상 사용되었을 경우, 한개로 변환
    	new_id = new_id.replaceAll("\\.{2,}", ".");
    	
    	// Step4 : 처음 or 끝에 있는 마침표(.) 제거
    	if(new_id.charAt(0) == '.') new_id = new_id.substring(1);    	
    	if(new_id.length() != 0 && new_id.charAt(new_id.length()-1) == '.') new_id = new_id.substring(0, new_id.length()-1);
    	
    	// Step5 : 빈 문자열일 경우 a 추가
    	if(new_id.length() == 0) new_id = "a";
    	
    	// Step6 : 길이가 16 이상이면 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
    	//         만약 제거 후 마침표(.) 가 끝에 위치하면 끝에 위치한 마침표 제거
    	if(new_id.length() >= 16) {
    		// 6-1 : 문자열 길이 줄이기
    		new_id = new_id.substring(0, 15);
    		
    		// 6-2 : 마지막 문자열 마침표 제거
    		if(new_id.charAt(new_id.length()-1) == '.') new_id = new_id.substring(0, new_id.length()-1);
    	}
    	
    	// Step7 :  new_id의 길이가 2자 이하일 경우,
    	// 			new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다
    	while(new_id.length() <= 2) {
    		new_id += new_id.charAt(new_id.length()-1);
    	}
    

		// Result
		return new_id;
		// System.out.println(new_id);
    }
}