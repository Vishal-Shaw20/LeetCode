class Solution {
    public void solveSudoku(char[][] board) {
        boolean c = solve(board);
    }
    public static boolean solve(char[][] board)
    {
        boolean emptyLeft = true;
        int r = -1, c = -1;
        outer:
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                if(board[i][j] == '.')
                {
                    r = i;
                    c = j;
                    emptyLeft = false;
                    break outer;
                }
            }
        }
        if(emptyLeft)
            return true;
        for(int num = 1; num <= 9; num++)
        {
            if(isSafe(board,r,c,num))
            {
                board[r][c] = (char)('0' + num);
                if(solve(board))
                    return true;
                else
                    board[r][c] = '.';
            }
        }
        return false;
    }
    public static boolean isSafe(char[][] board, int r, int c, int num)
    {
        for(int i = 0; i < 9; i++)
        {
            if((board[r][i]) == (char)('0' + num))
                return false;
        }
        for(int i = 0; i < 9; i++)
        {
            if(board[i][c] == (char)('0' + num))
                return false;
        }
        int rowStart = r - (r % 3);
        int colStart = c - (c % 3);
        for(int i = rowStart; i < (rowStart + 3); i++)
        {
            for(int j = colStart; j < (colStart + 3); j++)
            {
                if(board[i][j] == (char)('0' + num))
                    return false;
            }
        }
        return true;
    }
}