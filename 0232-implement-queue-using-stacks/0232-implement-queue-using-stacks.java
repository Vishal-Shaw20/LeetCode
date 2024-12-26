class MyQueue {

    int[] stack1;
    int[] stack2;
    int top1 = -1;
    int top2 = -1;

    public MyQueue() {
        stack1 = new int[100];
        stack2 = new int[100];
    }

    public void push(int x) {
        stack1[++top1] = x;
    }

    public int pop() {
        if(empty())
            return -1;
        while(top1 != -1)
        {
            stack2[++top2] = stack1[top1--];
        }
        int n = stack2[top2];
        top2-= 1;
        while(top2 != -1)
        {
            stack1[++top1] = stack2[top2--];
        }
        return n;
    }

    public int peek() {
        if(empty())
            return -1;
        while(top1 != -1)
        {
            stack2[++top2] = stack1[top1--];
        }
        int n = stack2[top2];
        while(top2 != -1)
        {
            stack1[++top1] = stack2[top2--];
        }
        return n;
    }

    public boolean empty() {
        if(top1 == -1)
            return true;
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */