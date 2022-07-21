// https://leetcode.com/problems/implement-queue-using-stacks/
class MyQueue {
    Stack<Integer> input, output;
    
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        if(output.empty() && input.empty()) return -1;
        
        if(output.empty()){
            while(!input.empty()) output.push(input.pop());
        }
        
        return output.pop();
    }
    
    public int peek() {
        if(output.empty() && input.empty()) return -1;
        
        if(output.empty()){
            while(!input.empty()) output.push(input.pop());
        }
        
        return output.peek();
    }
    
    public boolean empty() {
        return output.empty() && input.empty();
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
