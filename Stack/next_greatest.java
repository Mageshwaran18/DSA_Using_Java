package Stack;
import java.util.*;
import java.util.Stack;

/* LeetcCode No  :- 496 *  (Refer the DSA Notes) /

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


 /*
  * Note :- The below question and the leetcode question is different.
  *
  * My Version for the leetcode problem -->
                class Solution {
                    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

                        HashMap <Integer,Integer> hm = new HashMap<>();
                        Stack <Integer> st = new Stack<>();
                        int n = nums2.length;
                        int[] res = new int[n];
                        for(int i = n-1 ; i >= 0 ; i-- )
                        {
                            while(!st.empty() && st.peek() < nums2[i])
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
                            st.push(nums2[i]);
                            hm.put(nums2[i],res[i]);
                        }
                        for(int i = 0 ; i < nums1.length ; i++)
                        {
                            nums1[i]=hm.get(nums1[i]);
                        }
                        return nums1;
                        
                    }
                    }

* The optimized version for the same above code 
*
*
       class Solution {
            public int[] nextGreaterElement(int[] nums1, int[] nums2) {
                Map<Integer, Integer> nextGreater = new HashMap<>();
                Stack<Integer> stack = new Stack<>();
                
                // Find next greater element for each number in nums2
                for (int num : nums2) {
                    while (!stack.isEmpty() && stack.peek() < num) {
                        nextGreater.put(stack.pop(), num);
                    }
                    stack.push(num);
                }
                
                // Prepare result for nums1
                int[] result = new int[nums1.length];
                for (int i = 0; i < nums1.length; i++) {
                    result[i] = nextGreater.getOrDefault(nums1[i], -1);
                }
                
                return result;
            }
        }

  */

public class next_greatest 
{


    public static void next_greatest(int [] arr,int n )
    {
        Stack<Integer> st = new Stack<>();
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

        int [] arr =  {1,3,4,2};
        int n = arr.length;
        next_greatest(arr,n);
        
    }


    
}
