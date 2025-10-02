class Solution {
    public void setZeroes(int[][] matrix) 
    {
        boolean r_flag = false, c_flag = false;
        for(int i = 0; i < matrix.length; i++)
        {
            if(matrix[i][0] == 0)
            {
                c_flag = true;
                break;
            }
        }
        for(int j = 0; j < matrix[0].length; j++)
        {
            if(matrix[0][j] == 0)
            {
                r_flag = true;
                break;
            }
        }
        for(int i = 1; i < matrix.length; i++)
        {
            for(int j = 1; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
            }
        }
        for(int i = 1; i < matrix.length; i++)
        {
            for(int j = 1; j < matrix[0].length; j++)
            {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        if(c_flag)
        {
            for(int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }
        if(r_flag)
        {
            for(int j = 0; j < matrix[0].length; j++)
                matrix[0][j] = 0;
        }
    }
}