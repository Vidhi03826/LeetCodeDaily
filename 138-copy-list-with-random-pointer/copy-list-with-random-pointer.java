/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node newHead = new Node(head.val);
        Node oldTemp = head.next;
        Node newTemp = newHead;
        HashMap<Node, Node> mp = new HashMap<>();
        mp.put(head, newHead);
        while(oldTemp!=null){
            Node copyNode = new Node(oldTemp.val);
            newTemp.next = copyNode;
            mp.put(oldTemp, copyNode);
            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        oldTemp = head;
        newTemp = newHead;
        while(oldTemp!=null){
            newTemp.random = mp.get(oldTemp.random);
            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }
        return newHead;
    }
}