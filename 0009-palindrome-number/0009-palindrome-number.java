class Solution {
    public boolean isPalindrome(int x)
    {
        String dup = Integer.toString(x), n = Integer.toString(x);
        return (dup.equals(reverse(n, n.length() - 1)));
    }

    public String reverse(String n, int l)
    {
        if(l < 0)
            return "";
        return (n.charAt(l) + reverse(n, l - 1));
    }
}