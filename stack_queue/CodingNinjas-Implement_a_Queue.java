// https://www.codingninjas.com/codestudio/problems/2099908?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class Queue {
    Node head, last;
    
    Queue() {
        head = null;
        last = null;
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        return head == null;
    }

    void enqueue(int data) {
        if(head == null){
            head = new Node(data);
            last = head;
        } else {
            last.next = new Node(data);
            last = last.next;
        }
    }

    int dequeue() {
        if(head == null) return -1;
        
        int data = head.data;
        head = head.next;
        
        return data;
    }

    int front() {
        if(head == null) return -1;
        
        return head.data;
    }
}

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
