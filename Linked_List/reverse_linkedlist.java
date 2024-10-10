package Linked_List;

public class reverse_linkedlist {

    class Node 
    {
        int data ; 
        Node next;

        public Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }

    Node head;

    public void append(int data)
    {
        Node new_Node = new Node(data);
        if(head==null)
        {
            head = new_Node;
        }
        else
        {
            Node temp = head;
            while(temp.next!=null)
            {
                temp = temp.next;
            }
            temp.next=new_Node;
        }
    }

    public void display(reverse_linkedlist list)
    {
        Node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    
    public void reverse(reverse_linkedlist list)
    {
        Node cur = list.head;
        Node nextt = list.head;
        Node prev = null;

        while(cur!=null)
        {
            nextt = cur.next;
            cur.next = prev;
            prev = cur ; 
            cur = nextt;
        }

        list.head = prev;

    }



    public static void main(String[] args)
    {
        reverse_linkedlist rl = new reverse_linkedlist();
        rl.append(1);
        rl.append(2);
        rl.append(3);
        rl.append(4);
        rl.append(5);
        // rl.display(rl);
        rl.reverse(rl);
        rl.display(rl);
    }
    
}
