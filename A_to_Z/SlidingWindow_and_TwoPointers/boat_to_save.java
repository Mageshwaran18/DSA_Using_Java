package SlidingWindow_and_TwoPointers;

/* LeetCode :- 881 https://leetcode.com/problems/boats-to-save-people/ */

/* Refer the DSA notes */

import java.util.Arrays;

public class boat_to_save {
    
    public static int boat_to_save(int []arr , int limit)
    {
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length-1;
        int cnt = 0;
        while(l <= r)
        {
            if(arr[l] + arr[r] <= limit)
            {
                l++;
                r--;
            }
            else
            {
                r--;
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] people = {1, 2, 2, 3};
        int limit = 3;
        int result = boat_to_save(people, limit);
        System.out.println("Minimum number of boats required: " + result);
    }
}
