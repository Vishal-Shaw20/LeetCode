class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> Integer.compare(b[1],a[1]));
        int countBox = 0, countUnit = 0, i = 0, l = boxTypes.length;
        while(i < l)
        {
            if((countBox + boxTypes[i][0]) <= truckSize)
            {
                countBox += boxTypes[i][0];
                countUnit += boxTypes[i][0] * boxTypes[i][1];
            }
            else
            {
                countUnit +=  (truckSize - countBox) * boxTypes[i][1];
                countBox = truckSize;
                return countUnit;
            }
            i++;
        }
        return countUnit;
    }
}