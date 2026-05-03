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
    public boolean hasCycle(ListNode head) {

        ListNode tail1 = head;
        ListNode tail2 = head;

        while(tail2!=null && tail2.next!=null) {
            
            tail1 = tail1.next;
            tail2 = tail2.next.next;
            if(tail1==tail2)
                return true;
        }
        return false;
        
    }
}
