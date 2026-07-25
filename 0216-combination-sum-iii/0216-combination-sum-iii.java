class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(1,list, new ArrayList<>(), k, n);
        return list;
    }
    public void backtrack(int i, List<List<Integer>> list, List<Integer> ds, int k, int n)
    {
        if(k == 0)
        {
            if(n == 0)
                list.add(new ArrayList<>(ds));
            return;
        }
        if(i > 9)
            return;
        if(i <= n)
        {
            ds.add(i);
            backtrack(i + 1, list, ds, k - 1, n - i);
            ds.removeLast();
            backtrack(i + 1, list, ds, k, n);
        }
        else
            return;
    }
}