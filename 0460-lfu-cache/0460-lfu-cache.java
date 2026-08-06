class LFUCache {

    Map<Integer, Node> map = new HashMap<>();
    Map<Integer, DLL> freqtodll = new HashMap<>();
    int capacity;
    int minFreq = Integer.MAX_VALUE;

    class Node
    {
        int key;
        int value;
        int freq;
        Node next;
        Node prev;

        Node(int key, int value)
        {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DLL
    {
        Node head;
        Node tail;

        DLL()
        {
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next = tail;
            tail.prev = head;
        }

        public void addFirst(Node temp)
        {
            temp.next = head.next;
            head.next = temp;
            temp.prev = head;
            temp.next.prev = temp;
        }

        public void remove(Node temp)
        {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node temp = map.get(key);
        if(temp == null)
            return -1;
        update(temp);
        return temp.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0 && map.isEmpty())
            return;
        Node temp = map.get(key);
        if(temp != null)
        {
            update(temp);
            temp.value = value;
        }
        else
        {
            if(capacity > 0)
            {
                capacity--;
            }
            else
            {
                DLL tempDLL = freqtodll.get(minFreq);
                Node last = tempDLL.tail.prev;
                map.remove(last.key);
                tempDLL.remove(last);
                checkDLL(minFreq);
            }
            temp = new Node(key,value);
            map.put(key, temp);
            check(1, temp);
            minFreq = 1;
        }
    }

    public void check(int freq, Node temp)
    {
        if(freqtodll.containsKey(freq))
            freqtodll.get(freq).addFirst(temp);
        else
        {
            DLL tempDLL = new DLL();
            freqtodll.put(freq, tempDLL);
            tempDLL.addFirst(temp);
        }
    }

    public void checkDLL(int freq)
    {
        DLL tempDLL = freqtodll.get(freq);
        if(tempDLL.head.next == tempDLL.tail)
        {    
            freqtodll.remove(freq);
            if(freq == minFreq)
                minFreq++;
        }
    }

    public void update(Node temp)
    {
        freqtodll.get(temp.freq).remove(temp);
        checkDLL(temp.freq);
        temp.freq++;
        check(temp.freq, temp);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */