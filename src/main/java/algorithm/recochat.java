package algorithm;

public class recochat {
    char [][]map;
    int [][]check;
    int []dx = {0,1,0,-1};
    int []dy = {-1,0,1,0};
    int w;
    int h;
    int startX;
    int startY;
    int targetX;
    int targetY;
    int mins = 11111111;

    public int solution(String[] board) {
        int answer = 0;
        h= board.length;
        w= board[0].length();
        check = new int[board.length][board[0].length()];
        map = new char[board.length][board[0].length()];
        for(int i = 0;i<board.length;i++){
            for(int j = 0 ; j<board[i].length();j++){
                map[i][j] = board[i].charAt(j);
                if(map[i][j]=='R'){
                    startX = j;
                    startY = i;
                }else if(map[i][j]=='G'){
                    targetX = j;
                    targetY = i;
                }
                check[i][j]=1111111;
            }
        }
        dfs(startX,startY,0);
        if(mins == 11111111)
            return -1;
        else
            return mins;
    }

    private void dfs(int x, int y, int cnt){
        //System.out.println("x:" + x + ", y:" + y +", cnt:"+cnt);
        if(targetX == x && targetY == y){
            if(mins > cnt)
                mins = cnt;
            return;
        }
        if(check[y][x]<=cnt)
            return;
        check[y][x] = cnt;


        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0&&ny>=0&&nx<w&&ny<h&&map[ny][nx]!='D'){
                while(true){
                    nx += dx[i];
                    ny += dy[i];
                    if(nx<0||ny<0||nx>w-1||ny>h-1||map[ny][nx]=='D'){
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                }
                dfs(nx,ny,cnt+1);
            }
        }
    }
}
