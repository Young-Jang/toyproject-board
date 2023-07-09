package algorithm;

public class escapeMiro {
    int []dx = {0,1,0,-1};
    int []dy = {-1,0,1,0};
    char [][]map;
    int [][]check;
    Queue<Pos> q;
    int w;
    int h;
    int MAX = 1111111;

    public int solution(String[] maps) {
        int answer = 0;
        h = maps.length;
        w = maps[0].length();
        map = new char[h][w];
        check = new int[h][w];
        q = new LinkedList<>();
        int sx=0;
        int sy=0;
        int ex=0;
        int ey=0;
        int lx=0;
        int ly=0;
        for(int i = 0;i<h;i++){
            for(int j = 0;j<w;j++){
                map[i][j] = maps[i].charAt(j);
                check[i][j] = 0;
                if(map[i][j]=='S'){
                    sx = j;
                    sy = i;
                }else if(map[i][j]=='E'){
                    ex = j;
                    ey = i;
                }else if(map[i][j]=='L'){
                    lx = j;
                    ly = i;
                }
            }
        }
        int lcnt = bfs(sx,sy,lx,ly);
        if(lcnt == MAX)
            return -1;
        int ecnt = bfs(lx,ly,ex,ey);
        if(ecnt == MAX)
            return -1;
        return lcnt + ecnt;
    }

    private int bfs(int sx, int sy, int tx, int ty){
        int mins = MAX;
        q.add(new Pos(sx,sy,0));
        check[sy][sx] = 1;
        while(!q.isEmpty()){
            Pos p = q.poll();
            int x = p.getX();
            int y = p.getY();
            int cnt = p.getCnt();
            if(x==tx && y==ty && cnt < mins)
                mins = cnt;
            if(mins<cnt)
                continue;
            for(int i = 0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0&&ny>=0&&nx<w&&ny<h&&map[ny][nx]!='X'&&check[ny][nx]!=1){
                    q.add(new Pos(nx,ny,cnt+1));
                    check[ny][nx] = 1;
                }
            }
        }
        for(int i = 0;i<h;i++){
            for(int j = 0;j<w;j++){
                check[i][j] = 0;
            }
        }
        return mins;
    }

    public class Pos{
        int x;
        int y;
        int cnt;

        public Pos(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        public int getX(){
            return this.x;
        }

        public int getY(){
            return this.y;
        }

        public int getCnt(){
            return this.cnt;
        }
    }

}
