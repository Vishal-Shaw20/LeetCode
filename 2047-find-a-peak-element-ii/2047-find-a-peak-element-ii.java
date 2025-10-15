class Solution {
    public int[] findPeakGrid(int[][] mat) 
    {
        int low = 0, high = mat[0].length;
        while(low <= high)
        {
            int mid = low + ((high - low) >> 2);
            int max = mat[0][mid], maxRow = 0;
            for(int i = 1; i < mat.length; i++)
            {
                max = (max > mat[i][mid]) ? max : mat[i][mid];
                maxRow = (max > mat[i][mid]) ? maxRow : i;
            }
            int left = (mid == 0)? -1 : mat[maxRow][mid - 1];
            int right = (mid == (mat[0].length - 1))? -1 : mat[maxRow][mid + 1];
            if(mat[maxRow][mid] > left && mat[maxRow][mid] > right)
                return new int[]{maxRow,mid};
            else if(mat[maxRow][mid] < left)
                high = mid - 1;
            else 
                low = mid + 1;
        }
        return new int[]{-1,-1};
    }
}