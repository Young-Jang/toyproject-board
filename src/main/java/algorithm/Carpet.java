package algorithm;

class Carpet {
    public int[] Carpet(int brown, int yellow) {
        int[] answer = new int[2];
        for(int height = 3; height<brown/2; height++) {
            for(int width = height; width < brown/2; width++){
                if(brown/2 == width + height - 2 && yellow == (width-2)*(height-2)){
                    answer[0]=width;
                    answer[1]=height;
                    height = brown;
                    break;
                }
            }
        }
        return answer;
    }
}

//brown = 2a + 2b + 4, yellow = a * b,