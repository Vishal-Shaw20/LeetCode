class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) 
    {
        int emptyBottles = 0, drankBottles = 0;
        while(numBottles != 0)
        {
            emptyBottles += numBottles;
            drankBottles += numBottles;
            numBottles = 0;
            while(emptyBottles >= numExchange)
            {
                numBottles++;
                emptyBottles -= numExchange++;
            }
        }
        return drankBottles;
    }
}