package algorithm;
import java.util.*;

public class HotelReservation {
    int rcnt = 0;

    public int solution(String[][] book_time) {
        int answer = 0;
        int [][] timeArray = new int[book_time.length][2];
        int []room = new int[1000];
        for(int i =0;i<book_time.length;i++){
            timeArray[i][0] = getMinute(book_time[i][0]);
            timeArray[i][1] = getMinute(book_time[i][1]);
            room[i] = 0;
        }
        Arrays.sort(timeArray, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1,int[] o2){
                return o1[0]-o2[0];
            }
        });

        int idx = 0;
        for(int i =timeArray[0][0];i<1440;i++){
            if(idx==timeArray.length)
                break;
            while(idx<timeArray.length && timeArray[idx][0] == i){
                int rnum = checkRoom(room);
                room[rnum] = timeArray[idx][1] - timeArray[idx][0] + 10;
                idx++;
            }
            for(int j = 0;j<rcnt+1;j++){
                if(room[j]>0)
                    room[j]--;
            }
        }
        return rcnt+1;
    }

    private int getMinute(String time){
        String[] s = time.split(":");
        return Integer.parseInt(s[0])*60 + Integer.parseInt(s[1]);
    }

    private int checkRoom(int[] r){
        for(int i = 0;i<r.length;i++){
            if(r[i]==0){
                if(rcnt<i)
                    rcnt = i;
                return i;
            }
        }
        return r.length;
    }
}
