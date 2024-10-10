package Stack;
import java.util.*;
import java.util.Stack;

/* LeetCode No :- 84  */

/*  
 * Problem :- To find the maximum area of the rectange , where the base unit is always 1
 * 
 * Brute Force :- --> Take the first example of leetcode 
 *                --> If you're in the index 0 , you can't move further as it goes to the height of 1 ( lesser than the current height)
 *                --> If you're in the index 2 , you can move further as the next element is greater than the current height 6 but you can't move further because after 6 there is a smaller element 2 , if we include this bar then the height rectangle will be reduced 
 *                --> To increase the area from the index 2 we can't move forward also as moving behind the index 2 (5) will lead to reach the lowest value 1 (which will reduce the height of the rectangle).
 *                --> So we can conclude that from a specific point we can move forward untill we reach the next minimum element
 *                --> So we can conclude that from a specific point we can move backwards untill we reach the previous minium element
 *                --> We can find the height of the rectangle using the arr[i] which the represents the height of the rectangle
 *                --> We need to find the width of the rectangle which can be done by (next_smallest_element(position) - previous_smallest_element(position) -1)
 *                --> Area of the rectangle = arr[i] * (next_smallest_element(position) - previous_smallest_element(position) -1)
 * 
 */


public class larges_rectangle_histogram {

    public static int[] next_smallest_element(int arr[],int n)
    {
        Stack <Integer> st = new Stack<>();
        int[] res = new int[n]; 

        for(int i = n -1 ; i >= 0 ; i--)
        {
            while(!st.empty() && st.peek() > arr[i])
            {
                st.pop();
            }
            if(!st.empty())
            {
                res[i] = st.peek();
            }
            else
            {
                res[i]=-1;
            }
            st.push(arr[i]);
        }
        System.out.print("Next Smallest Element :- ");
        for(int i =0 ; i< n; i++)
        {
            System.out.print(res[i] + " ");
        }
        System.out.println();
        return res;


    }

    public static int[] previous_smallest_element(int arr[],int n)
    {
        Stack <Integer> st = new Stack<>();
        int[] res = new int[n]; 

        for(int i = 0 ; i <  n ; i++)
        {
            while(!st.empty() && st.peek() > arr[i])
            {
                st.pop();
            }
            if(!st.empty())
            {
                res[i] = st.peek();
            }
            else
            {
                res[i]=-1;
            }
            st.push(arr[i]);
        }
        System.out.print("Previous Smallest element :- ");
        for(int i =0 ; i< n; i++)
        {
            System.out.print(res[i] + " ");
        }
        System.out.println();

        return res;


    }
    public static void main(String[] args) {

        int [] arr =  {1,3,4,2};
        int n = arr.length;
        int [] nse = next_smallest_element(arr,n);
        int [] pse = previous_smallest_element(arr,n);
        
    }
    
}
