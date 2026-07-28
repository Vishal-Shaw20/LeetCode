class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[(2 * n) - 1];
        boolean[] diag2 = new boolean[(2 * n) - 1];
        backtrack(list, n, 0, new ArrayList<>(), cols, diag1, diag2);
        return list;
    }
    public void backtrack(List<List<String>> list, int n, int i, List<String> ds, boolean[] cols, boolean[] diag1, boolean[] diag2)
    {
        if(i == n)
        {
            list.add(new ArrayList<>(ds));
            return;
        }
        String temp = "";
        for(int j = 0; j < n; j++)
        {
            if(canPlace(i,j,n,cols,diag1,diag2))
            {
                cols[j] = true;
                diag1[i - j + n - 1] = true;
                diag2[i + j] = true;
                temp += "Q";
                for(int k = j + 1; k < n; k++)
                    temp += ".";
                ds.add(temp);
                backtrack(list, n, i + 1, ds, cols, diag1, diag2);
                ds.remove(ds.size() - 1);
                temp = temp.substring(0,j);
                temp += ".";
                cols[j] = false;
                diag1[i - j + n - 1] = false;
                diag2[i + j] = false;
            }
            else
                temp += ".";
        }
    }
    public boolean canPlace(int i, int j, int n, boolean[] cols, boolean[] diag1, boolean[] diag2)
    {
        return !cols[j] && !diag1[i - j + n - 1] && !diag2[i + j];
    }
}