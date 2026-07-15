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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right){
            return head;
        }

        ListNode prev =null;
        ListNode curr = head;

        for(int i=0;i<left-1;i++){
           prev = curr;
           curr = curr.next;
        }

        ListNode connection = prev ; 
        ListNode tail = curr;

        for(int i = 0;i<right - left +1;i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next ;
        }

        //stablish first connection
        if(connection!=null){
            connection.next = prev;
        }
        else{
            head=  prev;
        }

        tail.next = curr;
        return head;
    }
}