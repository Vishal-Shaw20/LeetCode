class StockSpanner {

    Deque<int[]> stack = new ArrayDeque<>();
    int index;

    public StockSpanner() {
        index = -1;
        stack.clear();
    }
    
    public int next(int price) {
        index += 1;
        while(!stack.isEmpty() && stack.peek()[0] <= price)
            stack.pop();
        int n = index - ((stack.peek() == null)? -1 : stack.peek()[1]);
        stack.push(new int[]{price,index});
        return n;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */