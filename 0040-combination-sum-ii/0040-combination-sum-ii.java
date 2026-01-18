class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations2(list, 0, target, new ArrayList<>(), candidates);
        return list;
    }
    public void findCombinations2(List<List<Integer>> list, int ind, int target, List<Integer> tempList, int[] candidates)
    {
        if(target == 0)
        {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = ind; i < candidates.length; i++)
        {
            if(i > ind && candidates[i] == candidates[i - 1])
                continue;
            if(candidates[i] > target)
                break;
            tempList.add(candidates[i]);
            findCombinations2(list, i + 1, target - candidates[i], tempList, candidates);
            tempList.removeLast();
        }
    }
}