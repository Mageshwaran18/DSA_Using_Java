package Stack;
import java.util.*;

/* LeetcCode No  :- 496 */

/* for next greatest element --> for(int i = n -1 ; i > 0 ; i--)
 * for previous greatest element --> for(int i = 0 ; i < n ; i++)
 */

/*
 * Brute force approach --> Run two for loops and return the result 
 * 
 * Optimal approach --> Stack implementation , Backward approach
 *                  --> If stack is empty , res[i] = -1
 *                  --> If stack is not empty && peek element is greater than arr[i] , then res[i] is peek element
 *                  --> If stack is not empty && peek element is lesser than arr[i] , pop the stack .[ repeat it]
 *                  --> For all the senarios push the incoming element.arr[i].
 */

public class next_greatest 
{


    public static void next_greatest(int [] arr,int n )
    {
        Stack<Integer> st = new Stack<>();
        int top = 0;
        int [] res = new int[n];
        for(int i = n-1 ; i >= 0 ; i--)
        {
            while(!st.empty() && st.peek()<arr[i])
            {
                st.pop();
            } 
            if(!st.empty())
            {
                res[i]=st.peek();
            }
            else
            {
                res[i]=-1;
            }
            st.push(arr[i]);
        }
        for(int i =0 ; i< n; i++)
        {
            System.out.print(res[i] + " ");
        }
    }

    public static void main(String[] args) {

        int [] arr = {1,2,1};
        int n = arr.length;
        next_greatest(arr,n);
        
    }


    
}
