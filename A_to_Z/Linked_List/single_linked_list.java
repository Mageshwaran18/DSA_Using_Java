package Linked_List;
public class single_linked_list {

    Node head;

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

    public void display(single_linked_list list)
    {
        Node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");


    }

    public void delete(int target)
    {
        Node cur = head;
        if(head.data==target)
        {
            head=head.next;
            cur.next=null;
        }
        else
        {
            cur = cur.next;
            Node prev = head;
            while(cur!=null)
            {
                if(cur.data==target)
                {
                    prev.next=cur.next;
                    cur.next=null;
                }
                prev = cur;
                cur=cur.next;
            }
        }

    }

    public static void main(String[] args) 
    {
        single_linked_list list = new single_linked_list();
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);
        list.append(50);
        list.display(list);
        list.delete(60);
        list.display(list);
    }
    
}
