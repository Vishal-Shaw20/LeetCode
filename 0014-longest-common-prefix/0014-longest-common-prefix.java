class Solution {
    public String longestCommonPrefix(String[] strs) 
    {
        int low = 1, high = Integer.MAX_VALUE;
        for(String word : strs)
            high = (high < word.length())? high : word.length();
        outer:
        while(low <= high)
        {
            int mid = low + ((high - low) >> 1);
            String str = strs[0].substring(0,mid);
            int count = 0;
            for(int i = 1; i < strs.length; i++)
            {
                if(!strs[i].startsWith(str))
                {
                    high = mid - 1;
                    continue outer;
                }
            }
            low = mid + 1;
        }
        if(high == 0)
            return "";
        return strs[0].substring(0,high);
    }
}