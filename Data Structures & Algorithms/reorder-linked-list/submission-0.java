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
    public void reorderList(ListNode head) {
        
        ListNode tail = head;
        int size=0;
        while(tail!=null) {
            size++;
            tail = tail.next;
        }
        tail = head;
        int half = 0;
        if(size%2==0) {
            half = size/2;
        } else {
            half = (size/2) + 1;
        }
        int currCount=0;
        while(currCount < half)
        {
            tail = tail.next;
            currCount++;
        }
        tail = reverseList(tail);

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        ListNode curr = head;
        currCount=0;
        while(tail!=null) {
            if(currCount%2==0) {
                temp.next = curr;
                curr = curr.next;
            } else {
                temp.next = tail;
                tail = tail.next;
            }
            temp = temp.next;
            currCount++;
        }
        System.out.println(temp.val);
        if(size%2!=0) {
            temp.next = curr;
            temp = temp.next;
            temp.next = null;
        }


    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

}
