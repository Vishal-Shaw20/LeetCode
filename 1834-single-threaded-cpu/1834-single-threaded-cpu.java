class Solution {

    class Task
    {
        int eTime;
        int pTime;
        int index;

        Task(int eTime, int pTime, int index)
        {
            this.eTime = eTime;
            this.pTime = pTime;
            this.index = index;
        }
    }

    public int[] getOrder(int[][] tasks) {
        int i = 0, completed = 0, time = 0, n = tasks.length, k = 0;
        Task[] arr = new Task[n];
        for(int j = 0; j < n; j++)
            arr[j] = new Task(tasks[j][0], tasks[j][1], j);
        Arrays.sort(arr, (a,b) -> Integer.compare(a.eTime, b.eTime));
        PriorityQueue<Task> pq = new PriorityQueue<>((a,b) -> {
            if(a.pTime != b.pTime)
                return Integer.compare(a.pTime, b.pTime);
            return Integer.compare(a.index, b.index);
        });
        int[] ans = new int[n];
        while(completed < n)
        {
            while(i < n && arr[i].eTime <= time)
                pq.offer(arr[i++]);
            if(pq.isEmpty())
            {
                time = arr[i].eTime;
                continue;
            }
            Task curr = pq.poll();
            ans[k++] = curr.index;
            time += curr.pTime;
            completed++;
        }
        return ans;
    }
}