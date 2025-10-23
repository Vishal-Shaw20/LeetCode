class Solution {
    public boolean hasSameDigits(String s) 
    {
        int n = s.length();
        char[] arr = s.toCharArray();
        for(int i = 0; i < (n - 2); i++)
        {
            for(int j = 0; j < (n - i - 1); j++)
            {
                int digit1 = (char)(arr[j] - '0');
                int digit2 = (char)(arr[j + 1] - '0');
                arr[j] = (char)((digit1 + digit2) % 10);
            }
        }
        return (arr[0] == arr[1]);
    }
}