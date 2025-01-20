class Solution {
    public int lengthOfLastWord(String s) {
        String str = s.trim();
        int length = 0, i = str.length() - 1;
        while(i >= 0 && str.charAt(i) != ' ')
        {
            length++;
            i--;
        }
        return length;
    }
}