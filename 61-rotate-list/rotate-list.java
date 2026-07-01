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

    public ListNode findNthNode(ListNode head, int k) {
        int count =1;
        ListNode temp = head;
        while(count<k) {
            temp = temp.next;
            count++;
        } 
        return temp;
    }
    public ListNode rotateRight(ListNode head, int k) {

        int len = 1;
        ListNode temp = head;

       if(head==null || head.next==null) return head;

        while(temp.next!=null) {
            temp = temp.next;
            len++;
        }
        //circular
        temp.next =head;

        if(k==0) {
         temp.next = null;
          return head;
         }
       
        if(k%len==0) {
             temp.next = null;   // break cycle
             return head;
        }
          k = k % len;
        
         ListNode newnode = findNthNode(head, len-k);
         ListNode newhead = newnode.next;
         newnode.next = null;

           return newhead;

     }
}