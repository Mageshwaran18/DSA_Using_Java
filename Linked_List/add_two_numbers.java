package Linked_List;


/* LeetCode No:- 2 */

/*
 * Brutforce approach --> Traverse through the linked list generate two numbers , add two numbers , using the generate digit create another linkedlist
 *                    --> Time Complexity O(3(l1+l2))
 * 
 * Optimal approach   --> Create an total , carry  variable and result linkedlist.
 *                    --> Assign carry as 0 and carry to total;
 *                    --> Traverse throught the linked list untill both the pointers becomes null.Add the data of eachnodes val to the total 
 *                    --> To get the digit total%10 , and add the result to the new linked list
 *                    --> To get the carry do total/10.
 */

public class add_two_numbers {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            ListNode temp = head;
            int carry = 0, total = 0, rem = 0;

            /* carry!= If both the pointers l1 and l2 points to the null but still there is an carry we need to create an node and assign that to the head.next  */
            while(l1 != null || l2 != null || carry != 0) {
                total = carry;
                if(l1 != null) {
                    total += l1.val;
                    l1 = l1.next;
                }
                if(l2 != null) {
                    total += l2.val;
                    l2 = l2.next;
                }
                rem = total % 10;
                ListNode nn = new ListNode(rem);
                head.next = nn;
                head = head.next;
                carry = total / 10;
            }
            return temp.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
