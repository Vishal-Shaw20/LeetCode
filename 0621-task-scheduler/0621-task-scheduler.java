class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(char ch : tasks)
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        for(int value : map.values())
            maxHeap.offer(value);
        int count = 0;
        while(!maxHeap.isEmpty())
        {
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i <= n; i++)
            {
                Integer temp = maxHeap.poll();
                if(temp != null && temp > 1)
                    list.add(--temp);
                if(!maxHeap.isEmpty() || !list.isEmpty())
                    count++;
            }
            list.forEach(value -> maxHeap.offer(value));
        }
        return ++count;
    }
}