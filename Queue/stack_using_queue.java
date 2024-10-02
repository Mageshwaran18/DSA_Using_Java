package Queue;

import java.util.*;


/* LeetCode No :- 225 */

/*
 * Optimal Approach :-  --> Refer the Queue notes
 *                      --> Create two Queue's q1 , q2 
 *                      --> Add the elements to the q2 
 *                      --> Pop the elements from the q1 and add it to the q2
 *                      --> Swap q1 and q2 using the temp variable 
 *                      --> Repeat the process till the end of the arr.
 *                      --> Time complexity :- O(n) --> push , O(1) --> pop , peek , isEmpty();
 * 
 */


/*The error in the line Queue <Integer> q1 = new Queue<Integer>(); is that Queue is an interface in Java, not a concrete class. You cannot directly instantiate an interface using the new keyword.

To fix this, you need to use a concrete implementation of the Queue interface, such as LinkedList or ArrayDeque. */


public class stack_using_queue {


    public static void main(String[] args) {
        
        int arr [] = {1,20,5,8,100};
        int n = arr.length;

        Queue <Integer> q1 = new LinkedList<>();
        Queue <Integer> q2 = new LinkedList<>();
        Queue <Integer> temp = new LinkedList<>();

        for(int i = 0 ; i < n ; i++)
        {
            q2.offer(arr[i]);
            
            while(!q1.isEmpty())
            {
                q2.offer(q1.poll());
            }
            temp = q2;
            q2 = q1;
            q1 = temp;
        }

        System.out.println(q1);

    }
}
