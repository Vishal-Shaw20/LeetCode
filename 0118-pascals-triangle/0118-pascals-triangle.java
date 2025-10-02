class Solution {
    public List<List<Integer>> generate(int numRows) 
    {
        List<List<Integer>> list = new ArrayList<>();
        int res;
        for(int i = 0; i < numRows; i++)
        {
            list.add(new ArrayList<>(Arrays.asList(1)));
            res = 1;
            for(int j = 1; j <= i; j++)
            {
                res = list.get(i).get(j - 1) * (i + 1 - j);
                list.get(i).add(res / j);
            }
        }
        return list;       
    }
}