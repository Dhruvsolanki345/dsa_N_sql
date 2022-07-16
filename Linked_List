// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public toString(){
        return val;
    }
}

class Linked_List {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5 };

        Linked_List temp = new Linked_List();
        ListNode head = temp.createByArray(arr);
        temp.printList(head);

    }

    public ListNode createByArray(int[] arr) {
        if (arr.length == 0)
            return null;

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }

        return head;
    }

    public void printList(ListNode node) {
        ListNode curr = node;

        while (curr != null) {
            System.out.print(curr.val + ", ");
            curr = curr.next;
        }
        System.out.println();
    }
}
