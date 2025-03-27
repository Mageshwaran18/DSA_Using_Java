package Stack;




public class stack_implementation {

    public static void main(String[] args) {
        
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        st.display("Elements in the stack :- ");
    }
    


}


class Stack
{

    int n = 10;
    int top = -1;
    int [] arr = new int[n];

    public void push(int data)
    {
        if(top==n-1)
        {
            System.out.println("Stack Overflow");
            return ;
        }
        arr[++top]=data;

    }

    public int pop()
    {
        if(top<0)
        {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    public int peek()
    {
        if(top < 0)
        {
            System.out.println("No elements in the stack");
        }

        return arr[top];
    }

    public void display(String s)
    {
        System.out.print(s);
        for(int i = 0 ; i <= top ; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}