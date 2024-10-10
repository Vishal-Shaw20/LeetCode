class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int max, min;
        for(int i = 0; i < (matrix.length * matrix[0].length); i++)
        {
            max = min = matrix[i/matrix[0].length][i%matrix[0].length];
            for(int j = 0; j < matrix.length; j++)
            {
                if(max < matrix[j][i%matrix[0].length])
                    max = matrix[j][i%matrix[0].length];
            }
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(min > matrix[i/matrix[0].length][j])
                    min = matrix[i/matrix[0].length][j];
            }
            if((max == matrix[i/matrix[0].length][i%matrix[0].length]) && (min == matrix[i/matrix[0].length][i%matrix[0].length]))
                list.add(matrix[i/matrix[0].length][i%matrix[0].length]);
        }
        return list;
    }
}