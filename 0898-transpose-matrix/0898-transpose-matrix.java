class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] trans = new int[matrix[0].length][matrix.length];
        int k = 0, j = 0;
        for(int i = 0; i < (trans.length * trans[0].length); i++)
        {
            trans[j][k] = matrix[k][j];
            if(++j == matrix[0].length)
            {
                k++;
                j = 0;
            }
        }
        return trans;
    }
}