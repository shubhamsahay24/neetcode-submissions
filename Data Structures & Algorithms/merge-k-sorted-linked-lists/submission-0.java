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
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a,b) -> a.val - b.val);
        
        for(ListNode node : lists) {
            if(node!=null)
                pq.add(node);
        } // Added only head noders of each LinkedLists
        // TC -> O(n log k)
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

// pq -> [1] [1] [3]
        while(!pq.isEmpty()) {
            ListNode temp = pq.peek();
            pq.poll();
            curr.next = temp;
            curr = curr.next;
            temp = temp.next;
            if(temp!=null)
                pq.add(temp);
        }
        return dummy.next;
    }
}
