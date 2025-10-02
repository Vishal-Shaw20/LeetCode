class Solution {
    public void rotate(int[][] matrix) 
    {
        for(int i = 1; i < matrix.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i < matrix.length; i++)
        {
            int k = matrix[0].length - 1;
            for(int j = 0; j < (matrix[0].length/2); j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k--] = temp;
            }
        }        
    }
}