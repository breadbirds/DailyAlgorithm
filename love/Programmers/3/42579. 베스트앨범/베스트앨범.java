import java.io.*;
import java.util.*;

/**
[문제읽기]
- 장르별 최대재생곡 2개씩 모아 베스트 앨범 출시 (고유번호로 return)

- 노래의 고유번호는 0번부터 시작
- 1. 많이 재생된 장르를 먼저 수록
- 2. 장르 내에서 많이 재생된 노래를 먼저 수록
- 3. 재생 횟수가 같다면 고유 번호가 낮은 노래 먼저 수록
*/

/**
우선 HashMap 을 쓰면 각 장르멸 총합은 알 수 있음.
- 즉 주어진 조건의 1번은 충족할수있다.

또다른 Hash를 만들면 거긴 String과 int[] 타입으로 하게될 경우 
HashMAp<String, int[a][b]> 이런 구조 ?

그럼 pop이란 장르에 int[a] 는 n번째 곡이라는 고유 번호를 가지고, 뒤에 int[][b] 는 그 곡의 재생 횟수 내림차순으로 정렬 !
*/
class Solution {
    
    class Song {
        int id;
        int plays;
        
        Song(int id, int plays){
            this.id = id;
            this.plays = plays;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        // 1. 장르별 재생 순서 구하기
        HashMap<String, Integer> genre = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            genre.put(genres[i], genre.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<String> genreOrder = new ArrayList<>(genre.keySet());
        genreOrder.sort((a, b) -> genre.get(b) - genre.get(a));
        
        // 2. 각 장르내 최대 재생횟수 기준 정렬하기
        Map<String, List<Song>> play = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            
            // 장르키가 없는 경우 생성
            play.putIfAbsent(genres[i], new ArrayList<>());
            
            // 장르키 기준 재생횟수 추가
            play.get(genres[i]).add(new Song(i, plays[i]));
        }
        
        // 2-1. 장르별 리스트 정렬 : key 를 기준으로 하나씩 가져온다.
        for(String key: play.keySet()){
            List<Song> list = play.get(key);
            
            // 재생횟수가 같다면 고유 번호가 낮은 순! 그게 아니라면 재생횟수가 많은 순서대로
            list.sort((a, b) ->{
               if(a.plays == b.plays) return a.id - b.id;
               return b.plays - a.plays;
            });
        }
        
        // 3. 베스트 앨범 찾기
        List<Integer> result = new ArrayList<>();
        
        for(String g: genreOrder){
            List<Song> list = play.get(g);
            
            // 1등곡
            result.add(list.get(0).id);
            
            // 2등곡도 있다면 추가
            if(list.size() > 1) result.add(list.get(1).id);
        }
        
        
        // 4. list to int[]
        int[] answer = result.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}