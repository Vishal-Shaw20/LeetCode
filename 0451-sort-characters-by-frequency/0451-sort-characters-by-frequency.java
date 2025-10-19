class Solution {
    public String frequencySort(String s) 
    {
        StringBuilder str = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        List<Character>[] buckets = new List[s.length() + 1];
        for(char ch : map.keySet())
        {
            int freq = map.get(ch);
            if(buckets[freq] == null)
                buckets[freq] = new ArrayList<>();
            buckets[freq].add(ch);
        }
        for(int i = s.length(); i > 0; i--)
        {
            if (buckets[i] != null)
            {
                for(char ch : buckets[i])
                {
                    for(int j = 0; j < i; j++)
                        str.append(ch);
                }
            }
        }
        return str.toString();
    }
}