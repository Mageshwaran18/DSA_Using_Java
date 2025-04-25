package SlidingWindow_and_TwoPointers;
import java.util.*;

/* LeetCode :- 560 https://leetcode.com/problems/subarray-sum-equals-k/description/ */

public class subarray_sum_equals_k {

    public int subarraySum(int[] a, int k)
    {
        int sum = 0;
        int rem = 0;
        int count = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int i = 0; i < a.length ; i++)
        {
            sum += a[i];
            rem = sum - k;
            if(hm.get(rem)!=null)
            {
                count+=hm.get(rem);
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        subarray_sum_equals_k solution = new subarray_sum_equals_k();
        int[] arr = {1, 2, 3};
        int k = 3;
        System.out.println("Number of subarrays with sum " + k + ": " + solution.subarraySum(arr, k));
    }

    
}
