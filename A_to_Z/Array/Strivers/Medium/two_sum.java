package Array.Strivers.Medium;

import java.util.HashMap;
import java.util.Map;

/* LeetCode :- 1 https://leetcode.com/problems/two-sum/description/ */

/* 
 * Easy approach calculate the remainder portion required , if you found return it's value and the current i 
 * Else store the incoming nums[i] as key and it's index as value
 * Time Complexity :- O(n) */

public class two_sum {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer,Integer>hm = new HashMap<>();
        int arr[] = new int[2];
        int rem = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            rem = target-nums[i];
            if(hm.containsKey(rem))
            {
                arr[0]=hm.get(rem);
                arr[1]=i;
                return arr;
            }
            else
            {
                hm.put(nums[i],i);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        two_sum solution = new two_sum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}