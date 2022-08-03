// https://leetcode.com/problems/min-stack/
class MinStack {
    private Node head;
    private Node minHead;
    
    public MinStack() {
        head = null;
        minHead = null;
    }
    
    public void push(int val) {
        if(head == null) {
            head = new Node(val, null);
            minHead = new Node(val, null);
        } else {
            head = new Node(val, head);
            minHead = new Node(Math.min(val, getMin()), minHead);
        }
    }
    
    public void pop() {
        minHead = minHead.next;
        head = head.next;
    }
    
    public int top() {
        if(head == null) return 0;
        
        return head.val;
    }
    
    public int getMin() {
        if(minHead == null) return Integer.MAX_VALUE;
        
        return minHead.val;
    }
}

class Node {
    int val;
    Node next;
    
    Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
