// https://leetcode.com/problems/merge-k-sorted-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        
        return mergeLists(0, lists.length-1, lists);
    }
    
    private ListNode mergeLists(int i, int j, ListNode[] lists) {
        if(i == j) return lists[i];
        
        int mid = i + (j - i) / 2;
        
        ListNode left = mergeLists(i, mid, lists);
        ListNode right = mergeLists(mid+1, j, lists);
        
        return merge(left, right);
    }
    
    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        
        while(n1 != null || n2 != null) {
            if(n1 == null) {
                curr.next = n2;
                n2 = n2.next;
            } else if(n2 == null) {
                curr.next = n1;
                n1 = n1.next;
            } else if(n1.val < n2.val) {
                curr.next = n1;
                n1 = n1.next;
            } else {
                curr.next = n2;
                n2=  n2.next;
            }
            
            curr = curr.next;
        }
        
        return head.next;
    }
}
