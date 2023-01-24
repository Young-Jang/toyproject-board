package algorithm;

import java.util.*;

class Solution1 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        List<Box> boxList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            boxList.add(new Box(deliveries[i],pickups[i]));
        }
        int del = 0;
        int pick = 0;
        for(int i = n-1;i>=0;i--){
            del += boxList.get(i).getDel();
            pick += boxList.get(i).getPick();
            int cnt = 0;
            while(del > 0 || pick > 0){
                del -= cap;
                pick -= cap;
                cnt++;
            }
            answer += 2*(i+1)*cnt;
        }
        return answer;
    }
}

class Box{
    private int del;
    private int pick;
    public Box(int del, int pick){
        this.del = del;
        this.pick = pick;
    }
    public int getDel(){
        return this.del;
    }
    public void setDel(int del){
        this.del = del;
    }
    public int getPick(){
        return this.pick;
    }
    public void setPick(int pick){
        this.pick = pick;
    }
}