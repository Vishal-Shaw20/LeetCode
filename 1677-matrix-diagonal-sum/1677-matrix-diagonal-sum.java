class Solution {
    public int diagonalSum(int[][] mat) {
        int m = mat.length - 1, k = 0, j = 0, s = 0;
        for(int i = 0; i < (mat.length * mat.length); i++)
        {
            if(((k+j) == m) || (k == j))
            s+= mat[k][j];
            if(++j == mat.length)
            {
                k++;
                j = 0;
            }
        }
        return s;
    }
}