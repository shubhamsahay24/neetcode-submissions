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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if(list1==null)
            return list2;
        else if(list2==null)
            return list1;
        ListNode tail1 = list1;
        ListNode tail2 = list2;
        ListNode res = null;
        if(tail2.val < tail1.val) {
            res = tail2;
            tail2 = tail2.next;
        } else {
            res = tail1;
            tail1 = tail1.next;
        }
        ListNode tail = res;

        while(tail1!=null && tail2!=null) {
            if(tail2.val < tail1.val) {
                tail.next = tail2;
                tail = tail.next;
                tail2 = tail.next;
            } else {
                tail.next = tail1;
                tail = tail.next;
                tail1 = tail1.next;
            }
        }

        while(tail1!=null) {
            tail.next = tail1;
            tail = tail.next;
            tail1 = tail1.next;
        }
        while(tail2!=null) {
            tail.next = tail2;
            tail = tail.next;
            tail2 = tail2.next;
        }

        return res;

    }
}