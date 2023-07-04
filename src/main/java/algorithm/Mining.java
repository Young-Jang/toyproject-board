package algorithm;
import java.util.*;

public class Mining {
    int tiredMin = 1111111;
    int [][]m = {{1,1,1},{5,1,1},{25,5,1}};
    Map<String,Integer> map;

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        map = new HashMap<>();
        map.put("diamond",0);
        map.put("iron",1);
        map.put("stone",2);
        dfs(picks,minerals,0,0);

        return tiredMin;
    }

    private void dfs(int[] picks, String[] minerals, int mineIdx, int tired){
        if(tired>tiredMin)
            return;
        if(mineIdx == minerals.length || isPicksEmpty(picks)){
            if(tired<tiredMin)
                tiredMin = tired;
        }
        int plusTired = 0;

        for(int i = 0 ; i<3;i++){
            if(picks[i]>0){
                picks[i]--;
                for(int j = 0 ;j<5;j++){
                    if(mineIdx>minerals.length-1)
                        break;
                    plusTired += m[i][map.get(minerals[mineIdx++])];
                }
                dfs(picks,minerals,mineIdx,tired+plusTired);
                picks[i]++;
                mineIdx -= 5;
                plusTired = 0;
            }
        }
    }

    private boolean isPicksEmpty(int[] picks){
        for(int i =0;i<picks.length;i++){
            if(picks[i]>0)
                return false;
        }
        return true;
    }
}
