class Solution {
    int c = 0;
    public int numberOfSteps(int num) {
        if(num == 0)
            return c;
        if((num & 1) == 0)
            num/= 2;
        else
            num-= 1;
        ++c;
        return numberOfSteps(num);
    }
}