package algorithm;

import java.util.*;

//오답: bfs 문제로 착
//class Solution4 {
//    boolean []check;
//    Map<Integer,List<Integer>> map;
//    Queue<RegionInfo> q;
//
//    public int bfs(int start,int destination){
//        if(start==destination)
//            return 0;
//        q.add(new RegionInfo(start,0));
//        while(!q.isEmpty()){
//            RegionInfo regionInfo = q.poll();
//            int region = regionInfo.getRegion();
//            if(map.containsKey(region)){
//                check[region] = true;
//                for(Integer i : map.get(region)){
//                    if(i==destination){
//                        return regionInfo.getCnt()+1;
//                    }
//                    if(!check[i]){
//                        q.add(new RegionInfo(i,regionInfo.getCnt()+1));
//                    }
//                }
//            }
//        }
//        return -1;
//    }
//
//    public void initCheck(int sz){
//        for(int i = 0;i<=sz;i++){
//            check[i]=false;
//        }
//    }
//
//    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
//        int[] answer = new int[sources.length];
//        map = new HashMap<>();
//        q = new LinkedList<>();
//        check = new boolean[100001];
//        for(int i = 0;i<roads.length;i++){
//            check[i]=false;
//            if(map.containsKey(roads[i][0])){
//                if(map.containsKey(roads[i][1])){
//                    map.get(roads[i][0]).add(roads[i][1]);
//                    map.get(roads[i][1]).add(roads[i][0]);
//                }else{
//                    map.get(roads[i][0]).add(roads[i][1]);
//                    map.put(roads[i][1],new ArrayList<>(List.of(roads[i][0])));
//                }
//            }else{
//                if(map.containsKey(roads[i][1])){
//                    map.put(roads[i][0],new ArrayList<>(List.of(roads[i][1])));
//                    map.get(roads[i][1]).add(roads[i][0]);
//                }else{
//                    map.put(roads[i][0],new ArrayList<>(List.of(roads[i][1])));
//                    map.put(roads[i][1],new ArrayList<>(List.of(roads[i][0])));
//                }
//            }
//        }
//        for(int i = 0 ;i<sources.length;i++){
//            answer[i] = bfs(sources[i],destination);
//            q.clear();
//            initCheck(roads.length);
//        }
//        return answer;
//    }
//}
//
//class RegionInfo{
//    private int region;
//    private int cnt;
//
//    public RegionInfo(int r, int c){
//        this.region = r;
//        this.cnt = c;
//    }
//
//    public int getRegion() {
//        return region;
//    }
//
//    public void setRegion(int region) {
//        this.region = region;
//    }
//
//    public int getCnt() {
//        return cnt;
//    }
//
//    public void setCnt(int cnt) {
//        this.cnt = cnt;
//    }
//}
import java.util.*;

//다익스트라 올바른 풀이
class Solution4 {
    List<List<Integer>> graph;
    Queue<Integer> q;
    int []minDis;
    private static int MAX_VAL = 999999999;


    public void dijkstra(int destination){
        minDis[destination] = 0;
        q = new LinkedList<>();
        q.add(destination);
        while(!q.isEmpty()){
            int currentDes = q.poll();
            for(int nextDes:graph.get(currentDes)){
                if(minDis[nextDes] > minDis[currentDes]+1){
                    minDis[nextDes] = minDis[currentDes]+1;
                    q.add(nextDes);
                }
            }
        }
    }

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        minDis = new int[n+1];
        graph = new ArrayList<>();
        for(int i = 0;i < n+1;i++){
            minDis[i] = MAX_VAL;
            graph.add(new ArrayList<>());
        }
        for(int i = 0;i<roads.length;i++){
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }
        dijkstra(destination);
        for(int i = 0 ;i<sources.length;i++){
            if(minDis[sources[i]] == MAX_VAL)
                answer[i] = -1;
            else
                answer[i] = minDis[sources[i]];
        }
        return answer;
    }
}