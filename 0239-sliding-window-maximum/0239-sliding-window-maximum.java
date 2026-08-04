class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int i = 0;
        int[] max = new int[nums.length - k + 1];
        while(i != nums.length)
        {
            if(!queue.isEmpty() && queue.peek() == (i - k))
                    queue.poll();
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
                queue.pollLast();
            queue.offer(i);
            if(i >= (k - 1))
                max[i - k + 1] = nums[queue.peek()];
            i++;
        }
        return max;
    }
}