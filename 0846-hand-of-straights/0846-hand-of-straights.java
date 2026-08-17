class Solution {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if((hand.length % groupSize) != 0)
            return false;
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for(int key : hand)
            map.put(key, map.getOrDefault(key, 0) + 1);
        for(int key : hand)
        {
            if(map.get(key) == 0)
                continue;
            for(int i = 0; i < groupSize; i++)
            {
                if(map.getOrDefault(key + i, 0) == 0)
                    return false;
                map.put(key + i, map.get(key + i) - 1);
            }
        }
        return true;
    }
}