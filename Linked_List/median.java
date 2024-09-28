package Linked_List;

public class median {
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

    public static void median(median list)
    {
        Node fast = list.head;
        Node slow = list.head;
        while(fast.next!=null && fast.next.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println(slow.data);

    }
    public void display(String s , median list)
    {
        Node temp = head;
        System.out.print(s);
        while(temp!=null)
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    
    public void reverse(median list)
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

    public static void main(String[] args) {
        
        median cp = new median();
        cp.append(11);
        cp.append(12);
        cp.append(13);
        cp.append(14);
        // cp.append(14);
        cp.append(13);
        cp.append(12);
        cp.append(11);
        cp.display("Given Linked list :- ", cp);
        cp.median(cp);



    }
}
