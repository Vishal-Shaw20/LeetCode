class Solution {
    public int countDigitOne(int n) {
        int s = 0, place = 1, high, curr, low;
        while(place <= n)
        {
            high = n / (place * 10);
            curr = (n / place) % 10;
            low = n % place;
            if(curr == 0)
                s+= (high * place);
            else if(curr == 1)
                s+= (high * place) + low + 1;
            else
                s+= (high + 1) * place;
            place*= 10;
        }
        return s;
    }
}