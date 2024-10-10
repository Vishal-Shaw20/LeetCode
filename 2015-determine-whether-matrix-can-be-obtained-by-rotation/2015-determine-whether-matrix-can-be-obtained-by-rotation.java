class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int[][] mat1 = new int[mat.length][mat[0].length];
        int[][] mat2 = new int[mat.length][mat[0].length];
        int mat1_row = 0, mat1_col = mat[0].length - 1, mat2_row = 0, mat2_col = mat[0].length - 1;
        if(Arrays.deepEquals(target,mat))
            return true;
        for(int i = 0; i < (mat.length * mat.length); i++)
            mat2[i/mat.length][i%mat.length] = 2;
        for(int i = 1; i <= 4; i++)
        {
            for(int j = 0; j < (mat.length * mat.length); j++)
            {
                if(i == 1)
                {
                    mat1[mat1_row++][mat1_col] = mat[j/mat.length][j%mat.length];
                    if(mat1_row == mat.length)
                    {
                        mat1_row = 0;
                        mat1_col--;
                    }
                }
                else if(i%2 == 0)
                {
                    mat2[mat2_row++][mat2_col] = mat1[j/mat.length][j%mat.length];
                    if(mat2_row == mat.length)
                    {
                        mat2_row = 0;
                        mat2_col--;
                    }
                }
                else
                {
                    mat1[mat1_row++][mat1_col] = mat2[j/mat.length][j%mat.length];
                    if(mat1_row == mat.length)
                    {
                        mat1_row = 0;
                        mat1_col--;
                    }
                }
            }
            if(Arrays.deepEquals(target,mat1) || Arrays.deepEquals(target,mat2))
            return true;
            mat1_col = mat[0].length - 1;
            mat2_col = mat[0].length - 1;
        }
        return false;
    }
}