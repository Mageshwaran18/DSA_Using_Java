package Linked_List;


/* LeetCode No:- 83 */

public class remove_duplicates {

    public static void main(String[] args) {
        
        Linked_List list = new Linked_List();
        list.append(1);
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(3);
        list.display("Before the removal :- ");
        list.remove_duplicates();
        list.display("After the removal :- ");
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

    public void display(String s)
    {
        ListNode temp = head;
        System.out.print(s);
        while(temp!=null)
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void remove_duplicates()
    {
        if(head!=null && head.next!=null)
        {
            ListNode prev = head;
            ListNode cur = head.next;

            while(cur!=null)
            {
                if(prev.data==cur.data)
                {
                    prev.next = cur.next; /* If it's a duplicate then we don't want to move the prev because the next of cur may also be duplicate */
                }
                else
                {
                    prev = prev.next; /*If it's not duplicate then we can move the previous */
                }
                cur = cur.next;
            }
        }

    }

}
