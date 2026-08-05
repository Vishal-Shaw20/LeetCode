class LRUCache {

    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;

    class Node
    {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map.clear();
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            Node temp = map.get(key);
            remove(temp);
            addFirst(temp);
            return temp.value;
        }
        else
            return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node temp = map.get(key);
            temp.value = value;
            remove(temp);
            addFirst(temp);
        }
        else
        {
            Node temp = new Node(key,value);
            map.put(key, temp);
            if(capacity > 0)
            {
                addFirst(temp);
                capacity--;
            }
            else
            {
                map.remove(tail.prev.key);
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
                addFirst(temp);
            }
        }
    }
    public void addFirst(Node temp)
    {
        temp.next = head.next;
        temp.prev = head;
        head.next = temp;
        temp.next.prev = temp;
    }
    public void remove(Node temp)
    {
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */