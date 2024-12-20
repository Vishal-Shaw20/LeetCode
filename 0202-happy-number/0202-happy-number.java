class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        while(fast != 1 && slow != 1)
        {
            slow = square(slow);
            fast = square(square(fast));
            if(fast == slow && fast != 1)
                return false;
        }
        return true;
    }
    
    public int square(int n)
    {
        int s = 0;
        while(n != 0)
        {
            int r = n % 10;
            s+= (r * r);
            n/= 10;
        }
        return s;
    }
}