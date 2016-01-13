/**2. Add Two Numbers My Submissions Question

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum, nextVal;
        ListNode node, n1, n2;
        nextVal = 0;
        sum = 0;
        
        node = new ListNode(0);
        n2 = node;
        
        while( l1 != null || l2 != null || nextVal != 0){
            
            if(l1 == null && l2 == null)
            sum = nextVal;  
            else if(l1 == null)
            sum = l2.val+ nextVal;
            else if (l2 == null)
            sum = l1.val + nextVal;
            else
            sum = l1.val + l2.val + nextVal;
            
                     
            
            nextVal = sum/10;
            sum =sum%10;
            
            n1 = n2;
            n2 = new ListNode(sum);
            n1.next = n2;
            
            if(l1!= null)
            l1 = l1.next;
            
            if(l2 != null)
            l2 = l2.next;
        }
        
        return node.next;
    }
}






