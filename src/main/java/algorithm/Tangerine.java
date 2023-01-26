package algorithm;//1
import java.util.*;

class Tangerine {
    public int Tangerine(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer,Integer> map =new HashMap<>();

        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2)-map.get(o1));

        for(Integer key:list){
            k -=map.get(key);
            answer++;
            if(k<=0){
                break;
            }
        }

        return answer;
    }
}
//
////2
//import java.util.*;
//
//class Solution {
//    public int solution(int k, int[] tangerine) {
//        int answer = 0;
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//        Arrays.sort(tangerine);
//        int firstNum = tangerine[0];
//        int cnt = 1;
//        for(int i = 1 ;i < tangerine.length;i++){
//            if(tangerine[i]!=tangerine[i-1]){
//                pq.add(cnt);
//                cnt = 1;
//            }else{
//                cnt++;
//            }
//        }
//        pq.add(cnt);
//
//        int totalCnt = 0;
//        while(totalCnt<k){
//            totalCnt += pq.poll();
//            answer++;
//        }
//        return answer;
//    }
//}