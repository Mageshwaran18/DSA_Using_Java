package Sliding_Window;

import java.util.Arrays;

/* LeetCode No:- 1838 */

/* Before solving this have a look at Longest Repeating Character with Replacement */



public class frequency_of_the_most_frequent_element {

    public static int solution(int arr[], int k)
    {
        int res = Integer.MIN_VALUE;
        Arrays.sort(arr);
        int left = 0;
        long sum = 0; 
        for(int r = 0; r < arr.length; r++)
        {
            sum += arr[r];
            while(sum + k < (long) arr[r] * (r - left + 1))
            {
                sum -= arr[left];
                left += 1;
            }

            res = Math.max(res, r - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4};
        int k = 5;
        int result = solution(arr, k);
        System.out.println("The frequency of the most frequent element is: " + result);
    }
}
