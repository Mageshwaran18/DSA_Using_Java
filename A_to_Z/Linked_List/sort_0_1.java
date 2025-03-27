package Linked_List;

public class sort_0_1 {

    Node head;

    class Node 
    {
        int data ; 
        Node next ; 
        public Node(int data)
        {
            this.data=data;
            this.next = null;
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

    public void display(String s ,sort_0_1 list)
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

    public void sort(sort_0_1 ll)
    {
        int count_0=0;
        Node temp = head;
        while(temp!=null)
        {
            if(temp.data==0)
            {
                count_0+=1;
            }
            temp=temp.next;
        }
        temp = head;

        for(int i = 0 ; i < count_0 ;i++)
        {
            temp.data = 0;
            temp = temp.next;
        }

        while(temp!=null)
        {
            temp.data=1;
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        
        sort_0_1 ll = new sort_0_1();
        ll.append(0);
        ll.append(1);
        ll.append(0);
        ll.append(1);
        ll.append(0);
        ll.append(1);
        ll.append(0);
        ll.append(1);
        ll.display("Before Sorting :- ",ll);
        ll.sort(ll);
        ll.display("After Sorting :- ",ll);

    }

    
}
