package algorithm;

public class tictacto {
    public int solution(String[] board) {
        int answer = -1;
        if(checkCnt(board) && checkXwinCase(board) && checkOwinCase(board))
            answer = 1;
        else
            answer = 0;
        return answer;
    }

    private boolean checkCnt(String[] board){
        int Ocnt = getOcnt(board);
        int Xcnt = getXcnt(board);
        if(Ocnt == Xcnt || Ocnt-1 == Xcnt){
            return true;
        }
        return false;
    }
    private int getOcnt(String[] board){
        int Ocnt = 0;
        for(int i = 0;i<3;i++){
            Ocnt += board[i].chars()
                    .filter(c -> c == 'O')
                    .count();
        }
        return Ocnt;
    }

    private int getXcnt(String[] board){
        int Xcnt = 0;
        for(int i = 0;i<3;i++){
            Xcnt += board[i].chars()
                    .filter(c -> c == 'X')
                    .count();
        }
        return Xcnt;
    }

    //X가 이겼는데 O가 하나 더 놓은 경우
    private boolean checkXwinCase(String[] board){
        boolean xWin = false;
        for(int i = 0; i<3; i++){
            if(board[i].equals("XXX")){
                xWin = true;
            }else if(board[0].charAt(i)== 'X' &&board[1].charAt(i)== 'X' &&board[2].charAt(i)== 'X'){
                xWin = true;
            }
        }
        if(board[0].charAt(0)== 'X' &&board[1].charAt(1)== 'X' &&board[2].charAt(2)== 'X')
            xWin = true;
        if(board[2].charAt(0)== 'X' &&board[1].charAt(1)== 'X' &&board[0].charAt(2)== 'X')
            xWin = true;
        if(xWin){
            if(getOcnt(board) > getXcnt(board))
                return false;
            else
                return true;
        }else{
            return true;
        }
    }

    private boolean checkOwinCase(String[] board){
        boolean oWin = false;
        for(int i = 0; i<3; i++){
            if(board[i].equals("OOO")){
                oWin = true;
            }else if(board[0].charAt(i)== 'O' &&board[1].charAt(i)== 'O' &&board[2].charAt(i)== 'O'){
                oWin = true;
            }
        }
        if(board[0].charAt(0)== 'O' &&board[1].charAt(1)== 'O' &&board[2].charAt(2)== 'O')
            oWin = true;
        if(board[2].charAt(0)== 'O' &&board[1].charAt(1)== 'O' &&board[0].charAt(2)== 'O')
            oWin = true;
        if(oWin){
            if(getOcnt(board) == getXcnt(board))
                return false;
            else
                return true;
        }else{
            return true;
        }
    }
}
