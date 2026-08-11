class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length())
            return "";
        else if(s.length() == t.length() && s.equals(t))
            return s;
        int[] map = new int[128];
        for(char ch : t.toCharArray())
            map[ch]++;
        int i = 0, j = 0, minLen = Integer.MAX_VALUE, count = 0, startIndex = 0;
        while(j < s.length())
        {
            char ch = s.charAt(j);
            map[ch]--;
            if(map[ch] >= 0)
                count++;
            while(count == t.length())
            {
                if(minLen > (j - i + 1))
                {
                    minLen = j - i + 1;
                    startIndex = i;
                }
                char chTemp = s.charAt(i);
                map[chTemp]++;
                if(map[chTemp] > 0)
                    count--;
                i++;
            }
            j++;
        }
        return (minLen == Integer.MAX_VALUE)? "" : s.substring(startIndex, startIndex + minLen);
    }
}