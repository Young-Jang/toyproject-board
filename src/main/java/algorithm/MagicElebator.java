package algorithm;

class Solution3 {
    public int solution(int storey) {
        int answer = 0;
        int nextPlus = 0;
        int[] numArr = new int[10];
        int idx = 0;
        while(storey>0){
            numArr[idx++] = storey % 10;
            storey = storey/10;
        }

        for(int i = 0; i < idx; i++){
            int nextNum = numArr[i] + nextPlus;
            if(nextNum == 10){
                nextPlus = 1;
            }else if(i<idx-1 && nextNum==5){
                if(numArr[i+1]>=5){
                    answer = answer + nextNum;
                    nextPlus = 1;
                }else {
                    answer = answer + nextNum;
                    nextPlus =0;
                }
            }else if(nextNum>5){
                answer = answer + 10 - nextNum;
                nextPlus = 1;
            }else{
                answer = answer + nextNum;
                nextPlus =0;
            }
        }
        return answer+nextPlus;
    }
}