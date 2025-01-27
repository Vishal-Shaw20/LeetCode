class Solution {
    public int findNthDigit(int n) {
        long length = 1, count = 9, start = 1;
        while(n > (length * count))
        {
            n-= (int)(length * count);
            length++;
            count*= 10;
            start*= 10;
        }
        long exact = start + ((n - 1)/length);
        String str = Long.toString(exact);
        int digit = (int)((n - 1) % length);
        return (str.charAt(digit) - '0');
    }
}