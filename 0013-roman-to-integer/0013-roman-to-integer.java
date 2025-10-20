class Solution {
    public int romanToInt(String s) 
    {
        int num = 0, rem = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(i < (s.length() - 1) && map(ch) < map(s.charAt(i + 1)))
                num -= map(ch);
            else 
                num += map(ch);
        }
        return num;
    }
    public int map(char ch)
    {
        return switch (ch)
        {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}