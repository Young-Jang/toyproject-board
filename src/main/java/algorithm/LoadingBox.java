package algorithm;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class LoadingBox {
    public int LoadingBox(int[] order) {
        int answer = 0;
        Stack<Integer> newStack = new Stack<>();
        Stack<Integer> asisStack = new Stack<>();
        for(int i = order.length;i>0;i--){
            asisStack.push(i);
        }

        for(int i = 0 ;i<order.length;i++){
            boolean endFlag = true;
            while(!asisStack.isEmpty()&&order[i]>=asisStack.peek()){
                if(order[i]==asisStack.peek()){
                    asisStack.pop();
                    answer++;
                    endFlag = false;
                }else{
                    newStack.push(asisStack.pop());
                }
            }
            if(!newStack.isEmpty()&&order[i]==newStack.peek()){
                answer++;
                newStack.pop();
                endFlag = false;
            }
            if(endFlag)
                break;
        }
        return answer;
    }
}