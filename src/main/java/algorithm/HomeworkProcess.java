package algorithm;
import java.util.*;


public class HomeworkProcess {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        List<Homework> list = new ArrayList<>();
        List<Homework> stopList = new ArrayList<>();
        for(int i = 0;i<plans.length;i++){
            list.add(new Homework(plans[i][0],
                    Integer.parseInt(plans[i][1].replaceAll(":",""))
                    ,Integer.parseInt(plans[i][2])));
        }
        Collections.sort(list);
        //System.out.println(list);
        int idx = 0;
        Homework nowh = list.get(0);
        for(int i = nowh.getStart(); i<1000000;i++){
            // System.out.println(nowh.getName()+nowh.getPlay());
            while(stopList.size()>0){
                if(stopList.get(stopList.size()-1).getPlay()==0)
                    stopList.remove(stopList.size()-1);
                else
                    break;
            }
            if(nowh.getPlay()==0){
                answer.add(nowh.getName());
                if(stopList.size()>0){
                    nowh = stopList.get(stopList.size()-1);
                    stopList.remove(stopList.size()-1);
                }
            }

            if(idx<plans.length-1 && list.get(idx+1).getStart() == i){
                if(nowh.getPlay() > 0)
                    stopList.add(nowh);
                nowh = list.get(++idx);
            }

            if(idx == plans.length-1 && nowh.getPlay() == 0){
                if(stopList.size()>0){
                    nowh = stopList.get(stopList.size()-1);
                    stopList.remove(stopList.size()-1);
                }
                else
                    break;
            }

            nowh.setPlay(nowh.getPlay()-1);
            if(i%100 == 59){
                i+=40;
            }
        }

        return answer.toArray(new String[0]);
    }

    public class Homework implements Comparable<Homework>{
        private String name;
        private int start;
        private int play;

        public Homework(String n, int s, int p){
            this.name = n;
            this.start = s;
            this.play = p;
        }

        public int getStart(){
            return this.start;
        }

        public String getName(){
            return this.name;
        }

        public int getPlay(){
            return this.play;
        }

        public void setPlay(int play){
            this.play = play;
        }

        @Override
        public int compareTo(Homework h){
            if(h.getStart() < this.start){
                return 1;
            }else if(h.getStart() > this.start){
                return -1;
            }
            return 0;
        }

        @Override
        public String toString(){
            return "["+this.start+"]";
        }
    }
}
