class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int i = 0, j = 0, maxLen = 0, strLen = s.length();
        while(j < strLen)
        {
            char ch = s.charAt(j);
            if(map[ch] != -1 && map[ch] >= i)
                i = map[ch] + 1;
            map[ch] = j;
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        return maxLen;
    }
}