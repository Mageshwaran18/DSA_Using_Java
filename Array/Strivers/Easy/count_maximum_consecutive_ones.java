package Array.Strivers.Easy;


import java.util.*;

/* LeetCode :- 485 https://leetcode.com/problems/max-consecutive-ones/description/ */

/* Optimal approach --> If the ones appear consectively then increase the count and compare with the result 
 *                  --> If it's zeros , then make the count as zero 
*/

class count_maximum_consecutive_ones{

    public static int count_maximum_consecutive_ones(int arr[])
    {
        int count = 0 , res = 0 , n = arr.length;
        for(int i = 0 ; i < n ;i++)
        {
            if(arr[i]==1)
            {
                count++;
            }
            else
            {
                count = 0;
            }

            res = Math.max(count,res);
        }
        return res;
    }


    public static void main(String[] args) {


        int[] arr = {1, 1, 0, 1, 1, 1, 0, 1, 1};
        int result = count_maximum_consecutive_ones(arr);
        System.out.println("Maximum consecutive ones: " + result);
    }
}