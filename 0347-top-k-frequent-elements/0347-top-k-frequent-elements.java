class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List[] list = new List[nums.length + 1];
        int[] ans = new int[k];
        int filled = 0;
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            int key = entry.getKey();
            int value = entry.getValue();
            if(list[value] == null)
                list[value] = new ArrayList<>();
            list[value].add(key);
        }
        for(int i = list.length - 1; i >= 0 && filled < k; i--)
        {
            if(list[i] == null)
                continue;
            for(int j = 0; j < list[i].size(); j++)
            {
                ans[filled++] = (int)list[i].get(j);
                if(filled == k)
                    return ans;
            }
        }
        return ans;
    }
}