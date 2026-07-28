class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length; 
        int cols = board[0].length;
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(board[i][j] == word.charAt(0) && find(board, word, i, j, 0, rows, cols))
                    return true;
            }
        }
        return false;
    }
    public boolean find(char[][] board, String word, int i, int j, int index, int rows, int cols)
    {
        if(index == word.length())
            return true;
        if(i < 0 || j < 0 || i >= rows || j >= cols || board[i][j] != word.charAt(index))
            return false;
        char temp = board[i][j];
        board[i][j] = '*';
        boolean found = find(board, word, i, j + 1, index + 1, rows, cols) ||
                        find(board, word, i, j - 1, index + 1, rows, cols) ||
                        find(board, word, i - 1, j, index + 1, rows, cols) ||
                        find(board, word, i + 1, j, index + 1, rows, cols);
        board[i][j] = temp;
        return found;
    }
}