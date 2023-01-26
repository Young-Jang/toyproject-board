package algorithm;
import java.util.*;

class Dictionary {
    Map<String,Integer> map;
    String[] strArr = {"A","E","I","O","U"};
    int cnt = 1;

    public void makeWord(String word){
        if(word.length()==5){
            map.put(word,cnt++);
            return;
        }
        String tempWord = "";
        for(int i = 0; i<5;i++){
            tempWord = word+strArr[i];
            map.put(tempWord,cnt++);
            makeWord(tempWord);
        }
    }

    public int dictionary(String word) {
        int answer = 0;
        map = new HashMap<>();
        makeWord("");
        map.get(word);
        return answer;
    }
}