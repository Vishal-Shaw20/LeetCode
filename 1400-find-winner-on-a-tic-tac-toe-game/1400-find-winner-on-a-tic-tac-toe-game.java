class Solution {
    public String tictactoe(int[][] moves) {
        char[][] game = new char[3][3];
        for(int i = 0; i < game.length; i++)
        {
            for(int j = 0; j < game[0].length; j++)
                game[i][j] = ' ';
        }
        char player = 'X';
        int count = 0;
        for(int i = 0; i < moves.length; i++)
        {
            int row = moves[i][0];
            int col = moves[i][1];
            game[row][col] = player;
            count++;
            if(haveWon(game,player,row,col))
            {
                if(player == 'X')
                    return "A";
                else
                    return "B";
            }
            player = (player == 'X')? 'O' : 'X';
        }
        return ((count == 9)? "Draw" : "Pending");
    }

    public static boolean haveWon(char[][] game, char player, int row, int col)
    {
        boolean T1 = true;
        if(game[row][0] == player && game[row][1] == player && game[row][2] == player)
            return true;
        if(game[0][col] == player && game[1][col] == player && game[2][col] == player)
            return true;
        if(row == col && game[0][0] == player && game[1][1] == player && game[2][2] == player)
            return true;
        if((row + col) == (game.length - 1) && game[0][2] == player && game[1][1] == player && game[2][0] == player)
            return true;
        return false;
    }
}