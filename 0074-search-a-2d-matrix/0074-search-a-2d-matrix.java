class Solution {
    public boolean searchMatrix(int[][] matrix, int target)
    {
        int low = 0, high = (matrix.length * matrix[0].length) - 1;
        while(low <= high)
        {
            int mid = low + ((high - low) >> 1);
            int mid1 = mid / matrix[0].length;
            int mid2 = mid % matrix[0].length;
            if(target == matrix[mid1][mid2])
                return true;
            else if(target < matrix[mid1][mid2])
                high = mid - 1;
            else 
                low = mid + 1;
        }
        return false;
    }
}