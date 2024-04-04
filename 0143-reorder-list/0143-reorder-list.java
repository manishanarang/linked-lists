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
        if(head == null || head.next == null){
            return;
        }
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;
        }
        ListNode second = reverse(slow.next);
        slow.next = null;

        ListNode first = head;
        

        while(second!=null){
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            first.next = second;
            second.next = firstNext;
            first = firstNext;
            second = secondNext;
        }

    }

    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr = head;

        while(curr!=null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev=curr;
            curr=nextNode;
        }
        return prev;
    }

}