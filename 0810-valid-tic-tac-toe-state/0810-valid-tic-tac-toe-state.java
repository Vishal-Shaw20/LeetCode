class Solution {
   public boolean validTicTacToe(String[] board) {
        int X = 0;
        int O = 0;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(board[i].charAt(j) == 'X')
                    X++;
                else if(board[i].charAt(j) == 'O')
                    O++;
            }
        }
        if(X <= 5 && O <= 4)
        {
            if((X - O) == 1 || X == O)
                return check(board,X,O);
        }
        return false;
    }

    public static boolean check(String[] board, int X, int O)
    {
        int x = 0, o = 0;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(board[i].charAt(j) == ' ')
                    continue;
                if(haveWon(board,board[i].charAt(j),i,j))
                {
                    if(board[i].charAt(j) == 'X')
                        x++;
                    else if(board[i].charAt(j) == 'O')
                        o++;
                }
            }
        }
        if(x >= 3 && o >= 3)
            return false;
        if(x >= 3 && X == O)
            return false;
        if(o >= 3 && (X - O) == 1)
            return false;
        return true;
    }

    public static boolean haveWon(String[] board, char player, int row, int col)
    {
        if(board[row].charAt(0) == player && board[row].charAt(1) == player && board[row].charAt(2) == player)
            return true;
        if(board[0].charAt(col) == player && board[1].charAt(col) == player && board[2].charAt(col) == player)
            return true;
        if(row == col && board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player)
            return true;
        if((row + col) == (board.length - 1) && board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player)
            return true;
        return false;
    }
}