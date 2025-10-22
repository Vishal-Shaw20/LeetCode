class Solution {
    public int strStr(String haystack, String needle) 
    {
        if(haystack.length() < needle.length() || haystack.isEmpty() || needle.isEmpty())
            return -1;
        int a = haystack.length(), b = needle.length();
        for(int i = 0; i <= (a - b); i++)
        {
            if(haystack.substring(i, i + b).equals(needle))
                return i;
        }
        return -1;
    }
}