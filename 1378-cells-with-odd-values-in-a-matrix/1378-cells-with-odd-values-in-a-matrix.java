class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        int count = 0, a = 0;
        for(int i = 0; i < (indices.length * 2); i++)
        {
            if(i%2 == 0)
            {
                for(int j = 0; j < n; j++)
                {
                    matrix[indices[a][0]][j]++;
                    if(matrix[indices[a][0]][j]%2 != 0)
                        count++;
                    else
                        count--;
                }
            }
            else
            {
                for(int j = 0; j < m; j++)
                {
                    matrix[j][indices[a][1]]++;
                    if(matrix[j][indices[a][1]]%2 != 0)
                        count++;
                    else
                        count--;
                }
                a++;
            }
        }
        return count;
    }
}