class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        List<List<Integer>> list = new ArrayList<>();
        findCombinations(list, 0, target, new ArrayList<>(), candidates);
        return list;
    }
    public void findCombinations(List<List<Integer>> list, int ind, int target, List<Integer> tempList, int[] candidates)
    {
        if(ind == candidates.length)
        {
            if(target == 0)
                list.add(new ArrayList<>(tempList));
            return;
        }
        if(target >= candidates[ind])
        {
            tempList.add(candidates[ind]);
            findCombinations(list, ind, target - candidates[ind], tempList, candidates);
            tempList.removeLast();
        }
        if(target >= 0)
            findCombinations(list, ind + 1, target, tempList, candidates);
    }
}