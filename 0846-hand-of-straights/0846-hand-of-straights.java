class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if((hand.length % groupSize) != 0)
            return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int val : hand)
            map.put(val, map.getOrDefault(val, 0) + 1);
        while(!map.isEmpty())
        {
            int key = map.firstKey();
            decrease(map, key);
            for(int i = 1; i < groupSize; i++)
            {
                if(!map.containsKey(key + i))
                    return false;
                decrease(map, key + i);
            }
        }
        return true;
    }
    public void decrease(Map<Integer, Integer> map, int key)
    {
        if(map.get(key) == 1)
            map.remove(key);
        else
            map.put(key, map.get(key) - 1);
    }
}