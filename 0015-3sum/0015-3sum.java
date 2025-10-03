class Solution {
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0, j, k;
        while(i < (nums.length - 2))
        {
            j = i + 1;
            k = nums.length - 1;
            while(j < k)
            {
                if(nums[i] + nums[j] + nums[k] == 0)
                {
                    list.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j = differentJ(nums,j,k);
                    k = differentK(nums,k,j);
                }
                else if(nums[i] + nums[j] + nums[k] > 0)
                {
                    k = differentK(nums,k,j);
                }
                else
                {
                    j = differentJ(nums,j,k);
                }
            }
            while(i < (nums.length - 2))
            {
                i++;
                if(nums[i] != nums[i - 1])
                    break;
            }
        }
        return list;
    }
    public int differentJ(int[] nums, int j, int k)
    {
        while((j < k) && nums[j] == nums[j + 1])
            j++;
        return (j + 1);
    }
    public int differentK(int[] nums, int k, int j)
    {
        while((j < k) && nums[k] == nums[k - 1])
            k--;
        return (k - 1);
    }
}