// https://leetcode.com/problems/add-two-numbers/
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

//  Multiple while (pass)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1, curr2 = l2, head, curr;
        int carry = 0, sum = 0;
        
        sum = curr1.val + curr2.val;
        if(sum >= 10) carry = 1;
        
        head = new ListNode(sum % 10);
        curr = head;
        curr1 = curr1.next;
        curr2 = curr2.next;
        
        while(curr1 != null && curr2 != null){
            sum = curr1.val + curr2.val + carry;
            carry = (sum >= 10) ? 1 : 0;
            
            ListNode temp = new ListNode(sum % 10);
            curr.next = temp;
            curr = curr.next;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        
        while(curr1 != null){
            sum = curr1.val + carry;
            carry = (sum >= 10) ? 1 : 0;
            
            ListNode temp = new ListNode(sum % 10);
            curr.next = temp;
            curr = curr.next;
            curr1 = curr1.next;
        }
        
        while(curr2 != null){
            sum = curr2.val + carry;
            carry = (sum >= 10) ? 1 : 0;
            
            ListNode temp = new ListNode(sum % 10);
            curr.next = temp;
            curr = curr.next;
            curr2 = curr2.next;
        }
        
        if(carry == 1) curr.next = new ListNode(1);
        
        return head;
    }
}

// Single while (pass)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1, curr2 = l2;
        int carry = 0;
        ListNode res = null, currRes = null;
        
        while(curr1 != null || curr2 != null){
            int sum = carry;
            
            if(curr1 != null) sum += curr1.val;
            if(curr2 != null) sum += curr2.val;
            
            if(sum >= 10) carry = 1;
            else carry = 0;
            
            if(res == null) {
                res = new ListNode(sum % 10);
                currRes = res;
            } else {
                currRes.next = new ListNode(sum % 10);
                currRes = currRes.next;
            }
            
            if(curr1 != null) curr1 = curr1.next;
            if(curr2 != null) curr2 = curr2.next;
        }
        
        if(carry > 0) currRes.next = new ListNode(carry);
        
        return res;
    }
}
