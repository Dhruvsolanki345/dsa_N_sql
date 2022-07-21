// https://leetcode.com/problems/lru-cache/
class LRUCache {
    HashMap<Integer, Node> map;
    Node head, tail;
    int capacity;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        
        Node curr = map.get(key);
        remove(curr);
        insert(curr);
        return curr.data;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        } else if(map.size() == capacity){
            remove(tail.prev);
        }
        
        insert(new Node(key, value));
    }
    
    private void insert(Node node){
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    private void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class Node{
    int key, data;
    Node next, prev;
    
    Node(int key, int data){
        this.key = key;
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
