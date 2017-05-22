/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

public class Solution {


    public ListNode deleteDuplicates(ListNode head) {
        ListNode pNode;
        ListNode curNode = head;
        if (curNode != null) {
            pNode = curNode.next;
            while (pNode != null) {
                if (pNode.val == curNode.val) {
                    curNode.next = pNode.next;
                }
                else{
                    curNode.next = pNode;
                    curNode = pNode;
                }

                pNode = pNode.next;
            }
        }
        return head;
    }

    public static void main(String args[]) {

        Solution solution = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;

        solution.deleteDuplicates(n1);
        System.out.println(n2.next);

    }
}