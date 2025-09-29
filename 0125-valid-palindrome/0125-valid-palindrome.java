class Solution {
    public static boolean isPalindrome(String s)
    {
        s = s.toLowerCase().replaceAll("[^0-9a-zA-Z]","");
        return isPalindrome(s,0,s.length() - 1);
    }

    public static boolean isPalindrome(String s, int i, int j)
    {
        if(i >= j)
            return true;
        else if(s.charAt(i) != s.charAt(j))
            return false;
        return isPalindrome(s, i+1, j-1);
    }
}