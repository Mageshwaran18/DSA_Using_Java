package Linked_List;

import java.util.List;


/*
 * LeetCode No: 234
*/

/*
 * Brut Force --> Create the reversed version of the incoming linked list 
 *            --> Use Two pointers approch from the start of both the linked list and check whether they're same or not 
 *            --> Time Complexity:- O(N) --> For reversing the linked list and checking it 
 * 
 * Optimal    --> Reverse the linked list from the linkedlist next node from the middle node. 
 *            --> Use Two pointers approch from the start of both the linked list and check whether they're same or not 
 *            --> If the length of the linked list is even then firsthalf and secondhalf will have the same node , but if not then we can take secondhalf after the median node
 *            --> Check till the end of the second linked list becuase the length of the second linked list will be small(total length is odd) or equal 
 *            --> Time Complexity:- O(N/2)
 */

class check_palindrome{
    public static void main(String[] args) {
        Linked_List list = new Linked_List();

        list.append(11);
        list.append(12);
        list.append(13);
        list.append(15);
        list.append(14);
        list.append(13);
        list.append(12);
        list.append(11);
        list.display();
        if(list.isPalindrome())
        {
            System.out.println("It's an Palindrome");
        }
        else
        {
            System.out.println("It's not an Palindrome");
        }
    }
}

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class Linked_List
{
    ListNode head;

    public void append(int data)
    {
        ListNode nn = new ListNode(data);
        if(head==null)
        {
            head = nn;
            return;
        }
        ListNode temp = head;
        while(temp.next!=null)
        {
            temp = temp.next;
        }
        temp.next = nn;
    }

    public void display()
    {
        ListNode temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public  boolean isPalindrome()
    {
        ListNode firsthalf = head;

        /* Find the median of the linked list */

        ListNode slow = firsthalf;
        ListNode fast = firsthalf;

        while(fast.next!=null && fast.next.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondhalf = slow.next;// The node from the median is the second half

        /* Reverse the second half  */

        ListNode prev = null;
        ListNode cur = secondhalf;
        ListNode nextt = secondhalf;

        while(cur!=null)
        {
            nextt= cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextt;
        }

        secondhalf = prev;

        ListNode temp = secondhalf;
        while(temp!=null)
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");

        ListNode ptr1 = firsthalf;
        ListNode ptr2 = secondhalf;

        while(ptr2!=null) /* Secondhalf will always be smaller(length) than the firsthalf */
        {
            if(ptr1.data!=ptr2.data)
            {
                return false;
            }

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return true;
    }

}





